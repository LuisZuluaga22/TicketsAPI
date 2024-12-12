package com.TicketsPrueba.LuisZuluaga.domain.model;

import java.time.LocalDateTime;

public class Ticket {

    private Long id;
    private String usuario;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
    private String estatus;

    public Ticket(Long id, String usuario, LocalDateTime fechaCreacion, LocalDateTime fechaActualizacion, String estatus) {
        this.id = id;
        this.usuario = usuario;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
        this.estatus = estatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
