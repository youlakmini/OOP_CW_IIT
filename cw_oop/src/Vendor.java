import java.math.BigDecimal;

public class Vendor implements Runnable {
    private int totalTicket;
    private int ticketReleaseRate;
    private TicketPool ticketPool;

    public Vendor(int totalTicket, int ticketReleaseRate, TicketPool ticketPool) {
        this.totalTicket = totalTicket;
        this.ticketReleaseRate = ticketReleaseRate;
        this.ticketPool = ticketPool;
    }
    @Override
    public void run() {
        //i for ID
        for (int i = 1; i <= totalTicket; i++) {
            Ticket ticket = new Ticket(i, "Bla bla bla", new BigDecimal("3000"));
            ticketPool.addTicket(ticket);

            try {
                //the ticket release frequency=delay
                //converting seconds to ms(milliseconds)
                Thread.sleep(ticketReleaseRate * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }
}