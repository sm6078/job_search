package org.javaacademy.job_search.vacancy;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@Service
public class VacancyService {
    private final CompanyRepository companyRepository;
    @Value("${job.vacancy.currency}")
    private String currency;

    public Company findCompanyByName(final String companyName) {
        return companyRepository.findCompanyByName(companyName).orElseThrow();

    }

    public void createCompany(@NonNull String name) {
        companyRepository.add(new Company(name));
    }

    public void createVacancy(@NonNull String companyName,
                              @NonNull String title,
                              @NonNull String description,
                              @NonNull BigDecimal salary) {
        Company company = companyRepository.findCompanyByName(companyName).orElse(new Company(companyName));
        company.getVacancies().add(new Vacancy(title, description, salary, currency));
    }


    public List<Vacancy> getAllVacanciesByCompany(final String companyName) {
        return companyRepository.findCompanyByName(companyName).orElseThrow().getVacancies().stream().toList();
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public void deleteAll() {
        companyRepository.deleteAll();
    }
}
