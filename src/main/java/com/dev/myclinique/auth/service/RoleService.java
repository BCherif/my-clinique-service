package com.dev.myclinique.auth.service;

import com.dev.myclinique.auth.entity.Role;
import com.dev.myclinique.auth.repository.RoleRepository;
import com.dev.myclinique.base.response.CResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.dev.myclinique.utils.Utils.getDefaultPageable;


@Service
@AllArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public CResponse<List<Role>> getAll() {
        try {
            return CResponse.success(roleRepository.findAll(), "Liste de rôle!");
        } catch (Exception e) {
            e.printStackTrace();
            return CResponse.error("Une erreur est survenue");
        }
    }

    public Page<Role> findAll(Pageable pageable) {
        return roleRepository.findAll(getDefaultPageable(pageable));
    }

    public CResponse<Role> getByName(String name) {
        try {
            return CResponse.success(roleRepository.findByName(name), "Rôle");
        } catch (Exception e) {
            e.printStackTrace();
            return CResponse.error("Une erreur est survenue");
        }
    }

    public CResponse<Role> save(Role role) {
        try {
            if (roleRepository.existsByName(role.getName())) {
                return CResponse.error("Ce rôle existe déjà!");
            }
            return CResponse.success(roleRepository.save(role), "Rôle modifie avec succes!");
        } catch (Exception e) {
            e.printStackTrace();
            return CResponse.error("Une erreur est survenue!");
        }
    }
}
