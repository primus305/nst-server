package nst.projekat.controller;

import nst.projekat.domain.UserSessionPK;
import nst.projekat.dto.AgendaSessionSpeakerDTO;
import nst.projekat.dto.UserSessionDTO;
import nst.projekat.service.AgendaSessionSpeakerService;
import nst.projekat.service.UserSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "userSession")
@CrossOrigin
public class UserSessionController {
    @Autowired
    private UserSessionService userSessionService;

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity save(@RequestBody UserSessionDTO userSessionDTO) {
        try {
            return ResponseEntity.ok(userSessionService.save(userSessionDTO));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
    @RequestMapping(value = "all/{agendaID}-{sessionID}",method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity findAllBySession(@PathVariable Long agendaID, @PathVariable Long sessionID) {
        try {
            return ResponseEntity.ok(userSessionService.findAllByAgendaAndSession(agendaID, sessionID));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @RequestMapping(value = "delete/{agendaID}-{sessionID}-{userID}-{eventID}", method = RequestMethod.DELETE)
    public @ResponseBody
    ResponseEntity delete(@PathVariable Long agendaID, @PathVariable Long sessionID, @PathVariable Long userID, @PathVariable Long eventID) {
        try {
            UserSessionPK userSessionPK = new UserSessionPK(sessionID, agendaID, userID, eventID);
            userSessionService.deleteById(userSessionPK);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @RequestMapping(value = "get/{agendaID}-{sessionID}-{userID}-{eventID}")
    public @ResponseBody
    ResponseEntity findById(@PathVariable Long agendaID, @PathVariable Long sessionID, @PathVariable Long userID, @PathVariable Long eventID) {
        try {
            UserSessionPK userSessionPK = new UserSessionPK(sessionID, agendaID, userID, eventID);
            return ResponseEntity.ok(userSessionService.findById(userSessionPK));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid id!");
        }
    }

    @RequestMapping(value = "mySessions/{userID}",method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity findAllByUser(@PathVariable Long userID) {
        try {
            return ResponseEntity.ok(userSessionService.findByUser(userID));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}
