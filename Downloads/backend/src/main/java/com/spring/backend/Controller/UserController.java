package com.spring.backend.Controller;

import com.spring.backend.Entity.User;
import com.spring.backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin("http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;



    @GetMapping("users")
    public List<User> getAllUsers()
    {
    System.out.println("Users returned");
return userService.getAllUsers();



    }

    @PostMapping("CreateUsers")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}