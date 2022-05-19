package com.todoExam.ToDo.services;

import com.todoExam.ToDo.models.Project;
import com.todoExam.ToDo.models.Task;
import com.todoExam.ToDo.repository.TaskRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TaskServices {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ModelMapper modelMapper;

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

    public Task taskUpdateId(@PathVariable("id") long id , @RequestBody Task task){
        Task taskUpdate = taskRepository.findById(id).get();
        modelMapper.map(task,taskUpdate);
        taskRepository.save(taskUpdate);
        return taskUpdate;
    }
    public void  taskCheck(Long id,Boolean isChecked){
        Task taskCheck = taskRepository.findById(id).orElseThrow(RuntimeException::new);
        taskCheck.setChecked(true);
        taskRepository.save(taskCheck);
    }

}
