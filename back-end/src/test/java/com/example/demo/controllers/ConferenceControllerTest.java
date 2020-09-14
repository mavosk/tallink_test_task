package com.example.demo.controllers;

import com.example.demo.repositories.ConferenceRepository;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

@SpringBootTest(classes = ConferenceController.class)
public class ConferenceControllerTest {
    final String baseUrl = "http://localhost:8080";
    final String getAllUrl = "http://localhost:8080/conferences";
    final String addUrl = "http://localhost:8080/addConference";
    final String deleteUrl = "http://localhost:8080/deleteConference";

    RestTemplate restTemplate = new RestTemplate();


    @MockBean
    ConferenceRepository conferenceRepository;

    @Autowired
    ConferenceController controller;

    @Autowired
    private static RequestSpecification spec;

  @Test
    void zeroConferenceTest() throws URISyntaxException {
      URI uri = new URI(getAllUrl);

      ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

      Assert.assertEquals(200, result.getStatusCodeValue());
      Assert.assertEquals(true, result.getBody().contains("[]"));

  }

  @Test
    void addConferenceTest() throws URISyntaxException {
      JSONObject obj = new JSONObject();
      obj.put("name", "Daily meeting");
      obj.put("location", "M/S	Baltic	Queen");
      obj.put("date", "2020-10-10T14:30");
      obj.put("max_seats", 4);

      RestTemplate restTemplate = new RestTemplate();
      URI uri = new URI(addUrl);


      HttpHeaders headers = new HttpHeaders();

      HttpEntity<JSONObject> request = new HttpEntity<>(obj, headers);
          restTemplate.postForEntity(uri, request, String.class);
      ResponseEntity<String> result = restTemplate.getForEntity(getAllUrl, String.class);
      Assert.assertEquals(200, result.getStatusCodeValue());
      Assert.assertTrue(!Objects.requireNonNull(result.getBody()).isEmpty());
      }











}


