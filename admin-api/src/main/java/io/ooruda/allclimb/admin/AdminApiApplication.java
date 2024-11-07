package io.ooruda.allclimb.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"io.ooruda.allclimb.module.database", "io.ooruda.allclimb.admin"})
@EntityScan(basePackages = {"io.ooruda.allclimb.module.database.entity"})
@SpringBootApplication(scanBasePackages = {"io.ooruda.allclimb"})
public class AdminApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApiApplication.class, args);
    }
}
