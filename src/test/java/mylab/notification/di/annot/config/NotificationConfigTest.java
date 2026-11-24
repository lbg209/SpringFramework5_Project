package mylab.notification.di.annot.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import mylab.notification.di.annot.EmailNotificationService;
import mylab.notification.di.annot.NotificationManager;
import mylab.notification.di.annot.SmsNotificationService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = NotificationConfig.class)
public class NotificationConfigTest {

	@Autowired
	NotificationManager notificationManager;
	
	@Test
	void nofiticationTest() {
		assertNotNull(notificationManager);
	}
	
	@Test
	void emailServiceTest() {
		assertNotNull(notificationManager.getEmailService());
		
		EmailNotificationService emailService = (EmailNotificationService) notificationManager.getEmailService();

		assertEquals("smtp.gmail.com", emailService.getSmtpServer());
		assertEquals(587, emailService.getPort());
	}
	
	@Test
	void smsServiceTest() {
		assertNotNull(notificationManager.getSmsService());
		
		SmsNotificationService smsService = (SmsNotificationService) notificationManager.getSmsService();

		assertEquals("SKT", smsService.getProvider());
	}
	
	
}
