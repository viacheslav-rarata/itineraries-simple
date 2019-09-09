package org.challenge.adidas.producer.services;

import org.challenge.adidas.producer.domain.Itinerary;

import java.util.List;

/**
 * Services for manipulation Itinerary data
 */
public interface ItineraryService {

	/**
	 * Getting list with less number of connections
	 */
	List<Itinerary> lessConnections(String originCity);

	/**
	 * Getting list with less Time
	 */
	List<Itinerary> lessTime(String originCity);

}
