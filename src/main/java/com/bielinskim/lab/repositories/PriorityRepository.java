package com.bielinskim.lab.repositories;

import com.bielinskim.lab.models.Priority;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PriorityRepository extends JpaRepository<Priority, Integer> {
}
