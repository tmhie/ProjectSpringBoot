package com.todoExam.ToDo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public interface IAuthenticationFacade {
    Authentication getAuthention();
}
