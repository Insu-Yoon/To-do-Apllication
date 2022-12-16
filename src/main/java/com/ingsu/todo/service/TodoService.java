package com.ingsu.todo.service;

import com.ingsu.todo.entity.Todo;
import com.ingsu.todo.repository.TodoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoService {
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo findTodo(int todoId) {
        Optional<Todo> optionalTodo = todoRepository.findByTodoId(todoId);
        return optionalTodo.orElseThrow(()-> new RuntimeException("Todo Not found"));
    }

    public Page<Todo> findTodos(int page, int size) {
        return todoRepository.findAll(PageRequest.of(page,size));
    }

    public Todo updateTodo(Todo todo) {
        Todo findTodo = findTodo(todo.getTodoId());

        Optional.ofNullable(todo.getTodoOrder())
                .ifPresent(findTodo::setTodoOrder);
        Optional.ofNullable(todo.getTitle())
                .ifPresent(findTodo::setTitle);
        Optional.ofNullable(todo.getCompleted())
                .ifPresent(findTodo::setCompleted);

        return todoRepository.save(findTodo);
    }

    public void deleteTodo(int todoId) {
        Todo todo = findTodo(todoId);
        todoRepository.delete(todo);
    }

    public void deleteTodos() {
        todoRepository.deleteAll();
    }
}
