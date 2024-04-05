package org.javaacademy.job_search.resume;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Objects;

@Data
public class Resume {
    private final BigDecimal expectedSalary;
    private final String skills;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Resume resume = (Resume) o;
        return Objects.equals(getExpectedSalary(), resume.getExpectedSalary())
                && Objects.equals(getSkills(), resume.getSkills());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getExpectedSalary(), getSkills());
    }
}
