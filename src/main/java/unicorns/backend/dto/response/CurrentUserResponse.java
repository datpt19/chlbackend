package unicorns.backend.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class CurrentUserResponse {
    String username;
    String email;
    String name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDateTime dateOfBirth;
}
