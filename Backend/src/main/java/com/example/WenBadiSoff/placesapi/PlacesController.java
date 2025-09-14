package com.example.WenBadiSoff.placesapi;

import com.example.WenBadiSoff.placesapi.model.PlaceDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlacesController {

    private final PlacesService placesService;

    public PlacesController(PlacesService placesService) {
        this.placesService = placesService;
    }

    @PostMapping("/places/parkinglots")
    public ResponseEntity<List<PlaceDTO>> getParkingLots(@RequestBody String placeSearch) {
        return placesService.execute(placeSearch);
    }
}
