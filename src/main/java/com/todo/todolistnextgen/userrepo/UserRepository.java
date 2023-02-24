package com.todo.todolistnextgen.userrepo;


import com.todo.todolistnextgen.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, String> {
}
