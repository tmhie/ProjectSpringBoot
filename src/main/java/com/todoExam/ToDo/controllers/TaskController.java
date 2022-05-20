package com.todoExam.ToDo.controllers;

import com.todoExam.ToDo.models.Project;
import com.todoExam.ToDo.models.Task;
import com.todoExam.ToDo.services.ProjectServices;
import com.todoExam.ToDo.services.TaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskServices taskServices;
    @GetMapping
    public List<Task> getTask(){
        return taskServices.getTask();
    }
    @GetMapping("/{id}")
    public Task getTastById(@PathVariable Long id){
        return taskServices.getTaskById(id);
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
}
