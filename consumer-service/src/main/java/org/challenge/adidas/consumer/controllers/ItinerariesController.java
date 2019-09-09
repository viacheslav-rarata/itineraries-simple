package org.challenge.adidas.consumer.controllers;

import io.swagger.annotations.Api;
import org.challenge.adidas.consumer.domain.Itinerary;
import org.challenge.adidas.consumer.services.ItineraryConsumerService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@Api(value = "Itineraries consumer controller")
public class ItinerariesController {

    private final ItineraryConsumerService itineraryConsumerService;

    public ItinerariesController(ItineraryConsumerService itineraryConsumerService){
        this.itineraryConsumerService = itineraryConsumerService;
    }

    @GetMapping("/time")
    @CrossOrigin(origins = "*")
    public Collection<Itinerary> lessTime(@RequestParam String originCity) {
        return itineraryConsumerService.lessConnections(originCity);
    }

    @GetMapping("/connections")
    @CrossOrigin(origins = "*")
    public Collection<Itinerary> lessConnections(@RequestParam String originCity) {
        return itineraryConsumerService.lessTime(originCity);
    }

}
