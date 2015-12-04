package com.catalyst.tla_expense;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	//Once the database is active, 
	//this will need to be configured. 
	/*@Autowired
	private DataSource datasource;
	
    public void setDatasource(DataSource datasource){
		this.datasource = datasource;
	}*/
	
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
        .withUser("user")
        .password("password")
        .authorities("USER");
    }

    @Override
	public void configure(HttpSecurity http) throws Exception {
		super.configure(http);
		http.csrf().disable();
	}
    
    @Bean
	public BCryptPasswordEncoder encode(){
		return new BCryptPasswordEncoder();
	}
}