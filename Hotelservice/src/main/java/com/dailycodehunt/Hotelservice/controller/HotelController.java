package com.dailycodehunt.Hotelservice.controller;

import com.dailycodehunt.Hotelservice.entities.Hotel;
import com.dailycodehunt.Hotelservice.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;


    //create

    @PostMapping
    public ResponseEntity<Hotel> save(@RequestBody Hotel hotel)
    {
        Hotel hotel1 = hotelService.save(hotel);
        return new ResponseEntity<>(hotel1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels()
    {
        List<Hotel> hotels = hotelService.getAllHotels();
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable("hotelId") String hotelId)
    {
        Hotel hotel1 = hotelService.getHotel(hotelId);
        return new ResponseEntity<>(hotel1, HttpStatus.OK);
    }
}
