package com.rafwedz.ems.login;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;
    @CrossOrigin("http://localhost:4200/")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) throws Exception  {
        return authService.login(loginRequest);
    }

}
