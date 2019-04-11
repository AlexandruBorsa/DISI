package com.disi.trainer.Controllers;


import com.disi.trainer.BusinessLogic.TrainerService;
import com.disi.trainer.DataAccess.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
public class TrainerController {

    @Autowired
    private TrainerService trainerService;


    @PostMapping("/login")
    public String getTrainer(String username, String password){
        if(!trainerService.getTrainerByUsernameAndPassword(username, password).getUsername().isEmpty())
            return "200";
        else return "404";
    }

}
