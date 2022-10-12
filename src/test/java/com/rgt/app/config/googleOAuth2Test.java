/*
 * package com.rgt.app.config;
 * 
 * import static org.mockito.Mockito.when;
 * 
 * import java.util.ArrayList; import java.util.List; import java.util.Optional;
 * 
 * import org.junit.jupiter.api.Test; import
 * org.junit.jupiter.api.extension.ExtendWith; import org.mockito.InjectMocks;
 * import org.mockito.Mock; import org.mockito.Mockito; import
 * org.mockito.junit.jupiter.MockitoExtension; import
 * org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.boot.test.mock.mockito.MockBean; import
 * org.springframework.context.support.BeanDefinitionDsl.Role; import
 * org.springframework.security.oauth2.core.OAuth2AccessToken; import
 * org.springframework.security.web.RedirectStrategy; import
 * org.springframework.test.context.ContextConfiguration; import
 * org.springframework.test.web.servlet.MockMvc;
 * 
 * import com.rgt.app.configuration.googleOAuth2SuccessHandler; import
 * com.rgt.app.models.User; import com.rgt.app.repository.RoleRepository; import
 * com.rgt.app.repository.UserRepository;
 * 
 * @ExtendWith(MockitoExtension.class)
 * 
 * @SpringBootTest
 * 
 * @ContextConfiguration(classes = googleOAuth2SuccessHandler.class)
 * 
 * public class googleOAuth2Test {
 * 
 * @MockBean private UserRepository userRepository;
 * 
 * @MockBean private RedirectStrategy redirectStrategy;
 * 
 * @MockBean private RoleRepository roleRepository;
 * 
 * @Mock private OAuth2AccessToken accessToken;
 * 
 * @Mock private MockMvc mockMvc;
 * 
 * @Test public void OnAuthenticationSuccessTest() {
 * 
 * 
 * List<User> user=new ArrayList<>(); User user2=new User();
 * user2.setEmail("asd"); user2.setId(1); user2.setFirstName("sdf");
 * user2.setLastName("asd");
 * 
 * Mockito.when(userRepository.findUserByEmail("asd"));
 * Mockito.when(userRepository.save(user2)).thenReturn(user2); //
 * when(roleRepository.findById(2)).thenReturn(roles); }
 * 
 * }
 */