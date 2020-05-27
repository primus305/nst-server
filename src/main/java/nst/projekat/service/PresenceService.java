package nst.projekat.service;

import nst.projekat.dto.PresenceDTO;

import java.util.Set;

public interface PresenceService {
    PresenceDTO save(PresenceDTO presenceDTO);
    Set<PresenceDTO> findAllByEvent(Long eventID);
    Set<PresenceDTO> findAllByUser(Long userID);
}
