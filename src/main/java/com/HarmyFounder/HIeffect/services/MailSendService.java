package com.HarmyFounder.HIeffect.services;

import com.HarmyFounder.HIeffect.models.User;
import com.HarmyFounder.HIeffect.repositories.UserDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.LocalTime;
import java.util.Properties;

@Service
public class MailSendService {

    @Autowired
    private UserDetailRepo userDetailRepo;


    private final String from = "ofbrick121@gmail.com";
    String host = "smtp.gmail.com";
    String smtpPort = "465";

    Properties properties = new Properties();

    {
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", smtpPort);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
    }

    Session session = Session.getInstance(properties,
            new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from, "nnmtuzrzseynnkxi");
                }
            });


    public void sendMessageNotification(User user, int hour, int minute) throws MessagingException {

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
        message.setSubject("Daily Habits Pool");
        message.setText(user.getHabits().toString());

        while (true) {
            if (LocalTime.now().getHour() == hour && LocalTime.now().getMinute() == minute && LocalTime.now().getSecond() == 1) {
                Transport.send(message);
            }
        }

    }

}



