package org.tse.teamTse.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Player {
    @Id @GeneratedValue
    private Long id;
    private String name;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "team_id")
//    private Team team;


}
