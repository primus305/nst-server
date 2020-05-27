package nst.projekat.cron;

import nst.projekat.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
    @Autowired
    private NotificationService notificationService;

    @Scheduled(fixedRate = 60 * 1000)
    public void reportCurrentTime() {
        notificationService.sendInvitations();
    }

    @Scheduled(fixedRate = 24 * 60 * 60 * 1000)
    public void sendNotifications() {
        notificationService.sendNotifications();
    }
}
