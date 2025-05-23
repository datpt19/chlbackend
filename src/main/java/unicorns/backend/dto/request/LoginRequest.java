package unicorns.backend.dto.request;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginRequest {
    private String username;
    private String password;
}
