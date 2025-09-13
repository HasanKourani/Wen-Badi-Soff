package com.example.WenBadiSoff.placesapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlacesDTO {
    private String name;
    private String address;
    private String totalSpots;
    private String availableSpots;
}
