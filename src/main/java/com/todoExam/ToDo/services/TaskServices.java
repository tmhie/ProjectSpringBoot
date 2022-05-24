package com.todoExam.ToDo.services;

import com.todoExam.ToDo.exception.EntityNotFound;
import com.todoExam.ToDo.models.Project;
import com.todoExam.ToDo.models.Task;
import com.todoExam.ToDo.repository.TaskRepository;
import org.hibernate.Criteria;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class TaskServices {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EntityManager entityManager;

    public List<Task> getTask(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Task> query = cb.createQuery(Task.class);
        Root<Task> task = query.from(Task.class);
        query.select(task)
                .orderBy(cb.desc(task.get("id")));
        return entityManager.createQuery(query).getResultList();
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

    public Task  taskCheck(Long id,Boolean isChecked){
        Task taskCheck = taskRepository.findById(id)
                .orElseThrow(EntityNotFound::new);
        taskCheck.setChecked(true);
        return taskRepository.save(taskCheck);
    }
    public Task taskUpdateCheck(Long id , Boolean isChecked){
        Task taskUpdateC = taskRepository.findById(id).orElseThrow(EntityNotFound ::new);
        taskUpdateC.setChecked(true);

        return taskRepository.save(taskUpdateC);
    }
}
