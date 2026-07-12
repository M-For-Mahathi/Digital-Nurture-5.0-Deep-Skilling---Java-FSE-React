package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// File 1: Hands on 1
@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("START");
        SpringApplication.run(SpringLearnApplication.class, args);
        LOGGER.info("END");
    }

    // File 1: Hands on 2
    public void displayDate() {
        // File 1: Hands on 3
        LOGGER.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
        SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
        try {
            Date date = format.parse("31/12/2018");
            LOGGER.debug(date.toString());
        } catch (ParseException e) {
            LOGGER.debug(e.getMessage());
        }
        LOGGER.info("END");
    }

    // File 1: Hands on 4
    public void displayCountry() {
        LOGGER.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("country", Country.class);
        LOGGER.debug("Country : {}", country.toString());

        // File 1: Hands on 5
        Country anotherCountry = context.getBean("country", Country.class);
        LOGGER.debug("Another Country : {}", anotherCountry.toString());
        LOGGER.info("END");
    }

    // File 1: Hands on 6
    @SuppressWarnings("unchecked")
    public void displayCountries() {
        LOGGER.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        List<Country> countryList = context.getBean("countryList", ArrayList.class);
        LOGGER.debug("Countries : {}", countryList.toString());
        LOGGER.info("END");
    }
}