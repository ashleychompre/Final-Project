package com.company.gamestore.repository;

import com.company.gamestore.models.Console;
import com.company.gamestore.models.Tax;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface TaxRepository extends JpaRepository<Tax, Integer> {
    Tax findByState(String state);
}
