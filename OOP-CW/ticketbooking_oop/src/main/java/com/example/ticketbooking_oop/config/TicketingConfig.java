package com.example.ticketbooking_oop.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "ticketing")
public class TicketingConfig {

    private int totalTickets;
    private long ticketReleaseRate;
    private long customerRetrievalRate;
    private int maxTicketCapacity;

    // Getters and Setters
    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public long getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public void setTicketReleaseRate(long ticketReleaseRate) {
        this.ticketReleaseRate = ticketReleaseRate;
    }

    public long getCustomerRetrievalRate() {
        return customerRetrievalRate;
    }

    public void setCustomerRetrievalRate(long customerRetrievalRate) {
        this.customerRetrievalRate = customerRetrievalRate;
    }

    public int getMaxTicketCapacity() {
        return maxTicketCapacity;
    }

    public void setMaxTicketCapacity(int maxTicketCapacity) {
        this.maxTicketCapacity = maxTicketCapacity;
    }

    @Override
    public String toString() {
        return "TicketingConfig{" +
                "totalTickets=" + totalTickets +
                ", ticketReleaseRate=" + ticketReleaseRate +
                ", customerRetrievalRate=" + customerRetrievalRate +
                ", maxTicketCapacity=" + maxTicketCapacity +
                '}';
    }
}
