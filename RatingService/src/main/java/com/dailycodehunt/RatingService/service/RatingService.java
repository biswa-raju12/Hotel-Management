package com.dailycodehunt.RatingService.service;

import com.dailycodehunt.RatingService.entities.Rating;

import java.util.List;

public interface RatingService {

    //create

    Rating create(Rating rating);

    //get all ratings
    List<Rating> getAllRatings();

    //get all ratings by userId

    List<Rating> getAllRatingsByUserId(String userId);

    //get all rating by HotelId


    List<Rating> getAllRatingsByHotelId(String hotelId);
}
