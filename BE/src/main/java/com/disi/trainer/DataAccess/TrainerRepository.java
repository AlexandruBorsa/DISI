package com.disi.trainer.DataAccess;

import org.springframework.data.repository.CrudRepository;


public interface TrainerRepository extends CrudRepository<Trainer, Integer> {
    Trainer findByUsernameAndPassword(String username, String password);
}