package com.jpa;

import com.jpa.domain.primary.UserPrimary;
import com.jpa.domain.secondary.UserSecondary;
import com.jpa.repository.primary.UserPrimaryRepository;
import com.jpa.repository.secondary.UserSecondaryProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaMultiDatasourceApplication implements CommandLineRunner {

    @Autowired
    UserSecondaryProperty userSecondaryProperty;
    @Autowired
    UserPrimaryRepository userPrimaryRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaMultiDatasourceApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        UserPrimary userPrimary = new UserPrimary("username", "password");
        UserPrimary userPrimaryQuery = userPrimaryRepository.save(userPrimary);
        UserSecondary userSecondary = new UserSecondary("username", "password");
        UserSecondary userSecondaryQuery = userSecondaryProperty.save(userSecondary);
    }
}
