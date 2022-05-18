package com.todoExam.ToDo.models;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EntityListeners(AuditTable.class)
public class AuditTable {
    @Column
    public LocalDateTime createAt;
    @Column
    public LocalDateTime modifiAt;
    @Column
    @CreatedBy
    private LocalDateTime createBy;
    @Column
    @LastModifiedBy
    private String modifiBy;
}
