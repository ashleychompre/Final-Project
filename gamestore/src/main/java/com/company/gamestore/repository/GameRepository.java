package com.company.gamestore.repository;

import com.company.gamestore.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository <Game,Integer> {
   //JPA queries to find games by studio and ESRB ratings

    List<Game> findByStudio(String studio);

    List<Game> findByESRB(String esrb_rating);

    Game findByTitle(String title);
}