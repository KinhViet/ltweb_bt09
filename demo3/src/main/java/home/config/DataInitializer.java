package home.config;

import home.entity.Role;
import home.entity.Users;
import home.repository.RoleRepository;
import home.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

@Configuration
public class DataInitializer {
    
    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, 
                                   RoleRepository roleRepository,
                                   PasswordEncoder passwordEncoder) {
        return args -> {
            // Tạo các Role nếu chưa có
            if (roleRepository.findByName("ADMIN").isEmpty()) {
                Role adminRole = new Role();
                adminRole.setName("ADMIN");
                roleRepository.save(adminRole);
            }
            
            if (roleRepository.findByName("USER").isEmpty()) {
                Role userRole = new Role();
                userRole.setName("USER");
                roleRepository.save(userRole);
            }
            
            if (roleRepository.findByName("EDITOR").isEmpty()) {
                Role editorRole = new Role();
                editorRole.setName("EDITOR");
                roleRepository.save(editorRole);
            }
            
            if (roleRepository.findByName("CREATOR").isEmpty()) {
                Role creatorRole = new Role();
                creatorRole.setName("CREATOR");
                roleRepository.save(creatorRole);
            }
            
            // Tạo user Admin mẫu nếu chưa có
            if (!userRepository.existsByUsername("admin")) {
                Users admin = new Users();
                admin.setName("Administrator");
                admin.setUsername("admin");
                admin.setEmail("admin@demo3.com");
                admin.setPassword(passwordEncoder.encode("123456"));
                admin.setEnabled(true);
                
                Role adminRole = roleRepository.findByName("ADMIN")
                        .orElseThrow(() -> new RuntimeException("Role ADMIN not found"));
                admin.setRoles(Collections.singleton(adminRole));
                
                userRepository.save(admin);
                System.out.println("Admin user created - Username: admin, Password: 123456");
            }
            
            // Tạo user Editor mẫu
            if (!userRepository.existsByUsername("editor")) {
                Users editor = new Users();
                editor.setName("Editor User");
                editor.setUsername("editor");
                editor.setEmail("editor@demo3.com");
                editor.setPassword(passwordEncoder.encode("123456"));
                editor.setEnabled(true);
                
                Role editorRole = roleRepository.findByName("EDITOR")
                        .orElseThrow(() -> new RuntimeException("Role EDITOR not found"));
                editor.setRoles(Collections.singleton(editorRole));
                
                userRepository.save(editor);
                System.out.println("Editor user created - Username: editor, Password: 123456");
            }
            
            // Tạo user Creator mẫu
            if (!userRepository.existsByUsername("creator")) {
                Users creator = new Users();
                creator.setName("Creator User");
                creator.setUsername("creator");
                creator.setEmail("creator@demo3.com");
                creator.setPassword(passwordEncoder.encode("123456"));
                creator.setEnabled(true);
                
                Role creatorRole = roleRepository.findByName("CREATOR")
                        .orElseThrow(() -> new RuntimeException("Role CREATOR not found"));
                creator.setRoles(Collections.singleton(creatorRole));
                
                userRepository.save(creator);
                System.out.println("Creator user created - Username: creator, Password: 123456");
            }
            
            // Tạo user thường mẫu
            if (!userRepository.existsByUsername("user1")) {
                Users user = new Users();
                user.setName("Regular User");
                user.setUsername("user1");
                user.setEmail("user1@demo3.com");
                user.setPassword(passwordEncoder.encode("123456"));
                user.setEnabled(true);
                
                Role userRole = roleRepository.findByName("USER")
                        .orElseThrow(() -> new RuntimeException("Role USER not found"));
                user.setRoles(Collections.singleton(userRole));
                
                userRepository.save(user);
                System.out.println("Regular user created - Username: user1, Password: 123456");
            }
        };
    }
}