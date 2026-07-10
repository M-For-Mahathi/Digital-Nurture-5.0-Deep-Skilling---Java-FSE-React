package com.spring.orm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.orm.model.Country;
import com.spring.orm.repository.CountryRepository;
import com.spring.orm.service.exception.CountryNotFoundException;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    // 1. Hands on 1
    @Transactional
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    // 1. Hands on 6
    @Transactional
    public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
        Optional<Country> result = countryRepository.findById(countryCode);
        if (!result.isPresent()) {
            throw new CountryNotFoundException("No country found for code: " + countryCode);
        }
        return result.get();
    }

    // 1. Hands on 7
    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    // 2. Hands on 1
    @Transactional
    public List<Country> searchByText(String text) {
        return countryRepository.findByNameContaining(text);
    }

    // 2. Hands on 1
    @Transactional
    public List<Country> searchByTextSorted(String text) {
        return countryRepository.findByNameContainingOrderByNameAsc(text);
    }

    // 2. Hands on 1
    @Transactional
    public List<Country> searchByStartingLetter(String letter) {
        return countryRepository.findByNameStartingWith(letter);
    }
}