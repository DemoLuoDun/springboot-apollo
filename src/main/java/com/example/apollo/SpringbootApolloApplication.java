package com.example.apollo;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//@EnableApolloConfig
@ImportResource("classpath:springboot-apollo.xml")
public class SpringbootApolloApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApolloApplication.class, args);
    }

}
