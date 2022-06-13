package com.dev.myclinique.auth.controller;

import com.dev.myclinique.auth.entity.User;
import com.dev.myclinique.auth.service.UserService;
import com.dev.myclinique.base.response.CResponse;
import com.dev.myclinique.base.response.PageData;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<?> listOfUsers() {
        return ResponseEntity.ok(userService.listOfUsers());
    }

    @GetMapping("/page")
    public CResponse<PageData<User>> findAll(Pageable pageable) {
        return CResponse.success(PageData.fromPage(userService.findAll(pageable)));
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody User user) {
        return ResponseEntity.ok(userService.create(user));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody User user) {
        return ResponseEntity.ok(userService.edit(user));
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

}
