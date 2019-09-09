package org.challenge.adidas.producer.config;

import org.challenge.adidas.producer.domain.Itinerary;
import org.challenge.adidas.producer.domain.Station;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

final class ItineraryDataStub {

    List<Itinerary> init() {
        Station a = new Station("Point A");
        Station b = new Station("Point B");
        Station c = new Station("Point C");
        Station d = new Station("Point D");
        Station e = new Station("Point E");
        Station f = new Station("Point F");
        Station g = new Station("Point G");

        Date acArrivalTime = toDate("10/09/2019 18:30");
        Itinerary ac1 = new Itinerary(a, c, toDate("10/09/2019 16:30"), acArrivalTime);
        Itinerary bc = new Itinerary(b, c, toDate("10/09/2019 17:30"), acArrivalTime);
        ac1.addConnection(b);
        ac1.addConnection(g);

        Date gdArrivalTime = toDate("10/09/2019 21:30");
        Itinerary gd = new Itinerary(g, d, toDate("10/09/2019 12:00"), gdArrivalTime);
        Itinerary ad = new Itinerary(a, d, toDate("10/09/2019 15:30"), gdArrivalTime);
        Itinerary ed = new Itinerary(e, d, toDate("10/09/2019 11:30"), gdArrivalTime);
        gd.addConnection(a);
        gd.addConnection(e);

        Date fcArrivalTime = toDate("10/09/2019 14:30");
        Itinerary fc = new Itinerary(f, c, toDate("10/09/2019 08:00"), fcArrivalTime);
        Itinerary ac2 = new Itinerary(a, c, toDate("10/09/2019 10:30"), fcArrivalTime);
        fc.addConnection(a);

        Itinerary ge = new Itinerary(g, e, toDate("10/09/2019 12:00"), toDate("10/09/2019 17:30"));

        return Arrays.asList(ac1, bc, gd, ad, ed, fc, ac2, ge);
    }

    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    private Date toDate(String input) {
        try {
            return format.parse(input);
        } catch (ParseException ignored) {
            throw new RuntimeException("Exception on parsing date " + input);
        }
    }
}
