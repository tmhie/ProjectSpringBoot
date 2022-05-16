package com.todoExam.ToDo.services;

import com.todoExam.ToDo.models.Task;
import com.todoExam.ToDo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServices {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getTask(){
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id){
        return taskRepository.findById(id).get();
    }

    public Task saveTask(Task task){
        return taskRepository.save(task);
    }

    public void deleteTask(Long id){
        taskRepository.findById(id)
                .map((task) -> task.getId())
                .ifPresent(taskRepository::deleteById);
    }

    public void updateTask(Task task){
        Task t = taskRepository.findById(task.getId())
                .orElseThrow(RuntimeException::new);
        t.setBody(task.getBody());
        t.setTitle(task.getTitle());
    }
}
