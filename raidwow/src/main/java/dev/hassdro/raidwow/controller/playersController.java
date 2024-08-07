package dev.hassdro.raidwow.controller;

import dev.hassdro.raidwow.model.players;
import dev.hassdro.raidwow.service.playersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/players")


public class playersController {

    @Autowired
    private playersService service;

    /*localhost:8080/api/players*/

    //POST
    @PostMapping("/add")
    public ResponseEntity<players> addPlayers(@RequestBody players player){
        players newPlayer = service.createPlayer(player);
        return new ResponseEntity<>(newPlayer, HttpStatus.CREATED);
    }

    //GET ALL
    @GetMapping("/all")
    public ResponseEntity<List<players>> getAllPlayers(){
        List<players> allNinjas = service.getAllPlayers();
        return new ResponseEntity<>(allNinjas, HttpStatus.OK);
    }


    //GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<players> getPlayerById(@PathVariable Long id) {
        Optional<players> player = service.getPlayerById(id);
        return player.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //DELETE
    /* TODO: Usar um option para tratar casos em que o id seja inserido errado*/

    @DeleteMapping("delete/{id}")
    public void deletePlayer(@PathVariable Long id){
        service.deletePlayerById(id);

    }
}