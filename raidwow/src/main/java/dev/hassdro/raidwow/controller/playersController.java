package dev.hassdro.raidwow.controller;

import dev.hassdro.raidwow.model.players;
import dev.hassdro.raidwow.service.playersService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/players")


public class playersController {

    @Autowired
    private playersService service;
    @Autowired
    private dev.hassdro.raidwow.repository.playersRepository playersRepository;

    /*localhost:8080/api/players*/

    //POST
    @PostMapping("/add")
    public ResponseEntity<?> addPlayers(@RequestBody players player) {
        try {
            players newPlayer = service.createPlayer(player);
            return new ResponseEntity<>(newPlayer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
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
    public ResponseEntity<players> deletePlayer(@PathVariable Long id){

        Optional<players> playerOptional = service.getPlayerById(id);

        if (playerOptional.isPresent()) {
            players player = playerOptional.get();
            service.deletePlayerById(id);
            return ResponseEntity.ok(player);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }


    //UPDATE PUT METHOD
    @PutMapping ("/update/{id}")
    public ResponseEntity<players> updatePlayer(@PathVariable Long id, @RequestBody players player) {
        try {
            players updatedPlayer = service.updatePlayer(id, player);
            return new ResponseEntity<>(updatedPlayer, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    }
