package com.company.gamestore.repository;

import com.company.gamestore.models.Console;
import com.company.gamestore.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

   List<Invoice> findByName(String name);

}
