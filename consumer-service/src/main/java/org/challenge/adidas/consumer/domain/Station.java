package org.challenge.adidas.consumer.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;

/**
 * Representation of Station
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Station {

    private String originCity;

    private List<Itinerary> itineraries = new LinkedList<>();

}
