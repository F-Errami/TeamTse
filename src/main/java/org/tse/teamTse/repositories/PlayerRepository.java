package org.tse.teamTse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tse.teamTse.models.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
