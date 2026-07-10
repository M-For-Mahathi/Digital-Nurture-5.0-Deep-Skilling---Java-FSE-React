// 2. Hands on 3
package com.spring.orm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.orm.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}