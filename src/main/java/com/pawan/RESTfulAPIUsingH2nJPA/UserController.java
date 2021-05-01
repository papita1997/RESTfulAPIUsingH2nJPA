package com.pawan.RESTfulAPIUsingH2nJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<User> UserById(@PathVariable int id){
        if(userService.getUserById(id).isPresent()){
            return new ResponseEntity<>(userService.getUserById(id).get(), HttpStatus.OK);
        }
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Message","User not found");
//        return new ResponseEntity<>(headers,HttpStatus.NOT_FOUND);
        //or
        return ResponseEntity.notFound().header("Message","User not found").build();
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

    @PutMapping("/users/update")
    public void updateUsersById(@RequestBody User user){
        userService.updateUser(user);
    }
}
