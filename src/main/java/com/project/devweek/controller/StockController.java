package com.project.devweek.controller;

import com.project.devweek.model.dto.StockDTO;
import com.project.devweek.service.StockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/stock")
public class StockController {

    @Autowired
    private StockService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> save(@Valid @RequestBody StockDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> update(@Valid @RequestBody StockDTO dto) {
        return ResponseEntity.ok(dto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findAll() {

        List<StockDTO> list = new ArrayList<>();
        StockDTO dto = new StockDTO();

        dto.setId(1L);
        dto.setName("Magazine");
        dto.setPrice(100D);
        dto.setVariation(10D);
        dto.setDate(LocalDate.now());
        list.add(dto);

        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> findById(@PathVariable Long id) {
        List<StockDTO> list = new ArrayList<>();
        StockDTO dto1 = new StockDTO();

        dto1.setId(1L);
        dto1.setName("Magazine");
        dto1.setPrice(100D);
        dto1.setVariation(10D);
        dto1.setDate(LocalDate.now());
        list.add(dto1);

        StockDTO dto2 = new StockDTO();

        dto2.setId(2L);
        dto2.setName("B3SA3");
        dto2.setPrice(40D);
        dto2.setVariation(30D);
        dto2.setDate(LocalDate.now());
        list.add(dto2);

        StockDTO select = list.stream().filter(x -> x.getId().compareTo(id) == 0).findFirst().get();

        return ResponseEntity.ok(select);
    }
}
