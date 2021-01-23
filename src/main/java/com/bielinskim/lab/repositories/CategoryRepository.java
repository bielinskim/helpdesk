package com.bielinskim.lab.repositories;

import com.bielinskim.lab.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
