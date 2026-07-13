package com.cognizant.springlearn.controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

// File 5: Create authentication controller and configure it in SecurityConfig
@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("START");
        LOGGER.debug(authHeader);

        String user = getUser(authHeader);
        String token = generateJwt(user);

        Map<String, String> map = new HashMap<>();
        map.put("token", token);

        LOGGER.info("END");
        return map;
    }

    // File 5: Read Authorization header and decode the username and password
    private String getUser(String authHeader) {
        LOGGER.info("START");
        String encodedCredentials = authHeader.replace("Basic ", "");
        String decodedCredentials = new String(Base64.getDecoder().decode(encodedCredentials));
        String user = decodedCredentials.substring(0, decodedCredentials.indexOf(":"));
        LOGGER.debug(user);
        LOGGER.info("END");
        return user;
    }

    // File 5: Generate token based on the user
    private String generateJwt(String user) {
        LOGGER.info("START");
        JwtBuilder builder = Jwts.builder();
        builder.setSubject(user);
        builder.setIssuedAt(new Date());
        builder.setExpiration(new Date((new Date()).getTime() + 1200000));
        builder.signWith(SignatureAlgorithm.HS256, "secretkey");
        String token = builder.compact();
        LOGGER.info("END");
        return token;
    }
}