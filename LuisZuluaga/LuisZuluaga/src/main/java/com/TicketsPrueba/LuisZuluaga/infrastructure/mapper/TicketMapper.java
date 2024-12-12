package com.TicketsPrueba.LuisZuluaga.infrastructure.mapper;

import com.TicketsPrueba.LuisZuluaga.domain.model.Ticket;
import com.TicketsPrueba.LuisZuluaga.infrastructure.persistence.entity.TicketEntity;

public class TicketMapper {

    public static Ticket toDomainModel(TicketEntity entity) {
        return new Ticket(
                entity.getId(),
                entity.getUsuario(),
                entity.getFechaCreacion(),
                entity.getFechaActualizacion(),
                entity.getEstatus()
        );
    }

    public static TicketEntity toEntity(Ticket model) {
        TicketEntity entity = new TicketEntity();
        entity.setId(model.getId());
        entity.setUsuario(model.getUsuario());
        entity.setFechaCreacion(model.getFechaCreacion());
        entity.setFechaActualizacion(model.getFechaActualizacion());
        entity.setEstatus(model.getEstatus());
        return entity;
    }

}
