package com.cinema.repository.ticket;

import com.cinema.model.Ticket;

import java.util.Optional;

public interface TicketRepository {

    Optional<Ticket> save(Ticket ticket);
}
