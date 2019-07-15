package com.todoapi.repository;

import com.todoapi.model.Todo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.*;

public class TodoRepository {

    Map<String, Todo> todoMap = new HashMap<>();

    public Map<String, Todo> getTodos(){
        return todoMap;
    }

    public Todo saveTodo(Todo newTodo){
        var id = UUID.randomUUID().toString();
        newTodo.setId(id);
        todoMap.put(id, newTodo);
        return newTodo;
    }

    public Todo findById(String id){
        var todo = todoMap.get(id);
        if(todo == null){
            throw new TodoNotFoundException();
        }else {
            return todoMap.get(id);
        }
    }

    public Todo updateById(String id, Todo updatedTodo){
        updatedTodo.setId(id);
        todoMap.put(id, updatedTodo);
        return updatedTodo;
    }


    public Todo deleteById(String id){
        return todoMap.remove(id);
    }

}
