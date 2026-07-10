// 2. Hands on 2
package com.spring.orm.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.orm.model.Stock;
import com.spring.orm.repository.StockRepository;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    @Transactional
    public List<Stock> getByCodeAndDateRange(String code, LocalDate start, LocalDate end) {
        return stockRepository.findByCodeAndDateBetween(code, start, end);
    }

    @Transactional
    public List<Stock> getByCodeAboveOpenPrice(String code, BigDecimal open) {
        return stockRepository.findByCodeAndOpenGreaterThan(code, open);
    }

    @Transactional
    public List<Stock> getTopVolumeDates() {
        return stockRepository.findTop3ByOrderByVolumeDesc();
    }

    @Transactional
    public List<Stock> getLowestCloseDates(String code) {
        return stockRepository.findTop3ByCodeOrderByCloseAsc(code);
    }
}