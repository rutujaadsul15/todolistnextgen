package com.todo.todolistnextgen.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class TaskDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Size(min = 10, max = 10)
    private String username;

    private String taskDetails;

    private String taskStartTime;

    private String taskEndTime;

    private TaskStatus status;
}
