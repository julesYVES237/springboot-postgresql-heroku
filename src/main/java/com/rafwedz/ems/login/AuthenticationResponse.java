package com.rafwedz.ems.login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private Long id;
    //private String authToken;
    private String firstName;
    private String LastName;
    private String role;
}
