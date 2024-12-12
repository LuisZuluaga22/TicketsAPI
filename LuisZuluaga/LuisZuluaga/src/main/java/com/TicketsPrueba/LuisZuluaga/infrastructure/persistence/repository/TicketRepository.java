package com.TicketsPrueba.LuisZuluaga.infrastructure.persistence.repository;

import com.TicketsPrueba.LuisZuluaga.infrastructure.persistence.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketEntity, Long> {
}
