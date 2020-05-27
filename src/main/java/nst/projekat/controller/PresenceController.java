package nst.projekat.controller;

import nst.projekat.dto.PresenceDTO;
import nst.projekat.service.PresenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "presence")
@CrossOrigin
public class PresenceController {
    @Autowired
    private PresenceService presenceService;

    @RequestMapping(value = "saveAll", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity save(@RequestBody List<PresenceDTO> presenceDTOs) {
        try {
            for (PresenceDTO presenceDTO: presenceDTOs) {
                presenceService.save(presenceDTO);
            }
            return ResponseEntity.ok(presenceDTOs);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @RequestMapping(value = "allByEvent/{eventID}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity findAllByEvent(@PathVariable Long eventID) {
        try {
            return ResponseEntity.ok(presenceService.findAllByEvent(eventID));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @RequestMapping(value = "allByUser/{userID}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity findAllByUser(@PathVariable Long userID) {
        try {
            return ResponseEntity.ok(presenceService.findAllByUser(userID));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}
