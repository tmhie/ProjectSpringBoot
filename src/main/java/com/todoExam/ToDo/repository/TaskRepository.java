package com.todoExam.ToDo.repository;

import com.todoExam.ToDo.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    Iterable<Task> findByIsCheckedTrue();
    Iterable<Task> findByIsCheckedFalse();
}
