package ru.hse.hwproj.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class RabbitRunner implements CommandLineRunner {

    @Autowired
    private ConfigurableApplicationContext ctx;

    @Override
    public void run(String... arg0) {
        while (ctx.isActive()) {

        }
    }
}