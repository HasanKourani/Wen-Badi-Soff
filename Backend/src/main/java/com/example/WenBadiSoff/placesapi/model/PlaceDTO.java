package com.example.WenBadiSoff.placesapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlaceDTO {
    private DisplayName name;
    private String address;
    private Location location;
    private String totalSpots;
    private String availableSpots;
}
