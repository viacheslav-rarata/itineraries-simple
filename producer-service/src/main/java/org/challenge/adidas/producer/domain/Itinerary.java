package org.challenge.adidas.producer.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.neo4j.ogm.annotation.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Representation of Itinerary
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@NodeEntity
public class Itinerary {

    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
    @Relationship(value = "HAS_ITINERARY", direction = "INCOMING")
    private Station origin;
    @Relationship("DESTINATION")
    private Station destination;
    private Date departureTime;
    private Date arrivalTime;
    private Long time;
    @Relationship(value = "HAS_ITINERARY", direction = "INCOMING")
    List<Station> stations;
    private Integer connections;

    public Itinerary(Station origin, Station destination, Date departureTime, Date arrivalTime) {
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.time = calculateTime();
        stations = new LinkedList<>();
        recalculateConnections();
    }

    private void recalculateConnections() {
        this.connections = this.stations.size();
    }

    private Long calculateTime() {
        return Math.abs(Duration.between(toLocal(departureTime), toLocal(arrivalTime)).getSeconds()) / 60;
    }

    private LocalDateTime toLocal(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public void setStations(List<Station> stations) {
        this.stations = stations != null ? stations : new LinkedList<>();
        recalculateConnections();
    }
    public void addConnection(Station station) {
        this.stations.add(station);
        recalculateConnections();
    }
}
