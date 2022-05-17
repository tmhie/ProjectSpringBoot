package com.todoExam.ToDo.listener;

import com.todoExam.ToDo.models.AuditTable;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class AuditListener {
    @PrePersist
    private void prePersist(Object object) {
        if(object instanceof AuditTable) {
            AuditTable auditTable = (AuditTable) object;
            auditTable.setCreateAt(LocalDateTime.now());
            auditTable.setModifiAt(LocalDateTime.now());
        }
    }

    @PreUpdate
    private void preUpdate(Object object){
        if(object instanceof AuditTable){
            AuditTable auditTable = (AuditTable) object;
            auditTable.setModifiAt(LocalDateTime.now());
        }
    }
}
