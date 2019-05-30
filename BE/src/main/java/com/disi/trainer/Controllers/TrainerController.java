package com.disi.trainer.Controllers;


import com.disi.trainer.BusinessLogic.TrainerService;
import com.disi.trainer.DataAccess.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class TrainerController {

    @Autowired
    private TrainerService trainerService;


    @RequestMapping(method = RequestMethod.GET, value = "/trainers")
    public List<Trainer> getAllTrainers() {
        return trainerService.getAllTrainers();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/trainers/{id}")
    public Optional<Trainer> getTrainer(@PathVariable String id) {
        return trainerService.getTrainer(Integer.parseInt(id));
    }

    @RequestMapping(method = RequestMethod.POST, value="/trainers")
    public ResponseEntity<Trainer> addTrainer(@RequestBody Trainer trainer) {

        trainerService.addTrainer(trainer);

        return new ResponseEntity<>(trainer, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/trainers/{id}")
    public ResponseEntity<?> deleteTrainer(@PathVariable String id){

        trainerService.deleteTrainer(Integer.parseInt(id));

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/trainers")
    public ResponseEntity<Trainer> updateTrainer(@RequestBody Trainer trainer){

        trainerService.updateTrainer(trainer);

        return new ResponseEntity<>(trainer, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public ResponseEntity<Trainer> getTrainerByUsername(@RequestParam String username, @RequestParam String password){
        Trainer trainer = trainerService.getTrainerByUsernameAndPassword(username, password);

        if(trainer==null) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        } else {
            return new ResponseEntity<>(trainer, HttpStatus.OK);
        }
    }


}
