package org.tse.teamTse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.tse.teamTse.models.Player;
import org.tse.teamTse.services.PlayerService;

import java.util.List;

@RestController
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping("/players")
    public List<Player> allPlayers() {

        return this.playerService.findAllPlayers();
    }

    @GetMapping("/players/{id}")
    public Player onePlayer(@PathVariable Long id) throws ResourceNotFoundException {

        Player result = this.playerService.findPlayer(id);

        if (result != null) {

            return result;
        }
        else {
            throw new ResourceNotFoundException();
        }
    }

    @PostMapping("/players")
    public Player createPlayer(@RequestBody Player player) {

        return this.playerService.createPlayer(player);
    }

    @DeleteMapping("/players/{id}")
    public void deletePlayer(@PathVariable Long id) {

        this.playerService.deletePlayer(id);
    }

    @PutMapping("/players/{id}")
    Player replacePlayer(@RequestBody Player player, @PathVariable Long id) {

        Player foundPlayer = this.playerService.findPlayer(id);

        if (player != null) {

            foundPlayer.setName(player.getName());

            foundPlayer = this.playerService.savePlayer(foundPlayer);
        }

        return foundPlayer;
    }
}
