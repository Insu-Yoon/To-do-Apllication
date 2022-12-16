package com.ingsu.todo.mapper;

import com.ingsu.todo.dto.PatchDto;
import com.ingsu.todo.dto.PostDto;
import com.ingsu.todo.dto.ResponseDto;
import com.ingsu.todo.entity.Todo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    Todo postDtoToTodo(PostDto PostDto);
    Todo patchDtoToTodo(PatchDto patchDto);
    ResponseDto todoToResponseDto(Todo todo);
    List<ResponseDto> todoToResponseDtos(List<Todo> todos);
}
