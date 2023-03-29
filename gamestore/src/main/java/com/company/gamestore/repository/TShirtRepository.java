package com.company.gamestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.company.gamestore.models.TShirt;

@Repository
public interface TShirtRepository extends JpaRepository<TShirt, Integer> {



}
