package com.todoExam.ToDo.models;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Data
@Entity
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Table(name = "tenance")
public class Tenance {
    public static final long UNSAVED = 0;
    @Id
    private long tenance_id;

}
