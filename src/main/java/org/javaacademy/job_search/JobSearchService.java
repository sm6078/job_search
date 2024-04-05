package org.javaacademy.job_search;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.javaacademy.job_search.resume.Resume;
import org.javaacademy.job_search.resume.ResumeService;
import org.javaacademy.job_search.vacancy.Vacancy;
import org.javaacademy.job_search.vacancy.VacancyService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class JobSearchService {

    private final VacancyService vacancyService;
    private final ResumeService resumeService;

    public void createCompany(@NonNull String name) {
        vacancyService.createCompany(name);
    }

    public void createVacancy(@NonNull String companyName,
                              @NonNull String title,
                              @NonNull String description,
                              @NonNull BigDecimal salary) {
        vacancyService.createVacancy(companyName, title, description, salary);
    }

    public List<Vacancy> getAllVacanciesByCompany(@NonNull String companyName) {
        return vacancyService.getAllVacanciesByCompany(companyName);
    }

    public void createUser(@NonNull String name, @NonNull String email) {
        resumeService.createUser(name, email);
    }

    public void createResume(@NonNull String email, @NonNull BigDecimal salary,
                             @NonNull String skills) {
        resumeService.createResume(email, skills, salary);
    }

    public List<Resume> getAllResume() {
        return resumeService.getAllResume();
    }

    public void delete() {
        vacancyService.deleteAll();
        resumeService.deleteAll();
    }
}
