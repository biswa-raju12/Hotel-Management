package com.dailycodehunt.Hotelservice.repository;

import com.dailycodehunt.Hotelservice.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface HotelRepository extends JpaRepository<Hotel,String> {
}
