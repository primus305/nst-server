package nst.projekat.controller;

import nst.projekat.dto.EventDTO;
import nst.projekat.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "event")
@CrossOrigin
public class EventController {
    @Autowired
    private EventService eventService;

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity save(@RequestBody EventDTO eventDTO) {
        try {
            return ResponseEntity.ok(eventService.save(eventDTO));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @RequestMapping(value = "get/{id}")
    public @ResponseBody
    ResponseEntity findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(eventService.findById(id));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid id!");
        }
    }

    @RequestMapping(value = "all",method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity findAll() {
        try {
            return ResponseEntity.ok(eventService.findAll());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

//    @RequestMapping(value = "getByAgenda/{agendaID}")
//    public @ResponseBody
//    ResponseEntity findByAgenda(@PathVariable Long agendaID) {
//        try {
//            return ResponseEntity.ok(eventService.findByAgenda(agendaID));
//        } catch (Exception ex) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid id!");
//        }
//    }

    @RequestMapping(value = "allBySpeaker/{speakerID}",method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity findAllBySpeakerGroupByAgenda(@PathVariable Long speakerID) {
        try {
            return ResponseEntity.ok(eventService.findAllBySpeakerGroupByAgenda(speakerID));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}
