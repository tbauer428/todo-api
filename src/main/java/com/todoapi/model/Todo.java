package com.todoapi.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;


@Data
@AllArgsConstructor
public class Todo {
    private String todoText;
    private String id;
    private boolean completed;

    public Todo(){
        this.todoText = "New Todo";
        this.completed = false;
        this.id = UUID.randomUUID().toString();
    }
}
