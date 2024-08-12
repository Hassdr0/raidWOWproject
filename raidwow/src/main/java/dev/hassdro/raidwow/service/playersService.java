package dev.hassdro.raidwow.service;
import dev.hassdro.raidwow.model.players;
import dev.hassdro.raidwow.repository.playersRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public List<players> getAllPlayers() {

        return repository.findAll();
    }

    //Mostrar player por um ID
    public Optional<players> getPlayerById(Long id) {

        return repository.findById(id);
    }

    //Deletar player
    public void deletePlayerById(Long id) {
        repository.deleteById(id);
    }


    //Atualizar player
        public players updatePlayer(Long id, players player) {
            Optional<players> oldPlayerOptional = repository.findById(id);

            if (oldPlayerOptional.isPresent()) {
                players oldPlayer = oldPlayerOptional.get();

                // Atualize apenas os campos que não são nulos
                if (player.getName() != null) {
                    oldPlayer.setName(player.getName());
                }
                if (player.getSpec() != null) {
                    oldPlayer.setSpec(player.getSpec());
                }
                if (player.getGold() != 0) {
                    oldPlayer.setGold(player.getGold());
                }
                if (player.getRace() != null) {
                    oldPlayer.setRace(player.getRace());
                }
                if (player.getClasse() != null) {
                    oldPlayer.setClasse(player.getClasse());
                }

                // Salva o jogador atualizado
                return repository.save(oldPlayer);
            } else {
                throw new EntityNotFoundException("Player with id " + id + " not found");
            }
        }
    }


