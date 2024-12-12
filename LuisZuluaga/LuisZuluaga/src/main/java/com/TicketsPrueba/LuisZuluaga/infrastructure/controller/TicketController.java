package com.TicketsPrueba.LuisZuluaga.infrastructure.controller;

import com.TicketsPrueba.LuisZuluaga.application.service.TicketServiceImpl;
import com.TicketsPrueba.LuisZuluaga.domain.model.Ticket;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;



@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketServiceImpl service;

    public TicketController(TicketServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity getAllTickets(@RequestParam int page, @RequestParam int size) {
        try {
            return new ResponseEntity<>(service.getAllTickets(page, size),HttpStatus.OK);
        } catch (ResponseStatusException ex) {
            return new ResponseEntity<>("No hay tickets existentes.", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getTicket(@PathVariable Long id) {
        try {
            Ticket ticket = service.getTicketById(id);
            return new ResponseEntity<>(ticket, HttpStatus.OK);
        } catch (ResponseStatusException ex) {
            return new ResponseEntity<>("El ticket no fue encontrado.", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity createTicket(@RequestBody String usuario) {
        try {
            return new ResponseEntity<>(service.createTicket(usuario),HttpStatus.CREATED);
        } catch (ResponseStatusException ex) {
            return new ResponseEntity<>("El ticket no se pudo crear.", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateTicket(@PathVariable Long id, @RequestBody String estatus) {
        try {
            return new ResponseEntity<>(service.updateTicket(id, estatus),HttpStatus.OK);
        } catch (ResponseStatusException ex) {
            return new ResponseEntity<>("El ticket no se pudo actualizar, el Estatus indicado no es valido.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTicket(@PathVariable Long id) {
        try {
            service.deleteTicket(id);
            return new ResponseEntity<>("El ticket se ha borrado con exito.",HttpStatus.OK);
        } catch (ResponseStatusException ex) {
            return new ResponseEntity<>("El ticket no existe.", HttpStatus.NOT_FOUND);
        }
    }

}
