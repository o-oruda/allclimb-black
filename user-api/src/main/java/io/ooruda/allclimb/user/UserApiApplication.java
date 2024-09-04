package io.ooruda.allclimb.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"io.ooruda.allclimb.module.database"})
@EntityScan(basePackages = {"io.ooruda.allclimb.module.database"})
@SpringBootApplication(scanBasePackages = {"io.ooruda.allclimb"})
public class UserApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApiApplication.class, args);
    }
}
