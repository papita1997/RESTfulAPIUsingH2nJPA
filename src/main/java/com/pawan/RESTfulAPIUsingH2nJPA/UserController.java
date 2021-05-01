package com.pawan.RESTfulAPIUsingH2nJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public List<User> getAllUsers(){
        return userService.allUsers();
    }

    @GetMapping("/users/{id}")
    public User UserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    @PostMapping("/users/adduser")
    public void addUsers(@RequestBody User user){
        System.out.println(user.getName());
        userService.addUser(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUsersById(@PathVariable int id){
        userService.deleteUserById(id);
    }

    @PutMapping("/users/update/{id}")
    public void updateUsersById(@RequestBody User user, @PathVariable int id){
        userService.updateUser(user,id);
    }
}
