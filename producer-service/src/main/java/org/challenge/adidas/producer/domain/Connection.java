package org.challenge.adidas.producer.domain;

import lombok.Data;
import org.springframework.data.neo4j.annotation.QueryResult;

/**
 * Class Helper for the queries
 */
@Data
@QueryResult
public class Connection {

    private Itinerary itinerary;
    private Station origin;
    private Station destination;

}
