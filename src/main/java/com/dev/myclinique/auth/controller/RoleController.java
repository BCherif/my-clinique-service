package com.dev.myclinique.auth.controller;

import com.dev.myclinique.auth.entity.Role;
import com.dev.myclinique.auth.service.RoleService;
import com.dev.myclinique.base.response.CResponse;
import com.dev.myclinique.base.response.PageData;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
@AllArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(roleService.getAll());
    }

    @GetMapping("/page")
    public CResponse<PageData<Role>> findAll(Pageable pageable) {
        return CResponse.success(PageData.fromPage(roleService.findAll(pageable)));
    }

    @GetMapping("/by-name/{name}")
    public ResponseEntity<?> getByName(@PathVariable String name) {
        return ResponseEntity.ok(roleService.getByName(name));
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody Role role) {
        return ResponseEntity.ok(roleService.save(role));
    }

}
