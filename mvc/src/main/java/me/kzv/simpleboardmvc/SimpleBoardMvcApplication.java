package me.kzv.simpleboardmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SimpleBoardMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleBoardMvcApplication.class, args);
    }

}
