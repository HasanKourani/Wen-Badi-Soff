package com.example.WenBadiSoff.placesapi;

import com.example.WenBadiSoff.placesapi.model.PlacesDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlacesController {

    private final PlacesService placesService;

    public PlacesController(PlacesService placesService) {
        this.placesService = placesService;
    }

    @PostMapping("/places/parkinglots")
    public ResponseEntity<PlacesDTO> getParkingLots(@RequestBody String placeSearch) {
        return placesService.execute(placeSearch);
    }
}
