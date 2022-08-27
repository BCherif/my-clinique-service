package com.dev.myclinique.auth.config;

import com.dev.myclinique.app.entities.Administrator;
import com.dev.myclinique.app.repositories.AdministratorRepository;
import com.dev.myclinique.auth.entity.User;
import com.dev.myclinique.auth.repository.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class InitUsers implements ApplicationRunner {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AdministratorRepository administratorRepository;

    public InitUsers(PasswordEncoder passwordEncoder,
                     UserRepository userRepository, AdministratorRepository administratorRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.administratorRepository = administratorRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (userRepository.findByUsername("MyClinique") != null) return;
        User user = User
                .builder()
                .username("MyClinique")
                .password(passwordEncoder.encode("MyClinique2K22"))
                .active(true)
                .admin(true)
                .build();
        User userSaved = userRepository.save(user);
        Administrator administrator = Administrator
                .builder()
                .firstName("100T")
                .lastName("2022")
                .user(userSaved)
                .build();
        administratorRepository.save(administrator);
    }
}
