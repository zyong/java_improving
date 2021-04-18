package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDemo01 {

    @Autowired
    School school;

    public static void main(String[] args) {
        SpringApplication.run(SpringDemo01.class, args);
    }

    @Bean
    public void printInfo() {
        school.ding();
        school.class1.dong();
    }
}
