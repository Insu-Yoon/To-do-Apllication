package com.ingsu.todo.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class PatchDto {
    private int todoId;

    @NotBlank
    private String title;

    private int todoOrder;

    private Boolean completed;

    public void setTodoId(int todoId) {
        this.todoId = todoId;
    }
}
