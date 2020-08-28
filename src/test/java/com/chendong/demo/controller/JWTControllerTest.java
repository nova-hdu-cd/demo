package com.chendong.demo.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

/**
 * Json Web Token
 *
 * @author chendong
 * @date 2020/8/21 10:01 上午
 * To change this template use Appearance | Editor | File and Code
 * Templates.
 */
public class JWTControllerTest {

    public static String create() {
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            String token = JWT.create().
                    withIssuer("chendong").
                    withSubject("subject").
                    withClaim("name", "chendong").
                    sign(algorithm);
            System.out.println(token);
            return token;
        } catch (JWTCreationException exception) {
            throw exception;
        }
    }

    public static boolean verify(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier verifier = JWT.require(algorithm).withIssuer("chendong").build();
            DecodedJWT jwt = verifier.verify(token);
            String payload = jwt.getPayload();
            String name = jwt.getClaim("name").asString();
            System.out.println(payload);
            System.out.println(name);
        } catch (JWTVerificationException e) {
            return false;
        }
        return true;

    }

    public static void main(String[] args) {
        String token = create();
        System.out.println(verify(token));

    }
}
