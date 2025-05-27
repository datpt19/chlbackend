package unicorns.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import unicorns.backend.dto.request.BaseRequest;
import unicorns.backend.dto.request.CreateUserRequest;
import unicorns.backend.dto.response.BaseResponse;
import unicorns.backend.dto.response.CreateUserResponse;
import unicorns.backend.security.UserDetailsImpl;
import unicorns.backend.service.UserService;
import unicorns.backend.util.Const;
import unicorns.backend.dto.response.CurrentUserResponse;
import unicorns.backend.entity.User;



@RestController
@RequestMapping(Const.PREFIX_USER_V1)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserController {

    UserService userService;

    @Operation(summary = "get all user", description = "Get all user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User list fetched successfully")
    })
    @GetMapping(value = "getAll")
    public BaseResponse<CreateUserResponse> getAllUsers() {
        return userService.getAllUser();
    }

    @Operation(summary = "Create new user", description = "Creates a new user using the provided information.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input",
                    content = @Content(schema = @Schema(implementation = BaseResponse.class)))
    })
    @PostMapping(value = "createUser")
    public BaseResponse<CreateUserResponse> createUser(@Valid @RequestBody BaseRequest<CreateUserRequest> request) {
        return userService.createUser(request);
    }


    @Operation(summary = "Get current user info", description = "Get info of user from JWT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fetched current user info")
    })

//    @GetMapping("me")
//    public BaseResponse<?> getCurrentUser(@AuthenticationPrincipal UserDetailsImpl userDetails) {
//        return BaseResponse.success(userDetails.getUser());
//    }

    @GetMapping("me")
    public BaseResponse<CurrentUserResponse> getCurrentUser(
            @AuthenticationPrincipal UserDetailsImpl userDetails) {

        // 1. Lấy entity User từ UserDetailsImpl
        User user = userDetails.getUser();

        // 2. Map sang DTO
        CurrentUserResponse dto = new CurrentUserResponse(
                user.getUsername(),
                user.getEmail(),
                user.getName(),
                user.getDateOfBirth()
        );

        // 3. Trả về success kèm payload là DTO
        return BaseResponse.success(dto);
    }
}