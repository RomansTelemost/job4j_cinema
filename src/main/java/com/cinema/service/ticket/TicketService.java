package com.cinema.service.ticket;

import com.cinema.model.Ticket;

import java.util.Optional;

public interface TicketService {

    Optional<Ticket> save(Ticket ticket, int sessionId, int userId);
}
