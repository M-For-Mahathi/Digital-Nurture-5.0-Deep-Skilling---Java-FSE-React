// 1. Hands on 1
package com.spring.orm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.orm.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    // 2. Hands on 1
    List<Country> findByNameContaining(String text);

    // 2. Hands on 1
    List<Country> findByNameContainingOrderByNameAsc(String text);

    // 2. Hands on 1
    List<Country> findByNameStartingWith(String letter);
}