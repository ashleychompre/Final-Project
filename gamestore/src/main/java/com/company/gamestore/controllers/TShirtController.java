package com.company.gamestore.controllers;

import com.company.gamestore.models.Game;
import com.company.gamestore.models.TShirt;
import com.company.gamestore.repository.TShirtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
public class TShirtController {

    @Autowired
    TShirtRepository repo;

    @GetMapping("/tshirt/{id}")
    public TShirt getTshirtbyID(@PathVariable int id) {

        Optional<TShirt> returnVal = repo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }


    @PutMapping("/tshirt")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTshirt(@RequestBody TShirt tshirt) {
        repo.save(tshirt);
    }

    @PostMapping("/tshirt")
    @ResponseStatus(HttpStatus.CREATED)
    public TShirt addTshirt(@RequestBody TShirt tshirt) {
        return repo.save(tshirt);
    }

    @DeleteMapping("/tshirt/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTShirt(@PathVariable int id){
        repo.deleteById(id);
    }



}
