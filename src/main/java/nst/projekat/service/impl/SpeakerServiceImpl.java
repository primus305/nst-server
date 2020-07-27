package nst.projekat.service.impl;

import nst.projekat.domain.*;
import nst.projekat.dto.SpeakerDTO;
import nst.projekat.mapper.SpeakerMapper;
import nst.projekat.mapper.UserMapper;
import nst.projekat.repository.AgendaSessionRepository;
import nst.projekat.repository.SpeakerRepository;
import nst.projekat.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SpeakerServiceImpl implements SpeakerService {
    @Autowired
    private SpeakerRepository speakerRepository;

    @Autowired
    private AgendaSessionRepository agendaSessionRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<SpeakerDTO> findAll() {
        return SpeakerMapper.INSTANCE.toSpeakerDTOs(speakerRepository.findAll());
    }

    @Override
    public SpeakerDTO save(SpeakerDTO speakerDTO) {
        Speaker speaker = SpeakerMapper.INSTANCE.speakerDTOToSpeaker(speakerDTO);
        speaker.setPassword(passwordEncoder.encode(speakerDTO.getPassword()));
        return SpeakerMapper.INSTANCE.speakerToSpeakerDTO(speakerRepository.save(speaker));
    }

    @Override
    public List<SpeakerDTO> findAllNotOnSession(Long sessionID, Long agendaID) {
        List<Speaker> speakers = speakerRepository.findAll();
        Optional<AgendaSession> session = agendaSessionRepository.findById(new AgendaSessionPK(sessionID, agendaID));
        if (session.isPresent()) {
            session.get().getSpeakers().forEach(speaker -> {
                speakers.removeIf(speaker1 -> speaker1.getSpeakerID().equals(speaker.getSpeakerID()));
            });
        }
        return SpeakerMapper.INSTANCE.toSpeakerDTOs(speakers);
    }
}
