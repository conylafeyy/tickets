package manager;

import repository.TicketsRepository;
import tickets.InformationAboutFlights;

import java.util.Arrays;

public class TicketsManager {
    TicketsRepository repository = new TicketsRepository();

    public InformationAboutFlights[] find(String from, String to) {
        InformationAboutFlights[] result = new InformationAboutFlights[0];
        for (InformationAboutFlights ticket : repository.findAll()) {

            if (ticket.getFromAirport().equals(from) && ticket.getToAirport().equals(to)) {
                InformationAboutFlights[] tmp = new InformationAboutFlights[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public void save(InformationAboutFlights ticket) {
        repository.save(ticket);
    }
}
