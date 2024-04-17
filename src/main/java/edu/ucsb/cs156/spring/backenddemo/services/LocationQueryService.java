package edu.ucsb.cs156.spring.backenddemo.services;


import org.springframework.boot.web.client.RestTemplateBuilder;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


@Service
public class LocationQueryService {

    private final RestTemplate restTemplate;

    public LocationQueryService(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    public static final String ENDPOINT = "";

    public String getJSON(String location) throws HttpClientErrorException {
        return "";
    }
}