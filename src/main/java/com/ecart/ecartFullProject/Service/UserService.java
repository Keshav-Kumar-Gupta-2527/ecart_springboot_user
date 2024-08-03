package com.ecart.ecartFullProject.Service;

import com.ecart.ecartFullProject.Exception.resourceNotFoundException;
import com.ecart.ecartFullProject.Model.User;
import com.ecart.ecartFullProject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;
    public ResponseEntity<List<User>> getAllUser(){
       try {
           return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
       }
       catch(Exception e){
           e.printStackTrace();
        }
       return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }
    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    public ResponseEntity<String> createUser(User user){
        userRepository.save(user);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }
    public User updateUserById(Long id,User userDetails){
        User user=userRepository.findById(id).orElseThrow(()->
                new resourceNotFoundException("No User Found with "+id));
        user.setUserName(userDetails.getUserName());
        user.setPassword(userDetails.getPassword());
        user.setAddress(userDetails.getAddress());
        user.setContact(userDetails.getContact());
        user.setWallet(userDetails.getWallet());
        return userRepository.save(user);

    }

    public ResponseEntity<String> deleteById(Long id){
        userRepository.deleteById(id);
        return new ResponseEntity<>("deleted",HttpStatus.NO_CONTENT);
    }
    public void updateUserBalance(Long userId, Double amount) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        user.setWallet(user.getWallet() - amount);
        userRepository.save(user);
    }
    public ResponseEntity<String> placeOrder(Long userId, String itemName, Double price) {
        String orderServiceUrl = "http://localhost:8083/Orders/place-order?userId=" + userId + "&itemName=" + itemName + "&price=" + price;
        String response = webClientBuilder.build()
                .post()
                .uri(orderServiceUrl)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        if ("Order placed successfully".equals(response)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}

