package com.ingsu.todo.controller;

import com.ingsu.todo.dto.PatchDto;
import com.ingsu.todo.dto.PostDto;
import com.ingsu.todo.entity.Todo;
import com.ingsu.todo.mapper.TodoMapper;
import com.ingsu.todo.repository.TodoRepository;
import com.ingsu.todo.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

//@RestController
//@RequestMapping("/")
//@CrossOrigin
public class TodoController {
    private TodoService todoService;
    private TodoMapper todoMapper;
    private final TodoRepository todoRepository;

    public TodoController(TodoService todoService, TodoMapper todoMapper,
                          TodoRepository todoRepository) {
        this.todoService = todoService;
        this.todoMapper = todoMapper;
        this.todoRepository = todoRepository;
    }

    // post
    @PostMapping
    public ResponseEntity postTodo(@Valid @RequestBody PostDto postDto) {
        //postDto 받아서, mapper로 Todo로 바꾸고, createTodo에 전달
        Todo todo = todoService.createTodo(todoMapper.postDtoToTodo(postDto));
        //만들었으니, 응답으로 전송
        return new ResponseEntity<>(todoMapper.todoToResponseDto(todo), HttpStatus.CREATED);
    }

    // get
    @GetMapping("/{todo-id}")
    public ResponseEntity getTodo(@PathVariable("todo-id") int todoId) {
        Todo todo = todoService.findTodo(todoId);
        return new ResponseEntity(todoMapper.todoToResponseDto(todo), HttpStatus.OK);
    }

    // getAll
    @GetMapping
    public ResponseEntity getTodos() {
        List<Todo> todos = todoRepository.findAll();
        return new ResponseEntity(todoMapper.todoToResponseDtos(todos), HttpStatus.OK);
    }

    // patch
    @PatchMapping("/{todo-id}")
    public ResponseEntity patchTodo(@PathVariable("todo-id") @Positive int todoId,
                                    @Valid @RequestBody PatchDto patchDto) {
        patchDto.setTodoId(todoId);
        Todo todo = todoService.updateTodo(todoMapper.patchDtoToTodo(patchDto));

        return new ResponseEntity<>(todoMapper.todoToResponseDto(todo), HttpStatus.OK);
    }
    // delete
    @DeleteMapping("/{todo-id}")
    public ResponseEntity deleteTodo(@PathVariable("todo-id") int todoId){
        todoService.deleteTodo(todoId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity deleteTodos(){
        todoService.deleteTodos();
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
