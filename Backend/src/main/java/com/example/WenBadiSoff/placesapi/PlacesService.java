package com.example.WenBadiSoff.placesapi;

import com.example.WenBadiSoff.Query;
import com.example.WenBadiSoff.placesapi.model.PlacesDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class PlacesService implements Query<String, PlacesDTO> {

    private final RestTemplate restTemplate;

    @Value("${places.api.url}")
    private String url;

    @Value("${content.type}")
    private String contentType;

    @Value("${places.x.goog-api-key}")
    private String apiKey;

    @Value("${places.x-goog-fieldmask}")
    private String fieldMask;

    public PlacesService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ResponseEntity<PlacesDTO> execute(String placeSearch) {

        URI uri = UriComponentsBuilder
                .fromUriString(url)
                .build()
                .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", contentType);
        headers.set("X-Goog-Api-Key", apiKey);
        headers.set("X-Goog-FieldMask", fieldMask);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<PlacesDTO> response = restTemplate
                    .exchange(uri, HttpMethod.POST, entity, PlacesDTO.class);

            PlacesDTO placesDTO = new PlacesDTO(response.getBody().getName(),
                                                response.getBody().getAddress(),
                                                response.getBody().getTotalSpots(),
                                                response.getBody().getAvailableSpots());
            return ResponseEntity.ok(placesDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
