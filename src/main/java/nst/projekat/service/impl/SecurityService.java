package nst.projekat.service.impl;

import nst.projekat.domain.Speaker;
import nst.projekat.domain.User;
import nst.projekat.repository.SpeakerRepository;
import nst.projekat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SpeakerRepository speakerRepository;

    @Autowired
    public SecurityService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        Speaker speaker = speakerRepository.findByUsername(username);

        if (user != null) {
            return user;
        }

        if (speaker != null) {
            return speaker;
        }

        throw new UsernameNotFoundException(
                "User '" + username + "' not found");
    }
}
