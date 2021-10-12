package repository;

import tickets.InformationAboutFlights;

public class TicketsRepository {
    private InformationAboutFlights[] tickets = new InformationAboutFlights[0];

    public void save(InformationAboutFlights ticket) {
        int length = tickets.length + 1;
        InformationAboutFlights[] tmp = new InformationAboutFlights[length];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = ticket;
        tickets = tmp;
    }

    public InformationAboutFlights[] findAll() {
        return tickets;
    }


    public void removeById(int id) {
        int length = tickets.length - 1;
        InformationAboutFlights[] tmp = new InformationAboutFlights[length];
        int index = 0;
        for (InformationAboutFlights ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[index] = ticket;
                index++;
            }
        }
        tickets = tmp;
    }
}
