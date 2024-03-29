package org.tse.teamTse.services;

import org.tse.teamTse.models.Player;
import org.tse.teamTse.models.Team;

import java.util.List;

public interface TeamService {
    public List<Team> findAllTeams();

    public Team findTeam(Long id);

    public Team createTeam(Team team);

    public void deleteTeam(Long id);

    public Team saveTeam(Team foundTeam);
}
