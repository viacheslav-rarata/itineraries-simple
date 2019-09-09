package org.challenge.adidas.producer.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.LinkedList;
import java.util.List;

/**
 * Representation of Station
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@NodeEntity
public class Station {

    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
    private String originCity;

    @Relationship("HAS_ITINERARY")
    private List<Itinerary> itineraries = new LinkedList<>();

    public Station(String originCity) {
        this.originCity = originCity;
    }
}
