package com.belphegor.common.utils;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TokenUtils {
    public static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "crt";

    private static String secret;

    private static Long expiration;

    public static String generateToken(Ma)

    https://www.lefer.cn/posts/55880/

    @Value("${jwt.secret}")
    public void setSecret(String secret){
        TokenUtils.secret = secret;
    }

    @Value("${jwt.expiration}")
    public void setExpiration(Long expiration){
        TokenUtils.expiration = expiration;
    }
}
