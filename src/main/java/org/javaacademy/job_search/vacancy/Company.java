package org.javaacademy.job_search.vacancy;


import lombok.Data;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;


@Data
public class Company {
    private final String name;
    private final Set<Vacancy> vacancies = new HashSet<>();
}
