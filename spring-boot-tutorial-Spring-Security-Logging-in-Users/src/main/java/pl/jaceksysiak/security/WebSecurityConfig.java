package pl.jaceksysiak.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter   {

	//@Override
	protected void configure(HttpSecurity http) throws Exception {

		// @formatter:off
		
				http
					.authorizeRequests()
						.antMatchers("/", "/about")
						.permitAll()
						.antMatchers(
							"/js/*",
							"/css/*",
							"/img/*")
						.permitAll()
					.anyRequest()
						.authenticated()
						.and()
					.formLogin()
						.loginPage("/login")
						.defaultSuccessUrl("/")
						.permitAll()
						.and()
						.logout()
						.permitAll();
				
		// @formatter:on
	}
	
	
//	//@Override
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{    
//		
//		// @formatter:off
//	    auth
//	    .inMemoryAuthentication()
//	    .passwordEncoder(NoOpPasswordEncoder.getInstance())
//	            .withUser("aa")
//	            .password("aa")
//	            .roles("USER")
//	            .and()
//	            .withUser("jj")
//	            .password("jj")
//	            .roles("ADMIN");
//	    // @formatter:on
//	}
	
 
	@Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// @formatter:off
 
	    auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
        .withUser("aa").password("aa").roles("USER").and()
        .withUser("bb").password("bb").roles("ADMIN");
	    
	    System.out.println("auth: " + auth);
	    
	    // @formatter:on
    }

 
}
