package com.dim.security.jwt;

import com.dim.entity.role.Role;
import io.smallrye.jwt.build.Jwt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class JwtUtil {
    public static String generateToken(String username, List<Role> roles, long expireSeconds){
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", username);
        claims.put("rols", roles);

        long iat = System.currentTimeMillis() / 1000L;
        long exp = iat + expireSeconds;
        return Jwt.claims(claims)
                .issuedAt(iat)
                .expiresAt(exp)
                .sign();
    }
}
