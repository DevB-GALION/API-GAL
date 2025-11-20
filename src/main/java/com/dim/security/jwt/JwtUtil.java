package com.dim.security.jwt;

import com.dim.entity.role.Role;
import io.smallrye.jwt.build.Jwt;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class JwtUtil {
    public static String generateToken(String username, List<Role> roles, long expireSeconds) {
        long currentTimeInSecs = System.currentTimeMillis() / 1000L;
        long expirationTime = currentTimeInSecs + expireSeconds;

        Set<String> groups = roles.stream()
                .map(r -> r.name.name())
                .collect(Collectors.toSet());

        return Jwt.issuer("galion-app")
                .upn(username)
                .groups(groups)
                .expiresAt(expirationTime)
                .issuedAt(currentTimeInSecs)
                .sign();
    }
}
