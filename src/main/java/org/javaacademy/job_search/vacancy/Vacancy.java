package org.javaacademy.job_search.vacancy;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Vacancy {
    private final String title;
    private final String description;

    private final BigDecimal salary;
    private final String currency;
}
