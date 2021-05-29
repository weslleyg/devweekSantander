package com.project.devweek.service;

import com.project.devweek.mapper.StockMapper;
import com.project.devweek.model.Stock;
import com.project.devweek.model.dto.StockDTO;
import com.project.devweek.repository.StockRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockService {

  @Autowired
  private StockRepository repository;

  @Autowired
  private StockMapper mapper;

  @Transactional
  public StockDTO save(StockDTO dto) {

    Stock stock = mapper.toEntity(dto);
    repository.save(stock);

    return mapper.toDto(stock);

  }



}