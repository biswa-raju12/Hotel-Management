package com.dailycodehunt.UserService.external.service;

import com.dailycodehunt.UserService.entities.Rating;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "RATING-SERVICE/ratings")
public interface RatingService {

    @GetMapping("/getByUserId/{userId}")
    public ResponseEntity<List<Rating>> getAllRatingsByUserId(@PathVariable("userId") String userId);
}
