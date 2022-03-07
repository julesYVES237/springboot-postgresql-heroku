package com.rafwedz.ems.login;

import com.rafwedz.ems.employee.EmployeeRepository;
import com.rafwedz.ems.services.CustomUserDetailsService;
//import com.rafwedz.ems.jwt.JwtUtil;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@AllArgsConstructor
@Transactional
public class AuthService {
    private final EmployeeRepository employeeRepository;
    private final CustomUserDetailsService customUserDetailsService;
    private final AuthenticationManager authenticationManager;
   // private final JwtUtil jwtutil;

    public ResponseEntity<?> login(LoginRequest loginRequest) throws Exception {

        try {
            Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                    loginRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = customUserDetailsService
                .loadUserByUsername(loginRequest.getUsername());

     //   final String jwt = jwtutil.generateToken(userDetails);

        String loggedUserName = loginRequest.getUsername();

        return ResponseEntity.ok(new AuthenticationResponse(
                employeeRepository.findIdByUsername(loggedUserName),
         //       jwt,
                employeeRepository.findFirstNameByUsername(loggedUserName),
                employeeRepository.findLastNameByUsername(loggedUserName),
                employeeRepository.findRoleByUsername(loggedUserName)));
    }
}
