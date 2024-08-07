package dev.hassdro.raidwow.service;
import dev.hassdro.raidwow.model.players;
import dev.hassdro.raidwow.repository.playersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.Optional;

@Service

public class playersService {

    @Autowired

    /*TODO: Refatorar a instancia*/
    private playersRepository repository;


    //Criar um novo player, e insere no db

    public players createPlayer(players player) {

        return repository.save(player);
    }

//Mostrar players criados, e retorna em uma lista

    public List<players> getAllPlayers(){
        return repository.findAll();
    }

//Mostrar player por um ID
public Optional<players> getPlayerById(Long id) {
    return repository.findById(id);
}

//Deletar player
public void deletePlayerById(Long id){
        repository.deleteById(id);
}


//Atualizar player


}