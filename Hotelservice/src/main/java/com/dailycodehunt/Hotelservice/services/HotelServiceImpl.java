package com.dailycodehunt.Hotelservice.services;

import com.dailycodehunt.Hotelservice.entities.Hotel;
import com.dailycodehunt.Hotelservice.entities.Rating;
import com.dailycodehunt.Hotelservice.exception.ResourceNotFoundException;
import com.dailycodehunt.Hotelservice.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel save(Hotel hotel) {

        String id = UUID.randomUUID().toString();
        hotel.setHotelId(id);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotel(String hotelId) {
        Hotel hotelDeatils =  hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Data with given id not found!!"));


        ArrayList<Rating> ratingArrayList = restTemplate.getForObject("http://RATING-SERVICE/ratings/getByHotelId/"+hotelId,ArrayList.class);

        hotelDeatils.setRatings(ratingArrayList);
        return hotelDeatils;

    }
}
