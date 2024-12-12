package com.TicketsPrueba.LuisZuluaga.infrastructure.adapter;

import com.TicketsPrueba.LuisZuluaga.domain.model.Ticket;
import com.TicketsPrueba.LuisZuluaga.domain.service.TicketService;
import com.TicketsPrueba.LuisZuluaga.infrastructure.mapper.TicketMapper;
import com.TicketsPrueba.LuisZuluaga.infrastructure.persistence.repository.TicketRepository;
import com.TicketsPrueba.LuisZuluaga.infrastructure.persistence.entity.TicketEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TicketRepositoryAdapter implements TicketService {

    private final TicketRepository repository;

    public TicketRepositoryAdapter(TicketRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Ticket> findAll(int page, int size) {
        return repository.findAll(PageRequest.of(page, size))
                .map(TicketMapper::toDomainModel)
                .toList();
    }

    @Override
    public Optional<Ticket> findById(Long id) {
        return repository.findById(id).map(TicketMapper::toDomainModel);
    }

    @Override
    public Ticket save(Ticket ticket) {
        TicketEntity entity = TicketMapper.toEntity(ticket);
        TicketEntity savedEntity = repository.save(entity);
        return TicketMapper.toDomainModel(savedEntity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
