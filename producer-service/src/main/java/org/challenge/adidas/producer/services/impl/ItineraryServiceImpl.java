package org.challenge.adidas.producer.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.challenge.adidas.producer.domain.Connection;
import org.challenge.adidas.producer.domain.Itinerary;
import org.challenge.adidas.producer.domain.Station;
import org.challenge.adidas.producer.repositories.ItineraryRepository;
import org.challenge.adidas.producer.services.ItineraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Itinerary calculations service
 */
@Slf4j
@Service
public class ItineraryServiceImpl implements ItineraryService {

	private ItineraryRepository itineraryRepository;
	
	@Autowired
	public ItineraryServiceImpl(ItineraryRepository itineraryRepository) {
		this.itineraryRepository = itineraryRepository;
	}

	/**
	 * Filter by less connections
	 */
	@Override
	public List<Itinerary> lessConnections(String originCity)  {
		SortFunction<Itinerary> function = (current, expected) -> current.getConnections() < expected.getConnections();
		return calculate(originCity, function);
	}

	/**
	 * Filter by less time
	 */
	@Override
	public List<Itinerary> lessTime(String originCity) {
		SortFunction<Itinerary> function = (current, expected) -> current.getTime() < expected.getTime();
		return calculate(originCity, function);
	}

	private List<Itinerary> calculate(String originCity, SortFunction<Itinerary> function) {
		List<Connection> connections = itineraryRepository.connectionsByOrigin(originCity);
		List<Itinerary> result = connections.stream().map(this::toItinerary).collect(Collectors.toList());
		Map<String, Itinerary> lessTime = filteredMap(result, function);
		result.removeIf(itinerary -> !lessTime.containsKey(itinerary.getDestination().getOriginCity()));
		return result;
	}

	private Itinerary toItinerary(Connection connection) {
		Itinerary itinerary = connection.getItinerary();
		itinerary.setOrigin(connection.getOrigin());
		itinerary.setDestination(connection.getDestination());
		return itinerary;
	}

	private Map<String, Itinerary> filteredMap(List<Itinerary> result, SortFunction<Itinerary> function) {
		Map<String, Itinerary> resultMap = new HashMap<>();
		result.forEach(itinerary -> {
			Station destination = itinerary.getDestination();
			String origin = destination.getOriginCity();
			if (resultMap.containsKey(origin)) {
				if (function.apply(itinerary, resultMap.get(origin))) {
					resultMap.put(origin, itinerary);
				}
			} else {
				resultMap.put(origin, itinerary);
			}
		});
		return resultMap;
	}

	@FunctionalInterface
	private interface SortFunction<Itinerary> {
		boolean apply(Itinerary current, Itinerary expected);
	}

}
