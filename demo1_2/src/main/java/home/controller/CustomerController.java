package home.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    
    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Customer> getCustomerList() {
        return Arrays.asList(
                new Customer(1, "Nguyễn Văn A", "nguyenvana@gmail.com"),
                new Customer(2, "Trần Thị B", "tranthib@gmail.com"),
                new Customer(3, "Lê Văn C", "levanc@gmail.com")
        );
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Customer {
    private int id;
    private String name;
    private String email;
}