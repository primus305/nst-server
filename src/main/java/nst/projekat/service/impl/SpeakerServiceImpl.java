package nst.projekat.service.impl;

import nst.projekat.domain.Speaker;
import nst.projekat.domain.Track;
import nst.projekat.dto.SpeakerDTO;
import nst.projekat.mapper.SpeakerMapper;
import nst.projekat.repository.SpeakerRepository;
import nst.projekat.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpeakerServiceImpl implements SpeakerService {
    @Autowired
    private SpeakerRepository speakerRepository;

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
        /*Speaker s = speakerRepository.findByEmail(speaker.getEmail());
        if(s == null) {
            return SpeakerMapper.INSTANCE.speakerToSpeakerDTO(speakerRepository.save(speaker));
        }
        return null;*/
    }
}
