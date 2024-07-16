package br.com.healthhelper.customer.app.config.security.jwt;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

@Component
public class JWTUtil {

    private static final String SECRET = "$B&E)H@McQfTjWnZr4u7x!z%C*F-JaNd";

    public static String getAllClaimsFromToken(final String token) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        return JWT.require(algorithm)
                .build()
                .verify(token)
                .getSubject();
    }
}
