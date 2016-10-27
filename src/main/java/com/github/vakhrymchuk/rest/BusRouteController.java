package com.github.vakhrymchuk.rest;

import com.github.vakhrymchuk.rest.model.BusRouteResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/direct")
public class BusRouteController {

    @GetMapping
    public ResponseEntity<BusRouteResponse> direct(@RequestParam("dep_sid") final Integer depSid,
                                                   @RequestParam("arr_sid") final Integer arrSid) {
        return ResponseEntity.ok(new BusRouteResponse(depSid, arrSid, true));
    }

}
