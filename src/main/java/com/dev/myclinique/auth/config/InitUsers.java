package com.dev.myclinique.auth.config;

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

    public InitUsers(PasswordEncoder passwordEncoder,
                     UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (userRepository.findByUsername("MyClinique") != null) return;
        User user = User
                .builder()
                .username("MyClinique")
                .password(passwordEncoder.encode("MyClinique2K22"))
                .firstName("Baba Soumaila")
                .lastName("MAIGA")
                .fullName("Baba Soumaila MAIGA")
                .phone("79369550")
                .email("cherif@bab.org")
                .address("Banankabougou")
                .active(true)
                .admin(true)
                .build();
        userRepository.save(user);
    }
}
