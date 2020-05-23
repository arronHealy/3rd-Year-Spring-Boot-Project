package com.sales.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{ 
  @Override
  public void configure(HttpSecurity httpSecurity) throws Exception{
    //configure security
	  httpSecurity.authorizeRequests()
     .antMatchers("/", "/showBooks", "/addBook", "/showCustomers", "/addCustomer", "/showLoans", "/newLoan", "/deleteLoan")
     .hasRole("USER")
     .and()
     .formLogin();
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	  //set username and password
	  auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
  }
  
}

