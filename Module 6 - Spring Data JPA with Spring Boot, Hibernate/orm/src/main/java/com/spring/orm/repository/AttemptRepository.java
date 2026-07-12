// 3. Hands on 3
package com.spring.orm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.orm.model.Attempt;

@Repository
public interface AttemptRepository extends JpaRepository<Attempt, Integer> {

    @Query(value = "SELECT DISTINCT a FROM Attempt a "
            + "JOIN FETCH a.user u "
            + "JOIN FETCH a.attemptQuestions aq "
            + "JOIN FETCH aq.question q "
            + "JOIN FETCH q.options "
            + "LEFT JOIN FETCH aq.attemptOptions ao "
            + "LEFT JOIN FETCH ao.option "
            + "WHERE u.id = :userId AND a.id = :attemptId")
    Attempt getAttempt(@Param("userId") int userId, @Param("attemptId") int attemptId);
}