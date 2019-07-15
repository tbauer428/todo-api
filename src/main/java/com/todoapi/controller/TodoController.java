package com.todoapi.controller;

import com.todoapi.model.Todo;
import com.todoapi.repository.TodoNotFoundException;
import com.todoapi.repository.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
public class TodoController {
    TodoRepository todoRepository = new TodoRepository();

    @GetMapping("/todos")
    public Map<String, Todo> getAll(){
        return todoRepository.getTodos();
    }

    @PostMapping("/todos/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Todo newTodo(@RequestBody Todo newTodo){
        return todoRepository.saveTodo(newTodo);
            }

    @GetMapping("/todos/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Todo foundTodo(@PathVariable String id){
        return todoRepository.findById(id);
            }

    @DeleteMapping("/todos/delete/{id}")
    public Todo deleteById(@PathVariable String id){
        return todoRepository.deleteById(id);
    }

    @PutMapping("/todos/{id}")
    public Todo updateById(@PathVariable String id, @RequestBody Todo updatedTodo){
        return todoRepository.updateById(id, updatedTodo);
    }

    @ResponseBody
    @ExceptionHandler(TodoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String GameNotFoundException(TodoNotFoundException ex) {
        log.warn("Todo not found",ex);
        return "Todo not found";
    }
}
