package nst.projekat.dto;

import lombok.Data;

@Data
public class NotificationDTO {
    private Long notificationID;
    private String type;
    private String text;
    private String date;
    private boolean sent;
    private PresenceDTO presence;
}
