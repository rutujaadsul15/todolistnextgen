package com.todo.todolistnextgen.Service;

import com.todo.todolistnextgen.Model.User;
import com.todo.todolistnextgen.Model.UserRole;
import com.todo.todolistnextgen.userrepo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User userSignup(User user) {

        Optional<User> dbUserData = userRepository.findById(user.getContactNo());
        if (dbUserData.isPresent()) {
            throw new RuntimeException(" User is already exist with given contact number ! ");
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(UserRole.USER);
            return userRepository.save(user);
        }

    }

    @Override
    public User getUserByContactNumber(String contactNo) {
        Optional<User> dbUser = userRepository.findById(contactNo);
        if (dbUser.isPresent()) {
            return dbUser.get();
        } else {
            throw new RuntimeException("User not exist with given contact number : " + contactNo);
        }
    }
}
