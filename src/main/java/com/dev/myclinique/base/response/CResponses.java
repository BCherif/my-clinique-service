package com.dev.myclinique.base.response;

public class CResponses {
    public static <T> CResponse<T> notFound() {
        return CResponse.error("Cette entité n'existe pas");
    }
}
