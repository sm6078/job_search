package org.javaacademy.job_search;

import org.javaacademy.job_search.resume.ResumeService;
import org.javaacademy.job_search.vacancy.Vacancy;
import org.javaacademy.job_search.vacancy.VacancyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class JobSearchServiceTest {
    @Autowired
    private JobSearchService jobSearchService;
    @Autowired
    private VacancyService vacancyService;
    @Autowired
    private ResumeService resumeService;

    @BeforeEach
    void init() {
        jobSearchService.delete();
    }

    @Test
    void createCompanySuccess() {
        jobSearchService.createCompany("testCompany");
        Assertions.assertEquals("testCompany", vacancyService.findCompanyByName("testCompany").getName());
        Assertions.assertEquals(1, vacancyService.getAllCompanies().size());
    }

    @Test
    void createVacancySuccess() {
        vacancyService.createCompany("company");
        jobSearchService.createVacancy("company",
                "developer", "work a lot sleep little", new BigDecimal("1000"));
        List<Vacancy> vacancies = jobSearchService.getAllVacanciesByCompany("company");
        Assertions.assertEquals(vacancies.size(), 1);
        Assertions.assertEquals(vacancies.get(0).getTitle(), "developer");
    }

    @Test
    void createUserSuccess() {
        jobSearchService.createUser("user", "user@mail.ru");
        Assertions.assertEquals(resumeService.getAllUsers().size(), 1);
        Assertions.assertEquals(resumeService.findUserByEmail("user@mail.ru").getName(), "user");
        Assertions.assertEquals(resumeService.findUserByEmail("user@mail.ru").getEmail(), "user@mail.ru");
    }

    @Test
    void createResumeSuccess() {
        jobSearchService.createUser("user", "user@mail.ru");
        jobSearchService.createResume("user@mail.ru", new BigDecimal("1000"), "ready to work for food");
        Assertions.assertEquals(resumeService.getResumeByUserEmail("user@mail.ru").getExpectedSalary(), new BigDecimal("1000"));
        Assertions.assertEquals(resumeService.getResumeByUserEmail("user@mail.ru").getSkills(), "ready to work for food");
    }

    @Test
    void getAllResumeSuccess() {
        jobSearchService.createUser("user1", "user1@mail.ru");
        jobSearchService.createUser("user2", "user2@mail.ru");
        jobSearchService.createResume("user1@mail.ru", new BigDecimal("1001"), "job1");
        jobSearchService.createResume("user1@mail.ru", new BigDecimal("1002"), "job2");
        jobSearchService.createResume("user2@mail.ru", new BigDecimal("1003"), "job3");
        Assertions.assertEquals(resumeService.getAllUsers().size(), 2);
        Assertions.assertEquals(jobSearchService.getAllResume().size(), 2);
        Assertions.assertEquals(jobSearchService.getAllResume().get(0).getSkills(), "job2");
        Assertions.assertEquals(jobSearchService.getAllResume().get(1).getSkills(), "job3");
        Assertions.assertEquals(jobSearchService.getAllResume().get(0).getExpectedSalary(), new BigDecimal("1002"));
        Assertions.assertEquals(jobSearchService.getAllResume().get(1).getExpectedSalary(), new BigDecimal("1003"));
    }
}