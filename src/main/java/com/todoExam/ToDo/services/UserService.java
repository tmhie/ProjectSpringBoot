package com.todoExam.ToDo.services;

import com.todoExam.ToDo.models.Task;
import com.todoExam.ToDo.models.User;
import com.todoExam.ToDo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User saveUser(User user){
        return userRepository.save(user);
    }
}
