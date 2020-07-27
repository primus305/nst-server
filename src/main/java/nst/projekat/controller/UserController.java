package nst.projekat.controller;

import nst.projekat.domain.User;
import nst.projekat.dto.UserDTO;
import nst.projekat.service.UserService;
import nst.projekat.service.impl.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping(value = "user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public Principal login(Principal principal) {
        return principal;
    }

    @RequestMapping(value = "allNotInvited/{eventID}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity findAll(@PathVariable Long eventID) {
        try {
            return ResponseEntity.ok(userService.findAllNotInvited(eventID));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity save(@RequestBody UserDTO userDTO) {
        try {
            return ResponseEntity.ok(userService.save(userDTO));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}
