package com.TicketsPrueba.LuisZuluaga.application.service;

import com.TicketsPrueba.LuisZuluaga.domain.config.Constants;
import com.TicketsPrueba.LuisZuluaga.domain.model.Ticket;
import com.TicketsPrueba.LuisZuluaga.domain.service.TicketService;
import com.TicketsPrueba.LuisZuluaga.infrastructure.adapter.TicketRepositoryAdapter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketServiceImpl {

    private final TicketService service;

    public TicketServiceImpl(TicketRepositoryAdapter repository) {
        this.service = repository;
    }

    public List<Ticket> getAllTickets(int page, int size) {
        if (service.findAll(page, size).isEmpty())
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay tickets existentes");
        }
        else
        {
            return service.findAll(page, size);
        }
    }

    public Ticket getTicketById(Long id) {
        return service.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ticket no encontrado"));
    }

    public Ticket createTicket(String usuario) {
        Ticket ticket = new Ticket(null, usuario, LocalDateTime.now(), null, Constants.openStatus);
        return service.save(ticket);
    }

    public Ticket updateTicket(Long id, String estatus) {
        Ticket ticket = getTicketById(id);
        if(estatus.equals(Constants.openStatus)||estatus.equals(Constants.closeStatus))
        {
            ticket.setEstatus(estatus);
            ticket.setFechaActualizacion(LocalDateTime.now());
            return service.save(ticket);
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El Estatus indicado no es valido");
        }

    }

    public void deleteTicket(Long id) {
        if(getTicketById(id)!=null){
            service.deleteById(id);
        }
    }

}
