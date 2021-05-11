package com.chendong.demo.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Json Web Token Utils
 *
 * @author chendong
 * @date 2020/8/21 10:01 上午
 * To change this template use Appearance | Editor | File and Code
 * Templates.
 */
public final class JwtTokenUtils {

    private static final Logger log = LoggerFactory.getLogger(JwtTokenUtils.class);

    private static final String SECRET_KEY = "secret-keyword-test";

    private static final String ISSUER = "chendong";

    private static final String SUBJECT = "subject";

    /**
     * 生成token
     *
     * @param name  声明值name
     * @param value 声明值value
     * @return
     */
    public static String create(String name, String value) {
        String token;
        try {
            token = JWT.create()
                    //签发者
                    .withIssuer(ISSUER)
                    //所面向的用户
                    .withSubject(SUBJECT)
                    //jwt加密的声明值
                    .withClaim(name, value)
                    //密钥和所使用的算法
                    .sign(Algorithm.HMAC256(SECRET_KEY));
            log.info("JWT Token:{}", token);
        } catch (JWTCreationException exception) {
            throw exception;
        }
        return token;
    }

    /**
     * 验证token
     *
     * @param token 令牌
     * @param name  声明值name
     * @return
     */
    public static boolean verify(String token, String name) {
        try {
            //密钥和所需要的算法、签发者
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET_KEY)).withIssuer(ISSUER).build();
            DecodedJWT decodedJWT = verifier.verify(token);
            String payload = decodedJWT.getPayload();
            String value = decodedJWT.getClaim(name).asString();
            log.info("JWT Token payload:{}", payload);
            log.info("JWT Token value:{}", value);
        } catch (JWTVerificationException e) {
            return false;
        }
        return true;

    }

    public static void main(String[] args) {
        String token = create("name", "chendong");
        log.info("验证结果:{}", verify(token, "name"));

    }
}
