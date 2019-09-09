package org.challenge.adidas.consumer.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * Representation of Itinerary
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Itinerary {

    private Station origin;
    private Station destination;
    private Date departureTime;
    private Date arrivalTime;
    private Long time;
    List<Station> stations;
    private Integer connections;

}
