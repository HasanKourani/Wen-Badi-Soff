package com.example.WenBadiSoff.placesapi.model;

import lombok.Data;

@Data
public class Place {
    private String id;
    private DisplayName displayName;
    private String formattedAddress;
    private Location location;
}
