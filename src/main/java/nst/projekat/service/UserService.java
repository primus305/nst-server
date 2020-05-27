package nst.projekat.service;

import nst.projekat.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> findAll();
    UserDTO save(UserDTO userDTO);
}
