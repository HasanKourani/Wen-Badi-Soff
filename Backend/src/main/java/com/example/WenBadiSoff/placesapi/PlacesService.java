package com.example.WenBadiSoff.placesapi;

import com.example.WenBadiSoff.Query;
import com.example.WenBadiSoff.placesapi.model.PlaceDTO;
import com.example.WenBadiSoff.placesapi.model.PlacesResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class PlacesService implements Query<String, List<PlaceDTO>> {

    private final RestTemplate restTemplate;

    @Value("${places.api.url}")
    private String url;

    @Value("${places.x.goog-api-key}")
    private String apiKey;

    @Value("${places.x-goog-fieldmask}")
    private String fieldMask;

    public PlacesService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ResponseEntity<List<PlaceDTO>> execute(String placeSearch) {

        URI uri = URI.create(url);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Goog-Api-Key", apiKey);
        headers.set("X-Goog-FieldMask", fieldMask);

        Map<String, Object> payload = Map.of("textQuery", placeSearch);
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(payload, headers);

        ResponseEntity<PlacesResponse> response = restTemplate
                .exchange(uri, HttpMethod.POST, entity, PlacesResponse.class);

        PlacesResponse body = response.getBody();
        if(body == null || body.getPlaces() == null || body.getPlaces().isEmpty()) {
            return ResponseEntity.ok(Collections.emptyList());
        }

        System.out.println(body.getPlaces());

        List<PlaceDTO> placeDTO =
                body.getPlaces().stream()
                        .map(p -> new PlaceDTO(
                                p.getDisplayName(),
                                p.getFormattedAddress(),
                                p.getLocation(),
                                "0",
                                "0"
                        ))
                        .toList();
        return ResponseEntity.ok(placeDTO);

    }
}
