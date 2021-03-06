package com.dev.myclinique.auth.wrapper;

import com.dev.myclinique.auth.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthBody implements Serializable {
    private Long userId;
    private String username;
    private String password;
    private String oldPassword;
    private String newPassword;
    private User user;
    private String token;

    public AuthBody(User user, String token) {
        this.user = user;
        this.token = token;
    }
}
