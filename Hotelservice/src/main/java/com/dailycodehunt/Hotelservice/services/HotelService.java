package com.dailycodehunt.Hotelservice.services;


import com.dailycodehunt.Hotelservice.entities.Hotel;

import java.util.List;

public interface HotelService {

    Hotel save(Hotel hotel);

    List<Hotel> getAllHotels();

    Hotel getHotel(String hotelId);


}
