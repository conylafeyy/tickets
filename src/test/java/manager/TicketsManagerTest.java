package manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.TicketsRepository;
import tickets.InformationAboutFlights;

import static org.junit.jupiter.api.Assertions.*;

class TicketsManagerTest {
    private TicketsManager manager = new TicketsManager();
    private InformationAboutFlights zeroTicket = new InformationAboutFlights(0, 4545, "DME", "KZN", 90);
    private InformationAboutFlights firstTicket = new InformationAboutFlights(1, 1299, "DME", "KZN", 95);
    private InformationAboutFlights secondTicket = new InformationAboutFlights(2, 2199, "VKO", "KZN", 95);
    private InformationAboutFlights thirdTicket = new InformationAboutFlights(3, 2385, "DME", "KZN", 90);
    private InformationAboutFlights fourthTicket = new InformationAboutFlights(4, 4114, "DME", "KZN", 95);
    private InformationAboutFlights fifthTicket = new InformationAboutFlights(5, 3100, "DME", "KZN", 90);


    @BeforeEach
    void setUp() {
        manager.save(firstTicket);
        manager.save(secondTicket);
        manager.save(thirdTicket);
        manager.save(fourthTicket);
        manager.save(zeroTicket);
        manager.save(fifthTicket);
    }

    @Test
    void findFromTo() {
        InformationAboutFlights[] expected = new InformationAboutFlights[]{firstTicket, thirdTicket, fifthTicket, fourthTicket, zeroTicket};
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