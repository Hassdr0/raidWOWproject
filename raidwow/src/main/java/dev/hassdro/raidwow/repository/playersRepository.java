
package dev.hassdro.raidwow.repository;
import dev.hassdro.raidwow.model.players;
import org.springframework.data.jpa.repository.JpaRepository;

public interface playersRepository extends JpaRepository <players, Long> {


}