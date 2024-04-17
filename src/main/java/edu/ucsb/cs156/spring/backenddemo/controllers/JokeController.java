package edu.ucsb.cs156.spring.backenddemo.controllers;

import org.springframework.web.bind.annotation.RestController;

import edu.ucsb.cs156.spring.backenddemo.services.JokeQueryService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name="Joke info from API")
@Slf4j
@RestController
@RequestMapping("/api/jokes")

public class JokeController {
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    JokeQueryService JokeQueryService;

    @Operation(summary = "Get joke data from a certain category.", description = "link with jokes")
    @GetMapping("/get")
    public ResponseEntity<String> getJokes(
        @Parameter(name="category", description="category of joke", example="bad") @RequestParam String category,
        @Parameter(name="numJokes", description="number of jokes", example="12") @RequestParam int numJokes
    ) throws JsonProcessingException {
        log.info("getJokes: category={} numJokes={}", category, numJokes);
        String result = JokeQueryService.getJSON(category, numJokes);
        return ResponseEntity.ok().body(result);
    }
}
