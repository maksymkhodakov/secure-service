package com.example.security.utils.contracts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface RefreshTokenUtil {
    void refresh(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
