package com.example.WenBadiSoff.security;

import com.example.WenBadiSoff.user.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtUtil {

    public static String generateToken(User user) {
        return Jwts
                .builder()
                .subject(String.valueOf(user.getId()))
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date((System.currentTimeMillis()) + 600_000))
                .signWith(getSigningKey())
                .compact();
    }

    public static Claims getClaims(String token) {
        return Jwts
                .parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public static boolean isTokenValid(String token) {
        return !isExpired(token);
    }

    public static boolean isExpired(String token) {
        return getClaims(token)
                .getExpiration()
                .before(new Date());
    }

    public static SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode("thisistheextrasuperverylongmessageforthewenbadisoffcarfinderwebapplicationmadebyhasan");
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
