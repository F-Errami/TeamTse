package org.tse.teamTse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tse.teamTse.models.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
