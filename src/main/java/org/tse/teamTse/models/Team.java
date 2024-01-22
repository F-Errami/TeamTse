package org.tse.teamTse.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Team {
    @Id @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Player> players;
}
