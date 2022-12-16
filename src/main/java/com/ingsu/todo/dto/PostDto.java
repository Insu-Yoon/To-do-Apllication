package com.ingsu.todo.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class PostDto {
    //할일, order, 완료 여부
    @NotBlank
    private String title;

    private int todoOrder;

    private Boolean completed;
}
