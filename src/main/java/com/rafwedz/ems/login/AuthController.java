package com.rafwedz.ems.login;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "https://spring-ems1.herokuapp.com/", allowedHeaders = "*")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;
    @CrossOrigin(origins = "https://spring-ems1.herokuapp.com/", allowedHeaders = "*")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) throws Exception  {
        return authService.login(loginRequest);
    }

    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/auth")
                .allowedOrigins("https://spring-ems1.herokuapp.com/")
                .allowedMethods("PUT", "DELETE","POST")
                .allowedHeaders("header1", "header2", "header3")
                .exposedHeaders("header1", "header2")
                .allowCredentials(false).maxAge(3600);
    }
}
