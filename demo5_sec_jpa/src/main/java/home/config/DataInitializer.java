package home.config;

import home.entity.Role;
import home.entity.Users;
import home.repository.RoleRepository;
import home.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class DataInitializer {
    
    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, 
                                   RoleRepository roleRepository,
                                   PasswordEncoder passwordEncoder) {
        return args -> {
            // Tạo các Role
            createRoleIfNotExists(roleRepository, "ADMIN");
            createRoleIfNotExists(roleRepository, "USER");
            createRoleIfNotExists(roleRepository, "EDITOR");
            createRoleIfNotExists(roleRepository, "CREATOR");
            
            // Tạo user Admin
            if (!userRepository.existsByUsername("admin")) {
                Users admin = new Users();
                admin.setName("Administrator");
                admin.setUsername("admin");
                admin.setEmail("admin@demo5.com");
                admin.setPassword(passwordEncoder.encode("123456"));
                admin.setEnabled(true);
                
                Role adminRole = roleRepository.findByName("ADMIN")
                        .orElseThrow(() -> new RuntimeException("Role ADMIN not found"));
                Set<Role> roles = new HashSet<>();
                roles.add(adminRole);
                admin.setRoles(roles);
                
                userRepository.save(admin);
                System.out.println("Admin created - Username: admin, Password: 123456");
            }
            
            // Tạo user Editor
            if (!userRepository.existsByUsername("editor")) {
                Users editor = new Users();
                editor.setName("Editor User");
                editor.setUsername("editor");
                editor.setEmail("editor@demo5.com");
                editor.setPassword(passwordEncoder.encode("123456"));
                editor.setEnabled(true);
                
                Role editorRole = roleRepository.findByName("EDITOR")
                        .orElseThrow(() -> new RuntimeException("Role EDITOR not found"));
                Set<Role> roles = new HashSet<>();
                roles.add(editorRole);
                editor.setRoles(roles);
                
                userRepository.save(editor);
                System.out.println("Editor created - Username: editor, Password: 123456");
            }
            
            // Tạo user Creator
            if (!userRepository.existsByUsername("creator")) {
                Users creator = new Users();
                creator.setName("Creator User");
                creator.setUsername("creator");
                creator.setEmail("creator@demo5.com");
                creator.setPassword(passwordEncoder.encode("123456"));
                creator.setEnabled(true);
                
                Role creatorRole = roleRepository.findByName("CREATOR")
                        .orElseThrow(() -> new RuntimeException("Role CREATOR not found"));
                Set<Role> roles = new HashSet<>();
                roles.add(creatorRole);
                creator.setRoles(roles);
                
                userRepository.save(creator);
                System.out.println("Creator created - Username: creator, Password: 123456");
            }
            
            // Tạo user thường
            if (!userRepository.existsByUsername("user1")) {
                Users user = new Users();
                user.setName("Regular User");
                user.setUsername("user1");
                user.setEmail("user1@demo5.com");
                user.setPassword(passwordEncoder.encode("123456"));
                user.setEnabled(true);
                
                Role userRole = roleRepository.findByName("USER")
                        .orElseThrow(() -> new RuntimeException("Role USER not found"));
                Set<Role> roles = new HashSet<>();
                roles.add(userRole);
                user.setRoles(roles);
                
                userRepository.save(user);
                System.out.println("User created - Username: user1, Password: 123456");
            }
        };
    }
    
    private void createRoleIfNotExists(RoleRepository roleRepository, String roleName) {
        if (roleRepository.findByName(roleName).isEmpty()) {
            Role role = new Role();
            role.setName(roleName);
            roleRepository.save(role);
        }
    }
}