package com.koreait.jwt_24_10.base.jwt;

import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Base64;

@Component
public class JwtProvider {
    private SecretKey cachedSecretKey;

    @Value("${custom.jwt.secretKey")
    private String secretKeyPlain; // JWT를 쓴다는거 자체가 secretKey가 있어야 한다는 소리.

    private SecretKey _getSecretKey() {
        String keyBase64Encoded = Base64.getEncoder().encodeToString(secretKeyPlain.getBytes());
        return Keys.hmacShaKeyFor(keyBase64Encoded.getBytes());
    }

    public SecretKey getSecretKey() {
        if (cachedSecretKey == null) {
            cachedSecretKey = _getSecretKey();
        }

        return cachedSecretKey;
    }
}
