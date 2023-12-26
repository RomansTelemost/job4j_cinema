package com.cinema.service.ticket;

import com.cinema.model.Ticket;
import com.cinema.repository.ticket.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SimpleTicketService implements TicketService {
    private final TicketRepository ticketRepository;

    public SimpleTicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Optional<Ticket> save(Ticket ticket, int sessionId, int userId) {
        ticket.setSessionId(sessionId);
        ticket.setUserId(userId);
        return ticketRepository.save(ticket);
    }
}
