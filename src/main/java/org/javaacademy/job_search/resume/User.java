package org.javaacademy.job_search.resume;

import lombok.Data;

@Data
public class User {
    private final String name;
    private final String email;
    private Resume resume;
}
