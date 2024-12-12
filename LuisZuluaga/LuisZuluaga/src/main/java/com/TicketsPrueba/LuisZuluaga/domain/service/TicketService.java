package com.TicketsPrueba.LuisZuluaga.domain.service;

import com.TicketsPrueba.LuisZuluaga.domain.model.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketService {
    List<Ticket> findAll(int page, int size);
    Optional<Ticket> findById(Long id);
    Ticket save(Ticket ticket);
    void deleteById(Long id);
}
