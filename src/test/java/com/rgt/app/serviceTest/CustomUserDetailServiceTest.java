/*
 * package com.rgt.app.serviceTest;
 * 
 * import static org.mockito.ArgumentMatchers.anyString; import static
 * org.mockito.Mockito.times; import static org.mockito.Mockito.verify; import
 * static
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
 * 
 * import org.junit.jupiter.api.Test; import org.mockito.InjectMocks; import
 * org.mockito.Mock; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.boot.test.mock.mockito.MockBean; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.test.web.servlet.MockMvc;
 * 
 * import com.rgt.app.configuration.CustomUserDetailService; import
 * com.rgt.app.models.User; import com.rgt.app.repository.UserRepository;
 * 
 * @SpringBootTest public class CustomUserDetailServiceTest {
 * 
 * @MockBean private UserRepository userRepository;
 * 
 * @InjectMocks CustomUserDetailService customUserDetailService; //@Autowired
 * //MockMvc mockMvc;
 * 
 * @Test public void loadUserByUsernameTest()throws Exception { User user=new
 * User(); user.setEmail("asdf@gmail.com");
 * customUserDetailService.loadUserByUsername(user.getEmail());
 * verify(userRepository,times(1)).findUserByEmail("asdf@gmail.com"); }
 * 
 * 
 * }
 */