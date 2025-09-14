package com.example.WenBadiSoff.placesapi.model;

import lombok.Data;

import java.util.List;

@Data
public class PlacesResponse {
    private List<Place> places;
    private String nextPageToken;
}
