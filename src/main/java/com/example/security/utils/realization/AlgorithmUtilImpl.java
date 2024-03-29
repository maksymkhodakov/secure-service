package com.example.security.utils.realization;

import com.auth0.jwt.algorithms.Algorithm;
import com.example.security.utils.contracts.AlgorithmUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service("defaultAlgorithmService")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AlgorithmUtilImpl implements AlgorithmUtil {

    private static final String SECRET_VALUE = "secret";

    public Algorithm getAlgorithm() {
        return Algorithm.HMAC256(SECRET_VALUE.getBytes());
    }
}
