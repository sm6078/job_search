package org.javaacademy.job_search;

import org.javaacademy.job_search.resume.ResumeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.NoSuchElementException;

@SpringBootTest
public class ResumeServiceTest {
    @Autowired
    private ResumeService resumeService;

    @BeforeEach
    void init() {
        resumeService.deleteAll();
    }

    @Test
    void createUserSuccess() {
        resumeService.createUser("user", "user@mail");
        Assertions.assertEquals(resumeService.getAllUsers().size(), 1);
        Assertions.assertEquals(resumeService.findUserByEmail("user@mail").getName(), "user");
    }

    @Test
    void createCompanyFail() {
        Assertions.assertThrows(
                NoSuchElementException.class,
                () -> resumeService.findUserByEmail("user@mail")
        );
    }
}
