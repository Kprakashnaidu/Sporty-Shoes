package com.sportyshoes.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

import static com.sportyshoes.model.UserPermission.*;

@AllArgsConstructor
@Getter
public enum UserRole {

    ROLE_USER(Arrays.asList(READ)),
    ROLE_ADMIN(Arrays.asList(READ, WRITE, UPDATE, DELETE));

    private final List<UserPermission> permissions;
}
