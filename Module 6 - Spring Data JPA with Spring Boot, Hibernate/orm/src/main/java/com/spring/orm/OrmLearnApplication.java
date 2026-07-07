package com.spring.orm;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.spring.orm.model.Country;
import com.spring.orm.service.CountryService;
import com.spring.orm.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryService countryService;

    // Hands on 1
    public static void main(String[] args) {
        LOGGER.info("Inside main");

        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);

        testGetAllCountries();

        try {
            // Hands on 6
            testFindCountryByCode();
            // Hands on 7
            testAddCountry();
        } catch (CountryNotFoundException ex) {
            LOGGER.error("Country lookup failed", ex);
        }
    }

    // Hands on 1
    private static void testGetAllCountries() {
        LOGGER.info("Start - testGetAllCountries");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("Total countries loaded={}", countries.size());
        LOGGER.info("End - testGetAllCountries");
    }

    // Hands on 6
    private static void testFindCountryByCode() throws CountryNotFoundException {
        LOGGER.info("Start - testFindCountryByCode");
        Country country = countryService.findCountryByCode("IN");
        LOGGER.debug("Country found={}", country);
        LOGGER.info("End - testFindCountryByCode");
    }

    // Hands on 7
    private static void testAddCountry() throws CountryNotFoundException {
        LOGGER.info("Start - testAddCountry");

        Country newCountry = new Country("ZZ", "Testland");
        countryService.addCountry(newCountry);

        Country savedCountry = countryService.findCountryByCode("ZZ");
        LOGGER.debug("Newly added country={}", savedCountry);

        LOGGER.info("End - testAddCountry");
    }
}