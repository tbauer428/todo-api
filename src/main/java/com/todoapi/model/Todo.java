package com.todoapi.model;


import lombok.Data;

import java.util.UUID;

@Data
public class Todo {
    private String todoText;
    private String id;
}
