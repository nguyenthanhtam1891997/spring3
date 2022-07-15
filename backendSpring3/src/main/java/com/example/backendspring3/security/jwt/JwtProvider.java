package com.example.backendspring3.security.jwt;

import com.example.backendspring3.security.userPrinciple.UserPrinciple;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;

@Component
public class JwtProvider {
    private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    private String jwtKey = "tamnguyen@codegym.vn";
    private int jwtExpiration = 86400;


    public String createToken(Authentication authentication) {
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        return Jwts.builder().setSubject(userPrinciple.getUser().getEmail()).
                setIssuedAt(new Date()).
                setExpiration(new Date(new Date().getTime() + jwtExpiration * 1000)).
                signWith(SignatureAlgorithm.HS512, jwtKey)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtKey).parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            logger.error("token khoong hop le");
        } catch (UnsupportedJwtException e) {
            logger.error("token khoong ho tro");
        } catch (MalformedJwtException e) {
            logger.error("token khong dung dainh dang");
        } catch (ExpiredJwtException e) {
            logger.error("thoi gia song khong hop le");
        } catch (IllegalArgumentException e) {
            logger.error("token co khoan trang");
        }
        return false;
    }

    public String getEmailFromToken(String token) {
        String email = Jwts.parser().setSigningKey(jwtKey).parseClaimsJws(token).getBody().getSubject();
        System.out.println(email);
        return email;

    }


}
