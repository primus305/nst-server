package nst.projekat.service.impl;

import nst.projekat.domain.*;
import nst.projekat.mail.MailService;
import nst.projekat.repository.*;
import nst.projekat.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private UserSessionRepository userSessionRepository;

    @Autowired
    private PresenceRepository presenceRepository;

    @Autowired
    private AgendaSessionRepository agendaSessionRepository;

    @Autowired
    private MailService emailService;

    @Override
    public Notification save(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public void sendInvitations() {
        List<Notification> toSent = notificationRepository.findAllBySentAndType(false, "Pozivnica");
        if (toSent.size() > 0) {
            for (Notification n: toSent) {
                emailService.sendEmail(n);
            }
        }
    }

    @Override
    public void sendNotifications() {
        List<Presence> presences = presenceRepository.findAll();
        for (Presence p: presences) {
            List<UserSession> mySessions = userSessionRepository.findAllByUserIDAndEventID(p.getUserID(), p.getEventID());
            List<AgendaSession> sessionsToSent = new ArrayList<>();
            if (mySessions.size() > 0) {
                for (UserSession userSession: mySessions) {
                    AgendaSessionPK pkSession = new AgendaSessionPK(userSession.getSessionID(), userSession.getAgendaID());
                    Optional<AgendaSession> agendaSession = agendaSessionRepository.findById(pkSession);
                    GregorianCalendar sessionDate = new GregorianCalendar();
                    sessionDate.setTime(agendaSession.get().getTimeFrom());
                    int tomorrowDay = new GregorianCalendar().get(GregorianCalendar.DAY_OF_MONTH) + 1;
                    int year = new GregorianCalendar().get(GregorianCalendar.YEAR);
                    int month = new GregorianCalendar().get(GregorianCalendar.MONTH);
                    if ((sessionDate.get(GregorianCalendar.DAY_OF_MONTH) == tomorrowDay)
                            && (sessionDate.get(GregorianCalendar.MONTH) == month)
                            && (sessionDate.get(GregorianCalendar.YEAR) == year)) {
                        sessionsToSent.add(agendaSession.get());
                    }
                }
                if (sessionsToSent.size() > 0) {
                    emailService.sendNotifications(sessionsToSent, p.getEvent(), p.getUser());
                }
            }
        }
    }
}
