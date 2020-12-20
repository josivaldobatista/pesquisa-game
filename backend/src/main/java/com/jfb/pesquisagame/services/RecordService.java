package com.jfb.pesquisagame.services;

import java.time.Instant;

import com.jfb.pesquisagame.models.dto.RecordDTO;
import com.jfb.pesquisagame.models.dto.RecordInsertDTO;
import com.jfb.pesquisagame.models.entities.Game;
import com.jfb.pesquisagame.models.entities.Record;
import com.jfb.pesquisagame.repositories.GameRepository;
import com.jfb.pesquisagame.repositories.RecordRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecordService {

	@Autowired
	private RecordRepository repository;

	@Autowired
	private GameRepository gameRepository;

	@Transactional
	public RecordDTO insert(RecordInsertDTO dto) {
		Record entity = new Record();
		entity.setName(dto.getName());
		entity.setAge(dto.getAge());
		entity.setMoment(Instant.now());

		Game game = gameRepository.getOne(dto.getGameId());
		entity.setGame(game);

		repository.save(entity);
		return new RecordDTO(entity);
	}

	@Transactional(readOnly = true)
	public Page<RecordDTO> findByMoment(
		Instant minDate, Instant maxDate, PageRequest pageRequest) {
		return repository.findByMoment(minDate, maxDate, pageRequest)
			.map(x -> new RecordDTO(x));
	}
}
