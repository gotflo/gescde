package com.mycompany.projectmanager.web.controller;



import com.mycompany.projectmanager.entities.Task;
import com.mycompany.projectmanager.repo.ResourceNotFoundException;
import com.mycompany.projectmanager.repo.UserRepo;
import com.mycompany.projectmanager.entities.User;
import com.mycompany.projectmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController implements Serializable {

    private final UserRepo userRepo;
    private final UserService userService;



    @Autowired
    public UserController(UserRepo userRepo, UserService userService) {
        this.userRepo = userRepo;
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public ResponseEntity <User>addUser(@RequestBody User user){
        User user1 = userService.save(user);
        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

    
    @PostMapping("/login")
    public ResponseEntity<?>loginUser(@RequestBody User userData){
            System.out.println(userData);
        User user = userRepo.findByUsername(userData.getUsername());
        if(user.getPassword().equals(userData.getPassword()))
            return ResponseEntity.ok(user);
        
        return (ResponseEntity<?>) ResponseEntity.internalServerError();
    }

//    @PostMapping("/login")
//    public ResponseEntity<?>loginUser(@RequestBody User userData){
//        System.out.println(userData);
//        User user = userRepo.findByEmail(userData.getEmail());
//        if(user.getPassword().equals(userData.getPassword()))
//            return ResponseEntity.ok(user);
//
//        return (ResponseEntity<?>) ResponseEntity.internalServerError();
//    }
    @GetMapping("/usersList")
    public ResponseEntity<List<User>>findUser(){
        List<User> users = userRepo.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutUser(HttpServletRequest request, HttpServletRequest response){
        return "redirect:/login";
    }


    @GetMapping("/userSize")
    public ResponseEntity<Long> UserSize(){
        Long userSize = userService.count();
        return new ResponseEntity<>(userSize,HttpStatus.OK);
    }

    @GetMapping("/usersList/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable(value = "username") String username)throws ResourceNotFoundException {
        User users = userService.findUserByUsername(username);
        return ResponseEntity.ok().body(users);
    }


//    @PostMapping("/userSave")
//    public ResponseEntity<User>registerUser(@RequestBody User user){
//        return ResponseEntity.ok(userRepo.saveUser(user));
//    }
    
//    public User save (@PathVariable User user){
//            return userRepo.saveUser(user);
//        }
//    
    /*@GetMapping("/user")
    public List<User> findUser(){
        return userRepo.findAll();
    }*/
//    @CrossOrigin(origins = "*")


    
    
    

//    @PostMapping("/login")
//    public ResponseEntity<?>loginUser(@RequestBody User userData){
//            System.out.println(userData);
//        User user = userRepo.findByUsername(userData.getUsername());
//        if(user.getPassword().equals(userData.getPassword()))
//            return ResponseEntity.ok(user);
//        
//        return (ResponseEntity<?>) ResponseEntity.internalServerError();
//    }


}
