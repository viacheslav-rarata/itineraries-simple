package org.challenge.adidas.consumer.controllers;

import org.challenge.adidas.consumer.domain.Itinerary;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Feign Client for requesting service producer
 */
@FeignClient(name = "producer-service", url = "http://localhost:8100/data")
public interface ItineraryClient {

    @GetMapping("/itineraries/less-connections")
    List<Itinerary> lessConnections(@RequestParam("originCity") String originCity);

    @GetMapping("/itineraries/less-time")
    List<Itinerary> lessTime(@RequestParam("originCity") String originCity);

}
