package com.dailycodehunt.UserService.controller;

import com.dailycodehunt.UserService.entities.User;
import com.dailycodehunt.UserService.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Log4j2
public class UserController {

    @Autowired
    private UserService userService;

    //create

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){

        User newUser = userService.saveUser(user);

        return new ResponseEntity<>(newUser, HttpStatus.CREATED);

    }

    @GetMapping("/{userId}")
//    @CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
    @RateLimiter(name = "userRateLimiter",fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getUser(@PathVariable("userId") String userId){

        User newUser = userService.getUser(userId);

        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    //creating fallback method for circuitBreaker

    public ResponseEntity<User> ratingHotelFallback(String userId,Exception ex){

        log.info("FallBack method is executed because service is down", ex.getMessage());
         User dummyUser = User.builder()
                .email("dummy@gmail.com")
                .name("Dummy")
                .about("This user is created dummy because some service is down!.")
                .userId("121355")
                .build();

        return new ResponseEntity<>(dummyUser,HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){

        List<User> users = userService.getAllUsers();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
