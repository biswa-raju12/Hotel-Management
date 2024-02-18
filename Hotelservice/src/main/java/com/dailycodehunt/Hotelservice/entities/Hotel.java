package com.dailycodehunt.Hotelservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Hotels")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Hotel {

    @Id
    @Column(name = "ID")
    private String hotelId;
    @Column(name = "Name")
    private String name;
    @Column(name = "LOCATION")
    private String location;
    @Column(name = "ABOUT")
    private String about;

    @Transient
    private List<Rating> ratings = new ArrayList<>();
}
