package com.dailycodehunt.UserService.services;

import com.dailycodehunt.UserService.entities.Rating;
import com.dailycodehunt.UserService.entities.User;
import com.dailycodehunt.UserService.exception.ResourceNotFoundException;
import com.dailycodehunt.UserService.external.service.RatingService;
import com.dailycodehunt.UserService.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Log4j2
public class UserServiceImpl implements UserService{

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RatingService ratingService;

    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {

        //get User by userId from the User Repository
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("UserId Not Found!!"));


        //to get ratings of each user we need to call other Service(Rating_Service)

//        ArrayList<Rating> arrayList=restTemplate.getForObject("http://RATING-SERVICE/ratings/getByUserId/"+userId, ArrayList.class);
//        log.info("Data Coming from the Rating Service!!",arrayList);

        List<Rating> arrayList=ratingService.getAllRatingsByUserId(userId).getBody();
        user.setRatings(arrayList);


        return user;
    }

    @Override
    public String deleteUser(String userId) {
        return null;
    }

    @Override
    public User updateUser(String userId, User user) {
        return null;
    }
}
