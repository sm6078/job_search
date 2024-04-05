package org.javaacademy.job_search.vacancy;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CompanyRepository {
    private final Map<String, Company> companies = new LinkedHashMap<>();

    public void add(final Company company) {
        companies.put(company.getName(), company);
    }

    public Optional<Company> findCompanyByName(final String nameCompany) {
        return Optional.ofNullable(companies.get(nameCompany));

    }

    public List<Company> findAll() {
        return new ArrayList<>(companies.values());
    }

    public void deleteAll() {
        companies.clear();
    }
}
