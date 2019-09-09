package org.challenge.adidas.producer.controllers;

import lombok.extern.slf4j.Slf4j;
import org.challenge.adidas.producer.domain.Itinerary;
import org.challenge.adidas.producer.services.ItineraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Itinerary Controller for producing data
 */
@Slf4j
@RestController
@RequestMapping("/itineraries")
public class ItineraryController {

	private static final String LOG_DESC = "Return a list of itineraries for";
	private ItineraryService itineraryService;

	@Autowired
	public ItineraryController(ItineraryService itineraryService) {
		this.itineraryService = itineraryService;
	}
	
	/**
	 * Return a list of itineraries based in the less number of connections
	 * @param originCity given an origin city
	 * @return list of itineraries
	 */
	@GetMapping("/less-connections")
	public List<Itinerary> lessConnections(@RequestParam String originCity) {
		log.info("{} {} based in the less number of connections.", LOG_DESC, originCity);
		return itineraryService.lessConnections(originCity);
	}

	/**
	 * Return a list of itineraries based based in the less time
	 * @param originCity given an origin city
	 * @return list of itineraries
	 */
	@GetMapping("/less-time")
	public List<Itinerary> getAllItineraries(@RequestParam String originCity) {
		log.info("{} {} based in the less time.", LOG_DESC, originCity);
		return itineraryService.lessTime(originCity);
	}

}
