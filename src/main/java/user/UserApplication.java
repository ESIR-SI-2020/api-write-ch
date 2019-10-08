package user;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class UserApplication {
    public static void main(String... args) {
        SpringApplication.run(UserApplication.class, args);
    }
}

