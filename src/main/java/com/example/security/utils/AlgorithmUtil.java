package com.example.security.utils;

import com.auth0.jwt.algorithms.Algorithm;

public class AlgorithmUtil {

    public static final String SECRET_VALUE = "secret";

    public static Algorithm getAlgorithm() {
        return Algorithm.HMAC256(SECRET_VALUE.getBytes());
    }
}
