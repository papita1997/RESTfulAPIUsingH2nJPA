package com.pawan.RESTfulAPIUsingH2nJPA;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    List<User> users = new ArrayList<>(Arrays.asList(
            new User(1,"pawan","java"),
            new User(2,"aditya","python"),
            new User(3,"priyanshu","react js")
    ));

    public List<User> allUsers(){
        return users;
    }

    public User getUserById(int id){
        return users.stream().filter(user -> user.getId() == id).findFirst().get();
    }

    public void addUser(User user){
        users.add(user);
    }

    public void deleteUserById(int id){
        users.removeIf(user -> user.getId() == id);
    }

    public void updateUser(User user , int id){
        for(User u:users){
            if(u.getId() == id){
                users.remove(u);
                users.add(user);
                break;
            }
        }
    }
}
