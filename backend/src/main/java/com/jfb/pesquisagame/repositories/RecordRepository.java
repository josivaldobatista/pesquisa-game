package com.jfb.pesquisagame.repositories;

import java.time.Instant;

import com.jfb.pesquisagame.models.entities.Record;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long>{

    @Query(
    "SELECT obj FROM Record obj WHERE "
    + "(coalesce(:min, null) IS NULL OR obj.moment >= :min) AND " 
    + "(coalesce(:max, null) IS NULL OR obj.moment <= :max)")
	Page<Record> findByMoment(Instant min, Instant max, Pageable pageable);
}