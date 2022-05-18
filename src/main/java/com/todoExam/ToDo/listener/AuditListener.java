package com.todoExam.ToDo.listener;

import com.todoExam.ToDo.models.AuditTable;
import com.todoExam.ToDo.models.User;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class AuditListener {
    @PrePersist
    private void prePersist(Object object){
        if(object instanceof AuditTable){
            AuditTable auditTable = new AuditTable();
            auditTable.setCreateAt(LocalDateTime.now());
            auditTable.setModifiAt(LocalDateTime.now());
        }
    }

    @PreUpdate
    private void preUpdate(Object object){
        if(object instanceof AuditTable){
            AuditTable auditTable = new AuditTable();
            auditTable.setModifiAt(LocalDateTime.now());
        }
    }

}
