package br.com.artfrc.demo.startup;

import org.apache.catalina.core.ApplicationFilterConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);


    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
        String applicationName = ctx.getEnvironment().getProperty("spring.application.name");

        String message = String.format("| %-" + 48 + "s |", "Application " + applicationName + " is running!");
        logger.info("\n|--------------------------------------------------|\n" +
                message + "\n" +
                "|--------------------------------------------------|");

    }
}
