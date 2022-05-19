package com.todoExam.ToDo.listener;

import com.todoExam.ToDo.models.AuditTable;
import com.todoExam.ToDo.models.User;
import com.todoExam.ToDo.services.IAuthenticationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.core.Authentication;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class AuditListener {

//    @Autowired
//    private IAuthenticationFacade authenticationFacade;
//    public String currentUserNameSimple(){
//        Authentication authentication = authenticationFacade.getAuthention();
//        return authentication.getName();
//    }
//    String name = currentUserNameSimple();
//
//    public String getName() {
//        return name;
//    }

    @PrePersist
    private void prePersist(Object object){
        if(object instanceof AuditTable){
            AuditTable auditTable = new AuditTable();
            auditTable.setCreateAt(LocalDateTime.now());


        }
    }
//asdasdsad
    @PreUpdate
    private void preUpdate(Object object){
        if(object instanceof AuditTable){
            AuditTable auditTable = new AuditTable();
            auditTable.setModifiAt(LocalDateTime.now());
        }
    }

}
