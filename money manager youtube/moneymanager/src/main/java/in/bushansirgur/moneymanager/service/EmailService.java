package in.bushansirgur.moneymanager.service;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    // This is normally used to send emails
    // We are keeping it but not using it right now
    // private final JavaMailSender mailSender;

    @Value("${spring.mail.properties.mail.smtp.from}")
    private String fromEmail;

    // ================================
    // EMAIL SENDING METHOD (DISABLED)
    // ================================
    public void sendEmail(String to, String subject, String body) {

        // EMAIL DISABLED FOR DEVELOPMENT
        // Instead of sending email, it will print the activation link in console

        System.out.println("======================================");
        System.out.println("EMAIL SERVICE TEMPORARILY DISABLED");
        System.out.println("From: " + fromEmail);
        System.out.println("To: " + to);
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);
        System.out.println("======================================");

        // Original email code commented below

        /*
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(fromEmail);
            message.setTo(to);
            message.setSubject(subject);
            message.setText(body);
            mailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        */

    }

    // =======================================
    // EMAIL WITH ATTACHMENT METHOD (DISABLED)
    // =======================================
    public void sendEmailWithAttachment(String to, String subject, String body, byte[] attachment, String filename) throws MessagingException {

        // EMAIL ATTACHMENT DISABLED
        // Only printing information in console

        System.out.println("======================================");
        System.out.println("EMAIL ATTACHMENT SERVICE DISABLED");
        System.out.println("To: " + to);
        System.out.println("Subject: " + subject);
        System.out.println("Attachment: " + filename);
        System.out.println("======================================");

        // Original attachment code commented below

        /*
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom(fromEmail);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(body);
        helper.addAttachment(filename, new ByteArrayResource(attachment));

        mailSender.send(message);
        */

    }
}