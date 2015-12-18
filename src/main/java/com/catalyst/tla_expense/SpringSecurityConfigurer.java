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


/**
 * @author Jmiller
 * This is base Spring Security class. All security configuration goes here
 */

@EnableWebSecurity
@Configuration
public class SpringSecurityConfigurer extends WebSecurityConfigurerAdapter{

	/**
	 * Autowiring the database element
	 * of Spring Security
	 * 
	 */
	
	@Autowired
	private DataSource datasource;
	
	
	/**
	 * The query to get the user name and password from
	 * the front end and compare it to the database
	 */
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		.dataSource(datasource)
		.passwordEncoder(encoder())
		.usersByUsernameQuery("SELECT user_email, user_password, TRUE FROM expense_user WHERE user_email=?")
		.authoritiesByUsernameQuery("SELECT user_email, 'USER' FROM expense_user WHERE user_email=?");
	}
	
	/**
	 * The main configuration method for Spring Security.
	 * 
	 * The antMatchers function takes end points
	 * and file locations relative to public, and
	 * removes security from them. 
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		http
		.authorizeRequests()
        	.antMatchers("/user/post", "/css/**", "/js/app.js", "/js/controllers/registerController.js", 
        			"/js/values/regexValues.js", "/js/factories/usersFactory.js", "/js/factories/validationFactory.js", "/register**")
        		.permitAll()//are allowed to be visited by anyone. 
        		.anyRequest()
        		.authenticated()
            	.and()
        .formLogin()
            .loginPage("/login")//this specifies the custom login page end point
            	.permitAll()
            .and()
        .logout()                                    
        	.permitAll()//this allows anywone that is logged in to be logged out. 
        .and()
        .csrf()
        .disable();
	}
	
	/**
	 * Configures a bean for password encryption
	 */
	@Bean
	public BCryptPasswordEncoder encoder(){
		return new BCryptPasswordEncoder();
	}
	
	/**
	 * Used by autowire to allow 
	 * spring security to query the database
	 * @param datasource
	 */
	public void setDatasource(DataSource datasource){
		this.datasource = datasource;
	}
}
