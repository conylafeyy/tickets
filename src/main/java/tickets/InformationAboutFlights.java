package tickets;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class InformationAboutFlights implements Comparable<InformationAboutFlights>{
    private int id;
    private int price;
    private String fromAirport;
    private String toAirport;
    private int time;


    @Override
    public int compareTo(InformationAboutFlights ticket) {
        return (int) (price - ticket.price);
    }
}
