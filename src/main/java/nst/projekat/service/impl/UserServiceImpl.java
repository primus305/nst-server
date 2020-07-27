package nst.projekat.service.impl;

import nst.projekat.domain.Presence;
import nst.projekat.domain.User;
import nst.projekat.dto.UserDTO;
import nst.projekat.mapper.UserMapper;
import nst.projekat.repository.EventRepository;
import nst.projekat.repository.PresenceRepository;
import nst.projekat.repository.UserRepository;
import nst.projekat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PresenceRepository presenceRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserDTO> findAll() {
        return UserMapper.INSTANCE.toUserDTOs(userRepository.findAll());
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        User user = UserMapper.INSTANCE.userDTOToUser(userDTO);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        return UserMapper.INSTANCE.userToUserDTO(userRepository.save(user));
    }

    @Override
    public List<UserDTO> findAllNotInvited(Long eventID) {
        List<User> users = userRepository.findAll();
        Set<Presence> eventAttendees = presenceRepository.findAllByEventID(eventID);
        eventAttendees.forEach(attendee -> {
            users.removeIf(user -> user.getUserID().equals(attendee.getUserID()));
        });
        return UserMapper.INSTANCE.toUserDTOs(users);
    }
}
