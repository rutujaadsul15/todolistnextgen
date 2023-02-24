package com.todo.todolistnextgen.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class User extends AuditModel {
    @Id
    @Size(min = 10, max = 10)
    private String contactNo;

    @NotBlank(message = "User First Name should not blank")
    private String firstName;

    @NotBlank(message = "User Last Name should not blank")

    private String lastName;

    @NotBlank(message = "Password cannot be blank")
    private String password;

    private UserRole roles;
}
