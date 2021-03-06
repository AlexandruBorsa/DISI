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
    public ResponseEntity<?> deleteTrainer(@PathVariable Integer id){

        trainerService.deleteTrainer(id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/trainers")
    public ResponseEntity<Trainer> updateTrainer(@RequestBody Trainer trainer){

        trainerService.updateTrainer(trainer);

        return new ResponseEntity<>(trainer, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public ResponseEntity<Trainer> getTrainerByUsername(@RequestBody Trainer trainer){
        Trainer existsTrainer = trainerService.getTrainerByUsernameAndPassword(trainer.getUsername(), trainer.getPassword());

        if(existsTrainer==null) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        } else {
            existsTrainer.setPassword("");
            return new ResponseEntity<>(existsTrainer, HttpStatus.OK);
        }
    }


}
