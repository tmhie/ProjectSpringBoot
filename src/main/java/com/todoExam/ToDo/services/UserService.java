package com.todoExam.ToDo.services;

import com.todoExam.ToDo.models.Task;
import com.todoExam.ToDo.models.User;
import com.todoExam.ToDo.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;
    public User saveUser(User user){
        return userRepository.save(user);
    }

    public List<User> findByAll(){
        return userRepository.findAll();
    }

    public User getById(Long id){
        return userRepository.findById(id).get();
    }

    public void deleteUser(Long id){
        userRepository.findById(id)
                .map((user) -> user.getId())
                .ifPresent(userRepository::deleteById);
    }

    public User updateUserId(@PathVariable("id") Long id , @RequestBody User user){
        User userUpdate = userRepository.findById(id).get();
        modelMapper.map(user,userUpdate);
        userRepository.save(userUpdate);
        return userUpdate;
    }
}
