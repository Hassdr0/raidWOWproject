package dev.hassdro.raidwow.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "players")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class players {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long id;


    String classe;
    String race;
    String name;
    String spec;
    int gold;


}
