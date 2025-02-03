import com.example.ticketbooking_oop.config.TicketingConfig;
import com.example.ticketbooking_oop.service.TicketPool;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TicketVendor {
    private final TicketPool ticketPool;
    private final TicketingConfig ticketingConfig;

    public TicketVendor(TicketPool ticketPool, TicketingConfig ticketingConfig) {
        this.ticketPool = ticketPool;
        this.ticketingConfig = ticketingConfig;
    }

    @Scheduled(fixedRateString = "${ticketing.ticket-release-rate}")
    public void releaseTickets() {
        for (int i = 0; i < ticketingConfig.getTotalTickets(); i++) {
            String ticketId = UUID.randomUUID().toString();
            ticketPool.addTicket(ticketId);
        }
    }
}
