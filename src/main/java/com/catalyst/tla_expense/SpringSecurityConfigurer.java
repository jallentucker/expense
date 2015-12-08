package com.catalyst.tla_expense;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SpringSecurityConfigurer extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource datasource;
	
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		.dataSource(datasource)
		.usersByUsernameQuery("SELECT user_email, user_password, TRUE FROM expense_user WHERE user_email=?")
		.authoritiesByUsernameQuery("SELECT user_email, 'USER' FROM expense_user WHERE user_email=?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		super.configure(http);
		
		http.authorizeRequests()
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .loginPage("/login")
        .permitAll()
        .and()
        .logout()                                    
        .permitAll();;
		
		http.csrf().disable();
	}
	
	@Bean
	public BCryptPasswordEncoder encoder(){
		return new BCryptPasswordEncoder();
	}
	
	public void setDatasource(DataSource datasource){
		this.datasource = datasource;
	}
}
