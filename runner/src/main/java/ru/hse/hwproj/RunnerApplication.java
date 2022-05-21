package ru.hse.hwproj;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import ru.hse.hwproj.runner.RabbitRunner;

@SpringBootApplication
public class RunnerApplication {

    @Profile("usage_message")
    @Bean
    public CommandLineRunner usage() {
        return args -> {
            System.out.println("This app uses Spring Profiles to control its behavior.\n");
            System.out.println("Sample usage: java -jar rabbit-tutorials.jar --spring.profiles.active=hello-world,sender");
        };
    }

    @Profile("receiver")
    @Bean
    public CommandLineRunner runner() {
        return new RabbitRunner();
    }

    public static void main(String[] args) {
        SpringApplication.run(RunnerApplication.class, args);
    }

}
