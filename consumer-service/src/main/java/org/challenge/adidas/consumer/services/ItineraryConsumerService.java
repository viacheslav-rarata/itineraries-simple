package org.challenge.adidas.consumer.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.challenge.adidas.consumer.controllers.ItineraryClient;
import org.challenge.adidas.consumer.domain.Itinerary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class ItineraryConsumerService {

    private final ItineraryClient itineraryClient;

    public ItineraryConsumerService(ItineraryClient itineraryClient){
        this.itineraryClient = itineraryClient;
    }

    public Collection<Itinerary> fallback(String originCity) {
        return new ArrayList<>();
    }

    @HystrixCommand(fallbackMethod = "fallback")
    public Collection<Itinerary> lessConnections(String originCity) {
        return itineraryClient.lessConnections(originCity);
    }

    @HystrixCommand(fallbackMethod = "fallback")
    public Collection<Itinerary> lessTime(String originCity) {
        return itineraryClient.lessConnections(originCity);
    }
}
