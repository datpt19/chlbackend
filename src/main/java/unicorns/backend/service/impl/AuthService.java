package unicorns.backend.service.impl;

import unicorns.backend.dto.request.LoginRequest;
import unicorns.backend.dto.response.LoginResponse;
import unicorns.backend.util.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthService(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public LoginResponse login(LoginRequest request) {
        try {
            var authToken = new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
            authenticationManager.authenticate(authToken);

            String token = jwtService.generateToken(request.getUsername());
            return new LoginResponse(token);

        } catch (AuthenticationException e) {
            throw new RuntimeException("Xác thực không thành công!");
        }
    }
}
