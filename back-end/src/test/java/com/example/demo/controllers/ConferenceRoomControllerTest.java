package com.example.demo.controllers;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.Null;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConferenceRoomControllerTest {

    @Test
    void countRoomsTest() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:8080/allRooms";
        URI uri = new URI(baseUrl);

        ResponseEntity<List> result = restTemplate.getForEntity(uri, List.class);

        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(4, result.getBody().size());
    }
}
