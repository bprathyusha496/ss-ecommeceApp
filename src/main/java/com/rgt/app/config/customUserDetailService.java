/*
 * package com.rgt.app.config;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.core.userdetails.UsernameNotFoundException;
 * import org.springframework.stereotype.Service;
 * 
 * import com.rgt.app.models.User; import com.rgt.app.repository.UserRepository;
 * 
 * 
 * public class customUserDetailService extends User implements
 * UserDetailsService {
 * 
 * @Autowired private UserRepository userRepository;
 * 
 * @Override public UserDetails loadUserByUsername(String email) throws
 * UsernameNotFoundException { User user =
 * userRepository.findUserByEmail(email);
 * 
 * if (user == null) { throw new
 * UsernameNotFoundException("could not found user !!"); } customUserDetail
 * customUserDetail = new customUserDetail(user); return customUserDetail;
 * 
 * 
 * 
 * }
 * 
 * }
 */