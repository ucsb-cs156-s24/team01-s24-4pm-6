package edu.ucsb.cs156.spring.backenddemo.controllers;

import org.springframework.web.bind.annotation.RestController;

import edu.ucsb.cs156.spring.backenddemo.services.TidesQueryService;
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

@Tag(name="Tides info from https://api.tidesandcurrents.noaa.gov/api/prod/")
@Slf4j
@RestController
@RequestMapping("/api/tides")
public class TidesController {

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    TidesQueryService tidesQueryService;

    @Operation(summary = "Get water level for date range, in local time.", description = "")
    @GetMapping("/get")
    public ResponseEntity<String> getTides(
        @Parameter(name="beginDate", description="begin date in format yyyymmdd", example="20210501") @RequestParam String beginDate,
        @Parameter(name="endDate", description="end date in format yyyymmdd", example="20210502") @RequestParam String endDate,
        @Parameter(name="station", description="station id", example="9411340") @RequestParam String station
    ) throws JsonProcessingException {
        log.info("getTides: beginDate={} endDate={} station={}", beginDate, endDate, station);
        String result = tidesQueryService.getJSON(beginDate, endDate, station);
        return ResponseEntity.ok().body(result);
    }

}
