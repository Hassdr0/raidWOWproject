package dev.hassdro.raidwow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name= "guilds")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class guildas {
    @Id
    Long id;
    String name;
    String region;
    int totalPlayers;

}