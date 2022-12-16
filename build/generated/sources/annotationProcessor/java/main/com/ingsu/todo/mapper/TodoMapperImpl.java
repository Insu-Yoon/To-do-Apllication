package com.ingsu.todo.mapper;

import com.ingsu.todo.dto.PatchDto;
import com.ingsu.todo.dto.PostDto;
import com.ingsu.todo.dto.ResponseDto;
import com.ingsu.todo.entity.Todo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-16T16:27:11+0900",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 11.0.16 (Azul Systems, Inc.)"
)
@Component
public class TodoMapperImpl implements TodoMapper {

    @Override
    public Todo postDtoToTodo(PostDto PostDto) {
        if ( PostDto == null ) {
            return null;
        }

        Todo todo = new Todo();

        todo.setTitle( PostDto.getTitle() );
        todo.setTodoOrder( PostDto.getTodoOrder() );
        todo.setCompleted( PostDto.getCompleted() );

        return todo;
    }

    @Override
    public Todo patchDtoToTodo(PatchDto patchDto) {
        if ( patchDto == null ) {
            return null;
        }

        Todo todo = new Todo();

        todo.setTodoId( patchDto.getTodoId() );
        todo.setTitle( patchDto.getTitle() );
        todo.setTodoOrder( patchDto.getTodoOrder() );
        todo.setCompleted( patchDto.getCompleted() );

        return todo;
    }

    @Override
    public ResponseDto todoToResponseDto(Todo todo) {
        if ( todo == null ) {
            return null;
        }

        ResponseDto responseDto = new ResponseDto();

        responseDto.setTodoId( todo.getTodoId() );
        responseDto.setTitle( todo.getTitle() );
        responseDto.setTodoOrder( todo.getTodoOrder() );
        responseDto.setCompleted( todo.getCompleted() );

        return responseDto;
    }

    @Override
    public List<ResponseDto> todoToResponseDtos(List<Todo> todos) {
        if ( todos == null ) {
            return null;
        }

        List<ResponseDto> list = new ArrayList<ResponseDto>( todos.size() );
        for ( Todo todo : todos ) {
            list.add( todoToResponseDto( todo ) );
        }

        return list;
    }
}
