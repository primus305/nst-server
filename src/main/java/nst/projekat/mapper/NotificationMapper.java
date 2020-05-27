package nst.projekat.mapper;

import nst.projekat.domain.Agenda;
import nst.projekat.domain.Notification;
import nst.projekat.dto.AgendaDTO;
import nst.projekat.dto.NotificationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NotificationMapper {
    NotificationMapper INSTANCE = Mappers.getMapper(NotificationMapper.class);

    @Mapping(target = "date", source = "notification.date",
            dateFormat = "EEE MMM dd yyyy HH:mm:ss")
    NotificationDTO notificationToNotificationDTO(Notification notification);

    @Mapping(target = "date", source = "notificationDTO.date",
            dateFormat = "EEE MMM dd yyyy HH:mm:ss")
    Notification notificationDTOToNotification(NotificationDTO notificationDTO);

    List<NotificationDTO> toNotificationDTOs(List<Notification> notifications);
}
