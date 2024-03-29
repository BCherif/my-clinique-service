package com.dev.myclinique.auth.service;

import com.dev.myclinique.auth.entity.User;
import com.dev.myclinique.auth.repository.UserRepository;
import com.dev.myclinique.base.response.CResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.dev.myclinique.utils.Utils.getDefaultPageable;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public CResponse<List<User>> listOfUsers() {
        try {
            List<User> users = userRepository.findAll();
            return CResponse.success(users, users.size() + " utilisateur.s trouve.s");
        } catch (Exception e) {
            e.printStackTrace();
            return CResponse.error("Une erreur est servenue!");
        }
    }

    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(getDefaultPageable(pageable));
    }

    public CResponse<User> create(User user) {
        if (!userRepository.existsByUsername(user.getUsername())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            User utilisateur = userRepository.save(user);
            return CResponse.success(utilisateur, "Utilisateur ajouté avec succes");
        } else {
            return CResponse.error("Ce nom d'utilisateur est déjà utilisé");
        }
    }


    public CResponse<User> edit(User user) {
        try {
            // if empty so => not exist, else => exist
            boolean existingUser = userRepository.checkExistingUser(user.getId(), user.getUsername()).isEmpty();
            if (!existingUser) {
                return CResponse.error("Ce nom d'utilisateur existe deja");
            }
            User oldUser = userRepository.findUserById(user.getId());
            if (oldUser == null) {
                return CResponse.error("Cet utilisateur n'existe pas");
            }
            if (!StringUtils.isEmpty(user.getPassword())) {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
            } else {
                user.setPassword(oldUser.getPassword());
            }
            userRepository.save(user);
            return CResponse.success(user, "Utilisateur modifie avec succes!");

        } catch (Exception e) {
            e.printStackTrace();
            return CResponse.error("Une erreur est servenue!");
        }
    }

    public CResponse<User> getUser(Long id) {
        try {
            return CResponse.success(userRepository.findUserById(id), "Recuperer avec succes");
        } catch (Exception e) {
            e.printStackTrace();
            return CResponse.error("Ce nom existe deja!");
        }
    }

    public void deleteAll(List<User> users) {
        userRepository.deleteAll(users);
    }


}

