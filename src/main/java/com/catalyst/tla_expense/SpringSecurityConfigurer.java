package com.catalyst.tla_expense;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
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
		//.passwordEncoder(encoder()) //Un-comment this one registration passwords get hashed. 
		.usersByUsernameQuery("SELECT user_email, user_password, TRUE FROM expense_user WHERE user_email=?")
		.authoritiesByUsernameQuery("SELECT user_email, 'USER' FROM expense_user WHERE user_email=?");
	}
	
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/css/**");
		web.ignoring().antMatchers("/js/**");
		web.ignoring().antMatchers("/controllers/**");
		web.ignoring().antMatchers("/factories/**");
		web.ignoring().antMatchers("/templates/**");
		web.ignoring().antMatchers("/values/**");
		web.ignoring().antMatchers("/register**");
	}
	/**
	 * The main configuration method for Spring Security.
	 * 
	 */
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		super.configure(http);
		
		http
		.authorizeRequests()
        	.antMatchers("/**", "/css/**")
        		.permitAll()
        		.anyRequest()
        		.authenticated()
            	.and()
        .formLogin()
            .loginPage("/login")
            	.permitAll()
            .and()
        .logout()                                    
        	.permitAll()
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
	
	public void setDatasource(DataSource datasource){
		this.datasource = datasource;
	}
}
