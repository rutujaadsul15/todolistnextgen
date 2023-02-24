package com.todo.todolistnextgen.Service;


import com.todo.todolistnextgen.Model.User;

public interface UserService {
    User userSignup(User user);

    User getUserByContactNumber(String contactNo);
}
