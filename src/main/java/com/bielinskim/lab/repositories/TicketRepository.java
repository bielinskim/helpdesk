package com.bielinskim.lab.repositories;

import com.bielinskim.lab.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}

