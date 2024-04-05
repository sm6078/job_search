package org.javaacademy.job_search;

import org.javaacademy.job_search.vacancy.VacancyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.NoSuchElementException;

@SpringBootTest
public class VacancyServiceTest {
    @Autowired
    private VacancyService vacancyService;

    @BeforeEach
    void init() {
        vacancyService.deleteAll();
    }

    @Test
    void createCompanySuccess() {
        vacancyService.createCompany("company");
        Assertions.assertEquals("company", vacancyService.findCompanyByName("company").getName());
        Assertions.assertEquals(1, vacancyService.getAllCompanies().size());
    }

    @Test
    void createCompanyFail() {
        Assertions.assertThrows(
                NoSuchElementException.class,
                () -> vacancyService.findCompanyByName("user@mail")
        );
    }
}
