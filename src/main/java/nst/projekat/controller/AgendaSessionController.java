package nst.projekat.controller;

import nst.projekat.domain.AgendaSessionPK;
import nst.projekat.dto.AgendaDTO;
import nst.projekat.dto.AgendaSessionDTO;
import nst.projekat.dto.EventDTO;
import nst.projekat.service.AgendaSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "agendaSession")
@CrossOrigin
public class AgendaSessionController {
    @Autowired
    private AgendaSessionService agendaSessionService;

    @RequestMapping(value = "get/{agendaID}-{sessionID}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity findById(@PathVariable Long agendaID, @PathVariable Long sessionID) {
        try {
            AgendaSessionPK id = new AgendaSessionPK(sessionID, agendaID);
            return ResponseEntity.ok(agendaSessionService.findById(id));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid id!");
        }
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public @ResponseBody
    ResponseEntity update(@RequestBody AgendaSessionDTO agendaSessionDTO) {
        try {
            return ResponseEntity.ok(agendaSessionService.save(agendaSessionDTO));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}
