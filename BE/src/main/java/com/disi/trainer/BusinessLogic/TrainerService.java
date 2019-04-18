package com.disi.trainer.BusinessLogic;

import com.disi.trainer.DataAccess.Trainer;
import com.disi.trainer.DataAccess.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TrainerService {

    @Autowired
    private TrainerRepository trainerRepository;

    public List<Trainer> getAllTrainers() {

        List<Trainer> trainers = new ArrayList<>();

        trainerRepository.findAll()
                .forEach(trainers::add);

        return trainers;

    }

    public Optional<Trainer> getTrainer(Long id){
        return trainerRepository.findById(id);
    }

    public void addTrainer(Trainer trainer) {
        trainerRepository.save(trainer);
    }
}
