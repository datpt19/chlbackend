// unicorns/backend/dto/LoginResponse.java
package unicorns.backend.dto.response;

public class LoginResponse {
    private String token;

    public LoginResponse(String token) {
        this.token = token;
    }

    // getter
    public String getToken() {
        return token;
    }
}
