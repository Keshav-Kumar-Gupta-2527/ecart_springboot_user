package com.ecart.ecartFullProject.Controller;

import com.ecart.ecartFullProject.Exception.resourceNotFoundException;
import com.ecart.ecartFullProject.Model.User;
import com.ecart.ecartFullProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/all")
    public ResponseEntity<List<User>>getAllUser(){
        return userService.getAllUser();
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id){
//        User users=userService.getUserById(id).orElseThrow(()->new resourceNotFoundException("User not found"+id));
//        return ResponseEntity.ok(users);
         return ResponseEntity.of(userService.getUserById(id));
    }
    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody User users){
        return userService.createUser(users);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<User> updateEmployeeById(@PathVariable Long id,@RequestBody User userdetails){
        return ResponseEntity.ok(userService.updateUserById(id,userdetails));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/wallet-balance")
    public void updateUserBalance(@RequestParam("userId") Long userId,@RequestParam("amount") Double amount) {
         userService.updateUserBalance(userId,amount);
    }
    @PostMapping("/{userId}/place-order")
    public ResponseEntity<String> placeOrder(@PathVariable Long userId, @RequestParam String itemName, @RequestParam Double price) {
        return userService.placeOrder(userId, itemName, price);
    }

}
