/*
 * package com.rgt.app.emailTest;
 * 
 * import static org.junit.Assert.assertEquals; import static
 * org.junit.Assert.assertTrue;
 * 
 * import java.io.IOException;
 * 
 * import javax.mail.MessagingException; import javax.mail.internet.MimeMessage;
 * import org.junit.jupiter.api.Test; import org.mockito.InjectMocks; import
 * org.springframework.boot.test.context.SpringBootTest;
 * 
 * import com.rgt.app.email.Email; import com.rgt.app.email.EmailSenderService;
 * 
 * @SpringBootTest public class EmailSenderServiceTest {
 * 
 * @InjectMocks private EmailSenderService emailSenderService;
 * 
 * @Test public void shouldSendSingleMail() throws MessagingException,
 * IOException {
 * 
 * emailSenderService.sendEmail(null, null, null);
 * 
 * 
 * MimeMessage[] receivedMessages = smtpServerRule.getMessages();
 * assertEquals(1, receivedMessages.length);
 * 
 * MimeMessage current = receivedMessages[0];
 * 
 * assertEquals(mail.getSubject(), current.getSubject());
 * assertEquals(mail.getTo(), current.getAllRecipients()[0].toString());
 * assertTrue(String.valueOf(current.getContent()).contains(mail.getContent()));
 * 
 * 
 * }
 * 
 * }
 */