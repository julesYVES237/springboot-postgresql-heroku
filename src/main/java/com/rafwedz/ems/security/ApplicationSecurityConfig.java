/**
 * package that contains config utils
 */
package com.rafwedz.ems.security;

import com.rafwedz.ems.services.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
//@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomUserDetailsService customUserDetailsService;

    public ApplicationSecurityConfig(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    /* private JwtRequestFilter jwtRequestFilter;

     public ApplicationSecurityConfig(final CustomUserDetailsService
                                              cUserDetailService,
                                      final JwtRequestFilter jRequestFilter) {
         this.customUserDetailsService = cUserDetailService;
         this.jwtRequestFilter = jRequestFilter;

     }
 */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

   @Override
    protected final void configure(final HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/employees","/employees/{id}","/auth/login","/tasks","/tasks/count","/tasks/tasksdto",
                        "/tasks/unassigned","/tasks/unassigned/count","/tasks/assigned/count","/tasks/done",
                        "/tasks/new","/tasks/assigned","/task/assigned","/tasks/{task_id}","/tasks/nn/{employee_id}","/employees/{emp_id}/tasks","/employees/count","/employees/wages","/employees/{emp_id}/tasks/all","/employees/{emp_id}/tasks/done","/employees/{emp_id}/tasks/new").permitAll()
                .anyRequest().authenticated();


    }

    @Override
    protected final void configure(
            final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService);

    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String p = bCryptPasswordEncoder.encode("SomeCoolPassword");
        System.out.println(bCryptPasswordEncoder.matches("SomeCoolPassword", p));
        return new BCryptPasswordEncoder();

    }
}
