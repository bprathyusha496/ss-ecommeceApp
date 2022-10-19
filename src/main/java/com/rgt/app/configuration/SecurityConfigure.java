package com.rgt.app.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@SuppressWarnings("deprecation")
@Configuration

@EnableWebSecurity
public class SecurityConfigure extends WebSecurityConfigurerAdapter {

	@Autowired 
	private googleOAuth2SuccessHandler googleOAuth2SuccessHandler;

	@Autowired
	private CustomUserDetailService customUserDetailService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/shop", "/register","/login", "/admin","/shop/**").permitAll()
		       .antMatchers("/ad/**").hasRole("ADMIN").anyRequest().authenticated()
		        .and()
				.formLogin() 
				.loginPage("/login")
				.permitAll() 
			 	.failureUrl("/login?error=true").defaultSuccessUrl("/shop")
				.usernameParameter("email").passwordParameter("password").and()
				.oauth2Login().loginPage("/login")
				.successHandler(googleOAuth2SuccessHandler).and()
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/shop")
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")
				.and()
				.exceptionHandling()
				.and()
				.csrf()
				.disable(); 

	//http.headers().frameOptions().disable();
	}

/////////////////////////////////////////////	=================================

	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception { http
	 * .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
	 * .and() .authorizeRequests()
	 * .antMatchers("/ad/**").hasRole("ADMIN").antMatchers("/**").permitAll()
	 * 
	 * .antMatchers("/sh/**").hasRole("USER")
	 * 
	 * .and().formLogin()
	 * .loginPage("/shop").loginProcessingUrl("/login").defaultSuccessUrl("/home")
	 * 
	 * .loginPage("/admin").loginProcessingUrl("/login").defaultSuccessUrl("/admin")
	 * .and().csrf().disable() .httpBasic();
	 * 
	 * }
	 */

	@Bean
	public BCryptPasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(this.customUserDetailService);
		auth.setPasswordEncoder(encode());
		return auth;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailService);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/images/**", "/productImages/**", "/css/**",
				"/js/**");
	}

}
