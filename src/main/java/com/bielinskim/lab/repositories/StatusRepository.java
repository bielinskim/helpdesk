package com.bielinskim.lab.repositories;

import com.bielinskim.lab.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Integer> {
}