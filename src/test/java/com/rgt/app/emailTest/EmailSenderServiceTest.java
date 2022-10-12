package com.rgt.app.emailTest;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.rgt.app.email.EmailSenderService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class EmailsenderserviceTest {

	@Mock
	private JavaMailSender mailSender;
	@InjectMocks
	private EmailSenderService emailSenderService;
	@Mock
	private SimpleMailMessage mailMessage;

	@Test
	public void sendEmailTest() {
		String from ="asd";
		String to="bn";
		String text="sdfg";
		String subject="sdfg";
	
		mailMessage.setFrom(from);
		mailMessage.setTo(to);
		mailMessage.setText(text);
		mailMessage.setSubject(subject);
	
	mailSender.send(mailMessage);
	emailSenderService.sendEmail(to, subject, subject);
	Assert.assertEquals(subject, subject);
	Assert.assertEquals(from, from);
	Assert.assertEquals(to, to);
	Assert.assertEquals(text, text);
 


	

	}

}
/*
 * User user = new User(); user.setEmail("asd@gmail.com"); Optional<User> opt =
 * Optional.of(user);
 * when(userRepository.findUserByEmail(anyString())).thenReturn(opt);
 * customUserDetailService.loadUserByUsername(anyString()); //
 * when(user.getEmail().isEmpty()).thenThrow(UsernameNotFoundException.class);
 * assertEquals("asd@gmail.com",user.getEmail());
 */