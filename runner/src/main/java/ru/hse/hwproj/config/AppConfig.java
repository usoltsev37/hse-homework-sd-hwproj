package ru.hse.hwproj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.hse.hwproj.logic.checker.GithubSubmissionChecker;
import ru.hse.hwproj.logic.checker.SubmissionChecker;

@Configuration
public class AppConfig {

    @Bean
    public SubmissionChecker submissionChecker() {
        return new GithubSubmissionChecker();
    }
}
