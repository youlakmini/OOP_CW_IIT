import java.math.BigDecimal;

public class Ticket {
    private int ticketId;
    private String eventName;
    private BigDecimal ticketPrice;

    public Ticket( int ticketId,String eventName,BigDecimal ticketPrice) {
        this.ticketId=ticketId;
        this.eventName=eventName;
        this.ticketPrice=ticketPrice;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
    public String toString(){
        return "Ticket details[ID: "+ticketId+" Name: "+eventName+" Price: "+ticketPrice+"]" ;
    }
}