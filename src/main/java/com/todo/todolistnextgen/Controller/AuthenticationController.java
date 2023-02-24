package com.todo.todolistnextgen.Controller;


import com.todo.todolistnextgen.Model.Request.LoginRequest;
import com.todo.todolistnextgen.Model.User;
import com.todo.todolistnextgen.Security.JwtAuthenticationResponse;
import com.todo.todolistnextgen.Security.JwtTokenProvider;
import com.todo.todolistnextgen.Security.UserPrincipal;
import com.todo.todolistnextgen.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class AuthenticationController {

    @Autowired
    private UserServiceImpl userServiceimpl;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/signup")
    public ResponseEntity<User> userSignup(@RequestBody @Valid User userRequest) {
        User user1 = userServiceimpl.userSignup(userRequest);
        user1.setPassword(null);
        System.out.println("OK");
        return ResponseEntity.ok(user1);

    }

    @PostMapping("/login")
    private JwtAuthenticationResponse loginUser(@RequestBody @Valid LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getContactNo(),
                        loginRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken(authentication);
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        User user = userServiceimpl.getUserByContactNumber(loginRequest.getContactNo());
        return new JwtAuthenticationResponse(jwt, tokenProvider.getUserIdFromJWT(jwt), userPrincipal.getUserRole(), user.getFirstName(), user.getLastName());
    }

    @GetMapping("/getUser")
    public String getUser() {
        return "Ok";
    }
}
