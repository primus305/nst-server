package nst.projekat.controller;

import nst.projekat.domain.*;
import nst.projekat.dto.AgendaDTO;
import nst.projekat.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "agenda")
@CrossOrigin
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    @Autowired
    private AgendaSessionService agendaSessionService;

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity save(@RequestBody AgendaDTO agendaDTO) {
        try {
/*            agendaService.save(agenda);
            for (AgendaSession as: agenda.getSessions()) {
                agendaSessionService.save(as);
            }*/
            return ResponseEntity.ok(agendaService.save(agendaDTO));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @RequestMapping(value = "get/{id}")
    public @ResponseBody
    ResponseEntity findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(agendaService.findById(id));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid id!");
        }
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    ResponseEntity delete(@PathVariable Long id) {
        try {
            agendaService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @RequestMapping(value = "id")
    public @ResponseBody
    ResponseEntity getNextID() {
        try {
            return ResponseEntity.ok(agendaService.nextID());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid id!");
        }
    }

    @RequestMapping(value = "all",method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity findAll() {
        try {
            return ResponseEntity.ok(agendaService.findAll());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}
