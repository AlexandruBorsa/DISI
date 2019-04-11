package com.disi.trainer.BusinessLogic;

import com.disi.trainer.DataAccess.Trainer;
import com.disi.trainer.DataAccess.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.util.Password;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainerService {

    @Autowired
    public TrainerRepository trainerRepository;

    public List<Trainer> getAllTrainers(){
        List<Trainer> trainers = new ArrayList<>();
        trainerRepository.findAll().forEach (trainers::add);
        return trainers;
    }

    public Trainer getTrainerByUsernameAndPassword(String username, String password){
        Trainer trainer = trainerRepository.findByUsernameAndPassword(username, password);
        return trainer;
    }


}
