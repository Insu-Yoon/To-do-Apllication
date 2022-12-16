package com.ingsu.todo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDto {
    //id, title, order, completed
    private int todoId;
    private String title;
    private int todoOrder;
    private Boolean completed;
}
