package com.dev.myclinique.auth.security;

public class SecurityConstants {
    public static final String AUTH_LOGIN_URL = "/auth/login";
    public static final String AUTH_LOGOUT_URL = "/auth/logout";
    public static final String FORGET_PWD_LOGOUT_URL = "/auth/forget_pwd";
    public static final String CHECK_EMAIL_URL = "/check-email/**";
    public static final String SIGNUP_URL = "/users/**";
    public static final String ACCESS_DENIED = "/acces-denied";

    // Signing key for HS512 algorithm
    // You can use the page https://mkjwk.org/ to generate all kinds of keys
    public static final String JWT_SECRET = "KLQBCS%LBKLKQSBLCLSQB";

    // JWT token defaults
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String TOKEN_TYPE = "JWT";
    public static final String TOKEN_ISSUER = "secure-api";
    public static final String TOKEN_AUDIENCE = "secure-app";

    private SecurityConstants() {
        throw new IllegalStateException("Cannot create instance of static util class");
    }
}
