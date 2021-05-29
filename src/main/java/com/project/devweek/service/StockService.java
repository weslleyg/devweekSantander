package com.project.devweek.service;

import java.util.Optional;

import com.project.devweek.exceptions.BusinessException;
import com.project.devweek.mapper.StockMapper;
import com.project.devweek.model.Stock;
import com.project.devweek.model.dto.StockDTO;
import com.project.devweek.repository.StockRepository;
import com.project.devweek.util.MessageUtils;

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

    Optional<Stock> optionalStock = repository.findByNameAndDate(dto.getName(), dto.getDate());

    if(optionalStock.isPresent()) {
      throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
    }

    Stock stock = mapper.toEntity(dto);
    repository.save(stock);

    return mapper.toDto(stock);

  }



}