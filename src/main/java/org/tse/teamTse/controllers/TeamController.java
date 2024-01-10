package org.tse.teamTse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.tse.teamTse.models.Team;
import org.tse.teamTse.services.TeamService;

import java.util.List;

@RestController
public class TeamController {
    @Autowired
    private TeamService teamService;

    @GetMapping("/teams")
    public List<Team> allTeams() {

        return this.teamService.findAllTeams();
    }

    @GetMapping("/teams/{id}")
    public Team oneTeam(@PathVariable Long id) throws ResourceNotFoundException {

        Team result = this.teamService.findTeam(id);

        if (result != null) {

            return result;
        }
        else {
            throw new ResourceNotFoundException();
        }
    }

    @PostMapping("/teams")
    public Team createTeam(@RequestBody Team team) {

        return this.teamService.createTeam(team);
    }

    @DeleteMapping("/teams/{id}")
    public void deleteTeam(@PathVariable Long id) {

        this.teamService.deleteTeam(id);
    }

    @PutMapping("/teams/{id}")
    Team replaceTeam(@RequestBody Team team, @PathVariable Long id) {

        Team foundTeam = this.teamService.findTeam(id);

        if (team != null) {

            foundTeam.setName(team.getName());

            foundTeam = this.teamService.saveTeam(foundTeam);
        }

        return foundTeam;
    }
}
