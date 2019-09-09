package org.challenge.adidas.producer.config;

import lombok.extern.slf4j.Slf4j;
import org.challenge.adidas.producer.repositories.ItineraryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Itineraries configuration
 */
@Slf4j
@Component
public class ItineraryConfig implements CommandLineRunner {

    private ItineraryRepository itineraryRepository;

    public ItineraryConfig(ItineraryRepository itineraryRepository) {
        this.itineraryRepository = itineraryRepository;
    }

    @Override
    public void run(String... args)  {
        if (itineraryRepository.count() == 0) {
            itineraryRepository.saveAll(new ItineraryDataStub().init());
        } else {
            log.info("Data already populated");
        }

    }

}
