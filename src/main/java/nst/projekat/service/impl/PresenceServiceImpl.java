package nst.projekat.service.impl;

import nst.projekat.domain.Event;
import nst.projekat.domain.Notification;
import nst.projekat.domain.Presence;
import nst.projekat.domain.User;
import nst.projekat.dto.EventDTO;
import nst.projekat.dto.PresenceDTO;
import nst.projekat.dto.UserDTO;
import nst.projekat.mapper.EventMapper;
import nst.projekat.mapper.PresenceMapper;
import nst.projekat.mapper.UserMapper;
import nst.projekat.repository.EventRepository;
import nst.projekat.repository.NotificationRepository;
import nst.projekat.repository.PresenceRepository;
import nst.projekat.service.PresenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

@Service
public class PresenceServiceImpl implements PresenceService {
    @Autowired
    private PresenceRepository presenceRepository;

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private EventRepository eventRepository;

    @Override
    public PresenceDTO save(PresenceDTO presenceDTO) {
        Presence presence = presenceRepository.save(PresenceMapper.INSTANCE.presenceDTOToPresence(presenceDTO));
        createInvitation(presence.getUserID(), presence.getEventID());
        return PresenceMapper.INSTANCE.presenceToPresenceDTO(presence);
    }

    private void createInvitation(Long userID, Long eventID) {
        Notification notification = new Notification();
        notification.setDate(new Date());
        notification.setSent(false);
        notification.setType("Pozivnica");
        Presence p = new Presence();
        p.setUserID(userID);
        p.setEventID(eventID);
        notification.setPresence(p);
/*        User u = new User();
        u.setUserID(userID);
        notification.setUser(u);*/
        Optional<Event> e = eventRepository.findById(eventID);
/*        notification.setEvent(e.get());*/
        notification.setText("Pozivnica za " + e.get().getName());
        notificationRepository.save(notification);
    }

    @Override
    public Set<PresenceDTO> findAllByEvent(Long eventID) {
        return PresenceMapper.INSTANCE.toPresenceDTOs(presenceRepository.findAllByEventID(eventID));
    }

    @Override
    public Set<PresenceDTO> findAllByUser(Long userID) {
        return PresenceMapper.INSTANCE.toPresenceDTOs(presenceRepository.findAllByUserID(userID));
    }
}
