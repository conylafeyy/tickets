package manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.TicketsRepository;
import tickets.InformationAboutFlights;

import static org.junit.jupiter.api.Assertions.*;

class TicketsManagerTest {
    private TicketsManager manager = new TicketsManager();
    private InformationAboutFlights firstTicket = new InformationAboutFlights(1, 1299, "SVO", "KZN", 95);
    private InformationAboutFlights secondTicket = new InformationAboutFlights(2, 2199, "VKO", "KZN", 95);
    private InformationAboutFlights thirdTicket = new InformationAboutFlights(3, 2385, "DME", "KZN", 90);
    private InformationAboutFlights fourthTicket = new InformationAboutFlights(4, 3100, "DME", "KZN", 90);


    @BeforeEach
    void setUp() {
        manager.save(firstTicket);
        manager.save(secondTicket);
        manager.save(thirdTicket);
        manager.save(fourthTicket);
    }

    @Test
    void findFrom() {
        InformationAboutFlights[] expected = new InformationAboutFlights[]{firstTicket};
        InformationAboutFlights[] actual = manager.find("SVO", "");

        assertArrayEquals(expected, actual);
    }

    @Test
    void findTo() {
        InformationAboutFlights[] expected = new InformationAboutFlights[]{firstTicket, secondTicket, thirdTicket, fourthTicket};
        InformationAboutFlights[] actual = manager.find("", "KZN");

        assertArrayEquals(expected, actual);
    }

    @Test
    void findFromTo() {
        InformationAboutFlights[] expected = new InformationAboutFlights[]{firstTicket, secondTicket, thirdTicket, fourthTicket};
        InformationAboutFlights[] actual = manager.find("DME", "KZN");

        assertArrayEquals(expected, actual);
    }

    @Test
    void findNone() {
        InformationAboutFlights[] expected = new InformationAboutFlights[]{};
        InformationAboutFlights[] actual = manager.find("", "");

        assertArrayEquals(expected, actual);
    }
}