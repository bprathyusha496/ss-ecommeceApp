/*
 * package com.rgt.app.config;
 * 
 * import static org.mockito.Mockito.when; import static
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
 * import java.util.Optional; import org.junit.jupiter.api.Test; import
 * org.junit.jupiter.api.extension.ExtendWith; import org.mockito.Mock; import
 * org.mockito.Mockito; import org.mockito.junit.jupiter.MockitoExtension;
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.boot.test.mock.mockito.MockBean; import
 * org.springframework.http.MediaType; import
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
 * @Autowired googleOAuth2SuccessHandler handler;
 * 
 * @Test public void OnAuthenticationSuccessTest() throws Exception {
 * 
 * Optional<User> user =Optional.of(new User()); User user2 = new User();
 * user2.setEmail("asd"); user2.setId(1); user2.setFirstName("sdf");
 * user2.setLastName("asd"); Optional<com.rgt.app.models.Role> roles =
 * Optional.empty();
 * 
 * 
 * Mockito.when(userRepository.findUserByEmail("asd")).thenReturn(user);
 * Mockito.when(userRepository.save(user2)).thenReturn(user2); //
 * when(roleRepository.findById(2)).thenReturn(roles);
 * mockMvc.perform(get("/").contentType(MediaType.ALL));
 * 
 * }
 * 
 * }
 */