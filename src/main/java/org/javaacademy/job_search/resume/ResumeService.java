package org.javaacademy.job_search.resume;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class ResumeService {
    private final UserRepository userRepository;

    public void createUser(@NonNull String name, @NonNull String email) {
        userRepository.add(new User(name, email));
    }

    public User findUserByEmail(@NonNull String email) {
        return userRepository.findUserByEmail(email).orElseThrow();
    }

    public List<User> getAllUsers() {
        return userRepository.getAll();
    }

    public void createResume(@NonNull String email, @NonNull String skills,
                             @NonNull BigDecimal salary) {
        User user = userRepository.findUserByEmail(email).orElseThrow();
        user.setResume(new Resume(salary, skills));
    }

    public Resume getResumeByUserEmail(@NonNull String email) {
        return userRepository.findUserByEmail(email).orElseThrow().getResume();
    }

    public List<Resume> getAllResume() {
        return userRepository.getAll()
                .stream()
                .map(User::getResume)
                .toList();
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }
}
