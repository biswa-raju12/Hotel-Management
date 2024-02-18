package com.dailycodehunt.RatingService.controller;

import com.dailycodehunt.RatingService.entities.Rating;
import com.dailycodehunt.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating)
    {
        return new ResponseEntity<>(ratingService.create(rating), HttpStatus.CREATED);
    }


    @GetMapping
    public  ResponseEntity<List<Rating>> getAllRatings()
    {
        return new ResponseEntity<List<Rating>>(ratingService.getAllRatings(),HttpStatus.OK);
    }

    @GetMapping("/getByUserId/{userId}")
    public  ResponseEntity<List<Rating>> getAllRatingsByUserId(@PathVariable("userId") String userId)
    {
        return new ResponseEntity<List<Rating>>(ratingService.getAllRatingsByUserId(userId),HttpStatus.OK);
    }

    @GetMapping("/getByHotelId/{hotelId}")
    public  ResponseEntity<List<Rating>> getAllRatingsByHotelId(@PathVariable("hotelId") String hotelId)
    {
        return new ResponseEntity<List<Rating>>(ratingService.getAllRatingsByHotelId(hotelId),HttpStatus.OK);
    }
}
