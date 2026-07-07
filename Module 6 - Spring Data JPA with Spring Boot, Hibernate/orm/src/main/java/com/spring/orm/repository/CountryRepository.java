// Hands on 1
package com.spring.orm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.orm.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
}