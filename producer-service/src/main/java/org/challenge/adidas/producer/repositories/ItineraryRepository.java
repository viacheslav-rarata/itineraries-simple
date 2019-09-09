package org.challenge.adidas.producer.repositories;

import org.challenge.adidas.producer.domain.Connection;
import org.challenge.adidas.producer.domain.Itinerary;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

@EnableNeo4jRepositories
public interface ItineraryRepository extends Neo4jRepository<Itinerary, Long> {

    @Query("MATCH p=()-[r:ITINERARY]->() RETURN p LIMIT 50")
    Collection<Itinerary> graph();

    @Query("MATCH p=()-[:HAS_ITINERARY]->() RETURN p LIMIT 50")
    Collection<Itinerary> connection();

    @Query("MATCH (origin:Station {originCity:{originCity}})-[:HAS_ITINERARY]->" +
            "(itinerary:Itinerary)-[:DESTINATION]-(destination:Station) " +
            "RETURN origin, itinerary, destination")
    List<Connection> connectionsByOrigin(@Param("originCity") String originCity);
}
