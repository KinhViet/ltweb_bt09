package home.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor // auto generate Constructor with full parameters
public class LoginResponse {
    private String token;
    private String username;
    private String role;
}