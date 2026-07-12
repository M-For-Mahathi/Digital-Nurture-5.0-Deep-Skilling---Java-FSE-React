package com.spring.orm;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.spring.orm.model.Attempt;
import com.spring.orm.model.AttemptOption;
import com.spring.orm.model.AttemptQuestion;
import com.spring.orm.model.Country;
import com.spring.orm.model.Department;
import com.spring.orm.model.Employee;
import com.spring.orm.model.Options;
import com.spring.orm.model.Skill;
import com.spring.orm.model.Stock;
import com.spring.orm.service.AttemptService;
import com.spring.orm.service.CountryService;
import com.spring.orm.service.DepartmentService;
import com.spring.orm.service.EmployeeService;
import com.spring.orm.service.SkillService;
import com.spring.orm.service.StockService;
import com.spring.orm.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    // 1. Hands on 1
    private static CountryService countryService;

    // 2. Hands on 2
    private static StockService stockService;

    // 2. Hands on 4
    private static EmployeeService employeeService;
    private static DepartmentService departmentService;
    private static SkillService skillService;

    // 3. Hands on 3
    private static AttemptService attemptService;

    // 1. Hands on 1
    public static void main(String[] args) {
        LOGGER.info("Inside main");

        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);
        // 2. Hands on 2
        stockService = context.getBean(StockService.class);
        // 2. Hands on 4
        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);
        skillService = context.getBean(SkillService.class);
        // 3. Hands on 3
        attemptService = context.getBean(AttemptService.class);

        testGetAllCountries();

        try {
            // 1. Hands on 6
            testFindCountryByCode();
            // 1. Hands on 7
            testAddCountry();

            // 2. Hands on 1
            // testSearchCountryByText();
            // testSearchCountryByTextSorted();
            // testSearchCountryByLetter();

            // 2. Hands on 2
            // testFacebookSeptember2019();
            // testGoogleAbove1250();
            // testTopVolumeDates();
            // testNetflixLowestClose();

            // 2. Hands on 4, 6
            // testGetEmployee();
            // testAddEmployee();
            // testUpdateEmployee();

            // 2. Hands on 5
            // testGetDepartment();

            // 2. Hands on 6
            // testAddSkillToEmployee();

            // 3. Hands on 2
            // testGetAllPermanentEmployees();

            // 3. Hands on 3
            // testGetAttemptDetail();

            // 3. Hands on 4
            // testGetAverageSalary();
            // testGetAverageSalaryByDepartment();

            // 3. Hands on 5
            // testGetAllEmployeesNative();

            // 3. Hands on 6
            // testSearchEmployeesCriteria();
        } catch (CountryNotFoundException ex) {
            LOGGER.error("Country lookup failed", ex);
        }
    }

    // 1. Hands on 1
    private static void testGetAllCountries() {
        LOGGER.info("Start - testGetAllCountries");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("Total countries loaded={}", countries.size());
        LOGGER.info("End - testGetAllCountries");
    }

    // 1. Hands on 6
    private static void testFindCountryByCode() throws CountryNotFoundException {
        LOGGER.info("Start - testFindCountryByCode");
        Country country = countryService.findCountryByCode("IN");
        LOGGER.debug("Country found={}", country);
        LOGGER.info("End - testFindCountryByCode");
    }

    // 1. Hands on 7
    private static void testAddCountry() throws CountryNotFoundException {
        LOGGER.info("Start - testAddCountry");

        Country newCountry = new Country("ZZ", "Testland");
        countryService.addCountry(newCountry);

        Country savedCountry = countryService.findCountryByCode("ZZ");
        LOGGER.debug("Newly added country={}", savedCountry);

        LOGGER.info("End - testAddCountry");
    }

    // 2. Hands on 1
    private static void testSearchCountryByText() {
        LOGGER.info("Start - testSearchCountryByText");
        List<Country> countries = countryService.searchByText("ou");
        countries.forEach(c -> LOGGER.debug("Match={}", c));
        LOGGER.info("End - testSearchCountryByText");
    }

    // 2. Hands on 1
    private static void testSearchCountryByTextSorted() {
        LOGGER.info("Start - testSearchCountryByTextSorted");
        List<Country> countries = countryService.searchByTextSorted("ou");
        countries.forEach(c -> LOGGER.debug("Match={}", c));
        LOGGER.info("End - testSearchCountryByTextSorted");
    }

    // 2. Hands on 1
    private static void testSearchCountryByLetter() {
        LOGGER.info("Start - testSearchCountryByLetter");
        List<Country> countries = countryService.searchByStartingLetter("Z");
        countries.forEach(c -> LOGGER.debug("Match={}", c));
        LOGGER.info("End - testSearchCountryByLetter");
    }

    // 2. Hands on 2
    private static void testFacebookSeptember2019() {
        LOGGER.info("Start");
        List<Stock> stocks = stockService.getByCodeAndDateRange("FB",
                LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30));
        stocks.forEach(s -> LOGGER.debug("FB Sept:{}", s));
        LOGGER.info("End");
    }

    // 2. Hands on 2
    private static void testGoogleAbove1250() {
        LOGGER.info("Start");
        List<Stock> stocks = stockService.getByCodeAboveOpenPrice("GOOGL", new BigDecimal("1250"));
        stocks.forEach(s -> LOGGER.debug("GOOGL >1250:{}", s));
        LOGGER.info("End");
    }

    // 2. Hands on 2
    private static void testTopVolumeDates() {
        LOGGER.info("Start");
        List<Stock> stocks = stockService.getTopVolumeDates();
        stocks.forEach(s -> LOGGER.debug("Top volume:{}", s));
        LOGGER.info("End");
    }

    // 2. Hands on 2
    private static void testNetflixLowestClose() {
        LOGGER.info("Start");
        List<Stock> stocks = stockService.getLowestCloseDates("NFLX");
        stocks.forEach(s -> LOGGER.debug("NFLX lowest close:{}", s));
        LOGGER.info("End");
    }

    // 2. Hands on 4
    // NOTE: after 3. Hands on 2 removed EAGER fetch, this method's skill/department
    // reads will throw LazyInitializationException unless called through a fetch-join
    // query like getAllPermanentEmployees(). Kept here for reference only.
    private static void testGetEmployee() {
        LOGGER.info("Start");
        Employee employee = employeeService.get(1);
        LOGGER.debug("Employee:{}", employee);
        LOGGER.debug("Department:{}", employee.getDepartment());
        LOGGER.debug("Skills:{}", employee.getSkillList());
        LOGGER.info("End");
    }

    // 2. Hands on 4
    private static void testAddEmployee() {
        LOGGER.info("Start");
        Employee employee = new Employee();
        employee.setName("Karthik Iyer");
        employee.setSalary(60000);
        employee.setPermanent(true);

        Department department = departmentService.get(1);
        employee.setDepartment(department);

        employeeService.save(employee);
        LOGGER.debug("Saved employee:{}", employee);
        LOGGER.info("End");
    }

    // 2. Hands on 4
    private static void testUpdateEmployee() {
        LOGGER.info("Start");
        Employee employee = employeeService.get(1);

        Department department = departmentService.get(2);
        employee.setDepartment(department);

        employeeService.save(employee);
        LOGGER.debug("Updated employee:{}", employee);
        LOGGER.info("End");
    }

    // 2. Hands on 5
    // NOTE: after 3. Hands on 2 removed EAGER fetch, department.getEmployeeList()
    // will throw LazyInitializationException here. Kept here for reference only.
    private static void testGetDepartment() {
        LOGGER.info("Start");
        Department department = departmentService.get(1);
        LOGGER.debug("Department:{}", department);
        LOGGER.debug("Employees:{}", department.getEmployeeList());
        LOGGER.info("End");
    }

    // 2. Hands on 6
    private static void testAddSkillToEmployee() {
        LOGGER.info("Start");
        Employee employee = employeeService.get(3);
        Skill skill = skillService.get(4);

        employee.getSkillList().add(skill);
        employeeService.save(employee);

        LOGGER.debug("Employee with new skill:{}", employee.getSkillList());
        LOGGER.info("End");
    }

    // 3. Hands on 2
    private static void testGetAllPermanentEmployees() {
        LOGGER.info("Start");
        List<Employee> employees = employeeService.getAllPermanentEmployees();
        LOGGER.debug("Permanent Employees:{}", employees);
        employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList()));
        LOGGER.info("End");
    }

    // 3. Hands on 3
    private static void testGetAttemptDetail() {
        LOGGER.info("Start");

        Attempt attempt = attemptService.getAttempt(1, 1);

        for (AttemptQuestion aq : attempt.getAttemptQuestions()) {
            LOGGER.debug(aq.getQuestion().getText());

            int selectedOptionId = -1;
            for (AttemptOption ao : aq.getAttemptOptions()) {
                selectedOptionId = ao.getOption().getId();
            }

            int index = 1;
            for (Options option : aq.getQuestion().getOptions()) {
                boolean selected = option.getId() == selectedOptionId;
                LOGGER.debug(" {}) {}\t{}\t{}", index, option.getText(), option.getScore(), selected);
                index++;
            }
        }

        LOGGER.info("End");
    }

    // 3. Hands on 4
    private static void testGetAverageSalary() {
        LOGGER.info("Start");
        double average = employeeService.getAverageSalary();
        LOGGER.debug("Average salary:{}", average);
        LOGGER.info("End");
    }

    // 3. Hands on 4
    private static void testGetAverageSalaryByDepartment() {
        LOGGER.info("Start");
        double average = employeeService.getAverageSalary(1);
        LOGGER.debug("Average salary for department 1:{}", average);
        LOGGER.info("End");
    }

    // 3. Hands on 5
    private static void testGetAllEmployeesNative() {
        LOGGER.info("Start");
        List<Employee> employees = employeeService.getAllEmployeesNative();
        employees.forEach(e -> LOGGER.debug("Employee:{}", e));
        LOGGER.info("End");
    }

    // 3. Hands on 6
    private static void testSearchEmployeesCriteria() {
        LOGGER.info("Start");
        List<Employee> employees = employeeService.searchEmployees(1, true, 60000.0);
        employees.forEach(e -> LOGGER.debug("Match:{}", e));
        LOGGER.info("End");
    }
}