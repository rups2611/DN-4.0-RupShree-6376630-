package com.cognizant.spring_learn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.spring_learn.model.Country;

@Service
public class CountryService {

    public Country getCountry(String code) {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        @SuppressWarnings("unchecked")
        List<Country> countries = (List<Country>) context.getBean("countryList");

        Optional<Country> match = countries.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst();

        if (match.isPresent()) {
            return match.get();
        } else {
            throw new RuntimeException("Country not found");
        }
    }
}
