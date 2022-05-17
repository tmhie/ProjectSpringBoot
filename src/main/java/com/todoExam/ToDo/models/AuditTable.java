package com.todoExam.ToDo.models;

import com.todoExam.ToDo.listener.AuditListener;
import lombok.Data;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EntityListeners(AuditListener.class)
public class AuditTable {
    @Column
    public LocalDateTime createAt;
    @Column
    public LocalDateTime modifiAt;

}
