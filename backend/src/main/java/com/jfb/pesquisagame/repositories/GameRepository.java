package com.jfb.pesquisagame.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jfb.pesquisagame.models.entities.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long>{
}
