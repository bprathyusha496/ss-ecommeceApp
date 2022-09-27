/*
 * package com.rgt.app.config;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.authentication.dao.DaoAuthenticationProvider;
 * import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
 * org.springframework.security.web.csrf.CookieCsrfTokenRepository; import
 * org.springframework.security.web.util.matcher.AntPathRequestMatcher;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class SecurityConfig extends
 * WebSecurityConfigurerAdapter {
 * 
 * @Bean public customUserDetailService getcustomUserDetailsService() { return
 * new customUserDetailService(); }
 * 
 * @Bean public BCryptPasswordEncoder passwordEncoder() { return new
 * BCryptPasswordEncoder(); }
 * 
 * @Bean public DaoAuthenticationProvider authenticationProvider() {
 * DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
 * auth.setUserDetailsService(this.getcustomUserDetailsService());
 * auth.setPasswordEncoder(passwordEncoder()); return auth; }
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception {
 * http.csrf().disable(); http.authorizeRequests()
 * .antMatchers("/ad/**").hasRole("ADMIN")
 * .antMatchers("/cart/**").hasRole("USER") .antMatchers("/**").permitAll()
 * .and().formLogin() .and().csrf().disable() .httpBasic(); }
 * 
 * }
 */