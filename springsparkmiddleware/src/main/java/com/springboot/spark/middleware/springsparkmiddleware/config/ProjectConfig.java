package com.springboot.spark.middleware.springsparkmiddleware.config;

import javax.sql.DataSource;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
public class ProjectConfig {
  @Bean
  public UserDetailsService UserDetailsService(DataSource dataSource) {
    String userByUsernameQuery = "select username, password, enabled from spring.users where username= ?";
    String authsByUserQuery = "select username, authority from spring.authorities where username = ?";
    
    var userDetailsManager = new JdbcUserDetailsManager(dataSource);
    userDetailsManager.setUsersByUsernameQuery(userByUsernameQuery);
    userDetailsManager.setAuthoritiesByUsernameQuery(authsByUserQuery);
    return userDetailsManager;
  }

  @SuppressWarnings("deprecation")
  @Bean PasswordEncoder passwordEncoder() {
    return NoOpPasswordEncoder.getInstance();
  }
}
