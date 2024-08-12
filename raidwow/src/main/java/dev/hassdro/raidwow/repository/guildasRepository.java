package dev.hassdro.raidwow.repository;

import dev.hassdro.raidwow.model.guildas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface guildasRepository extends JpaRepository<guildas, Long> {
}
