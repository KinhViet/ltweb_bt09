package home.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
// Đọc tất cả thuộc tính bắt đầu bằng tiền tố 'jwt'
@ConfigurationProperties(prefix = "jwt")
@Data
public class JwtProperties {
    
    // Tên trường sẽ tự động khớp với jwt.secret-key hoặc jwt.secretKey
    private String secretKey; 
    
    // Tên trường sẽ tự động khớp với jwt.expiration-ms
    private long expirationMs; 
}