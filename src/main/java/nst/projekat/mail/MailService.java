package nst.projekat.mail;

import nst.projekat.domain.*;
import nst.projekat.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class MailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private NotificationService notificationService;

    public void sendEmail(Notification notification) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(notification.getPresence().getUser().getEmail());
        msg.setSubject("Obavestenje o novom dogadjaju\n");
        msg.setText("Poštovani,\nObaveštavamo Vas da ste pozvani na " + notification.getPresence().getEvent().getName() +
                        "\n\nPosetite naš sajt kako biste videli detaljan raspored." +
                "\nSrdačan pozdrav, " +
                "\n\nSistem za upravljanje događajima" +
                "\nBulevar Oslobođenja 33, 11000 Beograd - Voždovac" +
                "\ntel.: +381 11 551 23 35");

        javaMailSender.send(msg);
        notification.setSent(true);
        notificationService.save(notification);
    }

    public void sendNotifications(List<AgendaSession> sessionsToSent, Event event, User user) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(user.getEmail());
        msg.setSubject("Obavestenje o sutrasnjim sekcijama na " +event.getName()+ "\n");
        msg.setText("Poštovani,\nPodsecamo Vas na sutrasnje sekcije:\n\n" + sessionsNotification(sessionsToSent) +
                "\nZa detaljniji pregled sekcija posetite nas sajt. " +
                "\nSrdačan pozdrav, " +
                "\n\nSistem za upravljanje događajima" +
                "\nBulevar Oslobođenja 33, 11000 Beograd - Voždovac" +
                "\ntel.: +381 11 551 23 35");

        javaMailSender.send(msg);
        createNotification(user, event);
    }

    private void createNotification(User user, Event event) {
        Notification notification = new Notification();
        notification.setDate(new Date());
        notification.setSent(true);
        notification.setType("Obavestenje");
        Presence p = new Presence();
        p.setUserID(user.getUserID());
        p.setEventID(event.getEventID());
        notification.setPresence(p);
        notification.setText("Sutrasnje sekcije za " + event.getName());
        notificationService.save(notification);
    }

    public String sessionsNotification(List<AgendaSession> sessions) {
        StringBuilder sb = new StringBuilder();
        for (AgendaSession as: sessions) {
            sb.append(as.getName() + ", " + new SimpleDateFormat("HH:mm").format(as.getTimeFrom()) + "\n");
        }
        return sb.toString();
    }
}
