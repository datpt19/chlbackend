package unicorns.backend.service;

import unicorns.backend.dto.request.LoginRequest;
import unicorns.backend.dto.response.LoginResponse;
import unicorns.backend.util.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil JwtUtil;

    public AuthService(AuthenticationManager authenticationManager, JwtUtil JwtUtil) {
        this.authenticationManager = authenticationManager;
        this.JwtUtil = JwtUtil;
    }

    public LoginResponse login(LoginRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );

            String token = JwtUtil.generateToken(request.getUsername());
            return new LoginResponse(token);

        } catch (AuthenticationException e) {
            throw new RuntimeException("Xác thực không thành công!");
        }
    }
}
