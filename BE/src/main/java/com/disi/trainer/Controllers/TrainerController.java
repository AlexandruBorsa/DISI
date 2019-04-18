package com.disi.trainer.Controllers;


import com.disi.trainer.BusinessLogic.TrainerService;
import com.disi.trainer.DataAccess.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.disi.trainer.BusinessLogic.TrainerService;
import com.disi.trainer.DataAccess.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

@RestController
public class TrainerController {

    @Autowired
    private TrainerService trainerService;


    @RequestMapping("/trainers")
    public List<Trainer> getAllTrainers() {
        return trainerService.getAllTrainers();
    }

    @RequestMapping("/trainer/{id}")
    public Optional<Trainer> getTrainer(@PathVariable String id) {
        return trainerService.getTrainer(Long.parseLong(id));
    }

    @RequestMapping(method = RequestMethod.POST, value="/trainers")
    public void addTrainer(@RequestBody Trainer trainer) {
        trainerService.addTrainer(trainer);
    }

    @PostMapping("/login")
    public String getTrainer(String username, String password){
        if(!trainerService.getTrainerByUsernameAndPassword(username, password).getUsername().isEmpty())
            return "200";
        else return "404";
    }


}
