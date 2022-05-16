package com.todoExam.ToDo.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
public class Tenance {
    @Id
    private Long tenance_id;
}
