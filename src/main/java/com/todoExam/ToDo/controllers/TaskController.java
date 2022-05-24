package com.todoExam.ToDo.controllers;

import com.todoExam.ToDo.models.Project;
import com.todoExam.ToDo.models.Task;
import com.todoExam.ToDo.services.ProjectServices;
import com.todoExam.ToDo.services.TaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskServices taskServices;
    @GetMapping
    public List<Task> getTask(Task task){
        return taskServices.getTask(task);
    }
    @GetMapping("/{id}")
    public Task getTastById(@PathVariable Long id){
        return taskServices.getTaskById(id);
    }

    @GetMapping("/check/{id}")
    public Task check(@Valid @PathVariable("id") Long id) {
        return taskServices.taskCheck(id,true);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleValidationException(MethodArgumentNotValidException ex){
        Map<String,String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String fielName = ((FieldError)error).getField();
            String errorMassage = error.getDefaultMessage();
            errors.put(fielName,errorMassage);
        });
        return errors;
    }

    @PostMapping
    public Task saveTask(@RequestBody Task task){
        return taskServices.saveTask((task));
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable("id") Long id ,@RequestBody Task task){
        return taskServices.taskUpdateId(id,task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") Long id){
        taskServices.deleteTask(id);
    }
    @PostMapping("/ischeck")
    public void taskCheck(@PathVariable("id") Long id){
        taskServices.taskCheck(id,true);
    }
}
