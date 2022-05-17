package com.todoExam.ToDo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;

import javax.persistence.*;

@Entity(name = "tbl_users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends AuditTable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;
}
