package nst.projekat.service;

import nst.projekat.domain.Notification;

import java.util.List;

public interface NotificationService {
    Notification save(Notification notification);
    void sendInvitations();
    void sendNotifications();
}
