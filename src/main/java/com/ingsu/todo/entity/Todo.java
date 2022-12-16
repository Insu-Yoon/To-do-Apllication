package com.ingsu.todo.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int todoId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "todo_order", nullable = false)
    private int todoOrder;

    @Column(name = "completed", nullable = false)
    private Boolean completed;
}
