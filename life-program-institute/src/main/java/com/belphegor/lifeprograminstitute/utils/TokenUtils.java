package com.belphegor.lifeprograminstitute.utils;


import com.belphegor.lifeprograminstitute.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class TokenUtils {
    public static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "crt";

    private static String secret;

    private static Long expiration;

    /**
     * 获取usercode
     * @param token
     * @return
     */
    public static String getUsercodeFromToken(String token){
        String usercode;
        try {
            final Claims claims = getClaimsFromToken(token);
            usercode = claims.getSubject();
        }catch (Exception e){
            usercode = e.toString();
        }
        return usercode;
    }

    /**
     * 获取创建时间
     * @param token
     * @return
     */
    public static Date getCreatedDateFromToken(String token){
        Date created;
        try {
            final Claims claims = getClaimsFromToken(token);
            created = Objects.equals(null,claims)? null:new Date(((Long)claims.get(CLAIM_KEY_CREATED)));
        }catch (Exception e){
            created = null;
        }
        return created;
    }

    public static Date getExpirationDateFromToken(String token){
        Date expiration;
        try {
            final Claims claims = getClaimsFromToken(token);
            expiration = claims.getExpiration();
        }catch (Exception e){
            expiration = null;
        }
        return expiration;
    }

    private static Claims getClaimsFromToken(String token){
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
            claims = null;
        }
        return claims;
    }

    private static Date generateExpirationDate(){
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    private static Boolean isTokenExpired(String token){
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    private static Boolean isCreatedBeforeLastPasswordReset(Date created,Date lastPasswordReset){
        return (lastPasswordReset != null && created.before(lastPasswordReset));
    }

    public static String generateToken(String usercode){
        Map<String,Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_CREATED,new Date());
        claims.put(CLAIM_KEY_USERNAME,usercode);
        return generateToken(claims);
    }

    public static String generateToken(Map<String,Object> claims){
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }

    public static Boolean canTokenBeRefreshed(String token,Date lastPasswordReset){
        final Date created = getCreatedDateFromToken(token);
        return !isCreatedBeforeLastPasswordReset(created,lastPasswordReset)
                && !isTokenExpired(token);
    }

    public static String refreshToken(String token){
        String refreshedToken;
        try {
            final Claims claims = getClaimsFromToken(token);
            claims.put(CLAIM_KEY_CREATED,new Date());
            refreshedToken = generateToken(claims);
        }catch (Exception e){
            refreshedToken = null;
        }
        return refreshedToken;
    }

    public static Boolean validateToken(String token, User user){
        final String usercode = getUsercodeFromToken(token);
        return (usercode.equals(user.getUserName())) && !isTokenExpired(token);
    }



    @Value("${jwt.secret}")
    public void setSecret(String secret){
        TokenUtils.secret = secret;
    }

    @Value("${jwt.expiration}")
    public void setExpiration(Long expiration){
        TokenUtils.expiration = expiration;
    }
}
