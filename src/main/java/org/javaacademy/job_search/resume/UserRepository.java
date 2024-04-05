package org.javaacademy.job_search.resume;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@AllArgsConstructor
public class UserRepository {
    private final Map<String, User> users = new LinkedHashMap<>();

    protected void add(User user) {
        users.put(user.getEmail(), user);
    }

    protected List<User> getAll() {
        return new ArrayList<>(users.values());
    }

    protected Optional<User> findUserByEmail(String email) {
        return Optional.ofNullable(users.get(email));
    }

    protected void deleteAll() {
        users.clear();
    }
}
