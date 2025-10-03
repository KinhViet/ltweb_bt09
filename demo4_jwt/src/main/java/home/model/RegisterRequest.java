package home.model;

import lombok.Data;

@Data // tạo getters, setters, toString, equals, hashCode
public class RegisterRequest {
    private String username;
    private String password;
    private String fullname;
    private String email;
}