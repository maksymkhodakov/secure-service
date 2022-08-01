package com.example.security.security.realization;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.security.DTO.UserDto;
import com.example.security.domain.Role;
import com.example.security.exceptions.RefreshTokenException;
import com.example.security.security.contracts.RefreshTokenUtil;
import com.example.security.service.interfaces.UserService;
import com.example.security.utils.AlgorithmUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Service("userDefaultImpl")
@RequiredArgsConstructor
public class RefreshTokenUtilImpl implements RefreshTokenUtil {
    public static final int TEN_MINUTES_REFRESH_TIME = 10 * 60 * 1000;
    public static final String AUTH_SUBSTR = "Bearer ";
    public static final String HEADER_NAME = "error";
    public static final String ERROR_MESSAGE = "error_message";
    public static final String REFRESH_TOKEN_IS_MISSING = "Refresh token is missing";
    private final UserService userService;

    @Override
    public void refresh(HttpServletRequest request,
                        HttpServletResponse response) throws IOException {
        var authorizationHeader = request.getHeader(AUTHORIZATION);
        if (!(authorizationHeader != null && authorizationHeader.startsWith(AUTH_SUBSTR))) {
            throw new RefreshTokenException(REFRESH_TOKEN_IS_MISSING);
        }
        else {
            try {
                var refreshToken = authorizationHeader.substring(AUTH_SUBSTR.length());
                var algorithm = AlgorithmUtil.getAlgorithm();
                var verifier = JWT.require(algorithm).build();
                var decodeJWT = verifier.verify(refreshToken);
                var username = decodeJWT.getSubject();
                var user = userService.getUserByUsername(username);
                String accessToken = generateAccessToken(request, algorithm, user);
                HashMap<Object, Object> tokens = getTokensMap(response, refreshToken, accessToken);
                writeValues(response, tokens);
            } catch (Exception exception) {
                configureResponse(response, exception);
                HashMap<Object, Object> error = configureErrorMap(ERROR_MESSAGE, exception.getMessage());
                writeValues(response, error);
            }
        }
    }

    private static HashMap<Object, Object> configureErrorMap(String errorMessage, String exception) {
        var error = new HashMap<>();
        error.put(errorMessage, exception);
        return error;
    }

    private static void configureResponse(HttpServletResponse response, Exception exception) {
        response.setHeader(HEADER_NAME, exception.getMessage());
        response.setStatus(FORBIDDEN.value());
        response.setContentType(APPLICATION_JSON_VALUE);
    }

    private static void writeValues(HttpServletResponse response, HashMap<Object, Object> tokens) throws IOException {
        new ObjectMapper().writeValue(response.getOutputStream(), tokens);
    }

    private static HashMap<Object, Object> getTokensMap(HttpServletResponse response, String refreshToken, String accessToken) {
        HashMap<Object, Object> tokens = configureErrorMap("access_token", accessToken);
        tokens.put("refresh_token", refreshToken);
        response.setContentType(APPLICATION_JSON_VALUE);
        return tokens;
    }

    private static String generateAccessToken(HttpServletRequest request, Algorithm algorithm, UserDto user) {
        return JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date((System.currentTimeMillis() + TEN_MINUTES_REFRESH_TIME)))
                .withIssuer(request.getRequestURL().toString())
                .withClaim("roles", user.getRoles().stream().map(Role::getName).toList())
                .sign(algorithm);
    }
}
