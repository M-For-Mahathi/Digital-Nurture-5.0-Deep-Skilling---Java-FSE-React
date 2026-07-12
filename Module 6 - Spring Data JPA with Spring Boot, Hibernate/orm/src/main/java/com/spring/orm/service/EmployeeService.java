package com.spring.orm.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.orm.model.Employee;
import com.spring.orm.repository.EmployeeRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Service
public class EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    // 3. Hands on 6
    @PersistenceContext
    private EntityManager entityManager;

    // 2. Hands on 4
    @Transactional
    public Employee get(int id) {
        LOGGER.info("Start");
        return employeeRepository.findById(id).get();
    }

    // 2. Hands on 4
    @Transactional
    public void save(Employee employee) {
        LOGGER.info("Start");
        employeeRepository.save(employee);
        LOGGER.info("End");
    }

    // 3. Hands on 2
    @Transactional
    public List<Employee> getAllPermanentEmployees() {
        return employeeRepository.getAllPermanentEmployees();
    }

    // 3. Hands on 4
    @Transactional
    public double getAverageSalary() {
        return employeeRepository.getAverageSalary();
    }

    // 3. Hands on 4
    @Transactional
    public double getAverageSalary(int departmentId) {
        return employeeRepository.getAverageSalary(departmentId);
    }

    // 3. Hands on 5
    @Transactional
    public List<Employee> getAllEmployeesNative() {
        return employeeRepository.getAllEmployeesNative();
    }

    // 3. Hands on 6 - dynamic filter built with Criteria Query, mirrors the
    // Amazon-style "apply only the filters the user picked" scenario from the doc
    @Transactional
    public List<Employee> searchEmployees(Integer departmentId, Boolean permanent, Double minSalary) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
        Root<Employee> root = query.from(Employee.class);

        List<Predicate> predicates = new ArrayList<>();

        if (departmentId != null) {
            predicates.add(builder.equal(root.get("department").get("id"), departmentId));
        }
        if (permanent != null) {
            predicates.add(builder.equal(root.get("permanent"), permanent));
        }
        if (minSalary != null) {
            predicates.add(builder.greaterThanOrEqualTo(root.get("salary"), minSalary));
        }

        query.select(root).where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(query).getResultList();
    }
}