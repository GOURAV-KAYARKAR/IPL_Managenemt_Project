package com.jbk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.model.Player;
import com.jbk.service.PlayerService;

@RestController
public class PlayerController {

	@Autowired
	private PlayerService playerService;

	@PostMapping("/api/players")
	public String addPlayer(@RequestBody Player player) {
		String msg = playerService.addPlayer(player);
		return msg;
	}
//---------------------------------------------------------
	@GetMapping("/api/players")
	public Object getAllPlayers() {
		List<Player> listPlayer = playerService.getAllPlayers();
		if (listPlayer != null) {
			return listPlayer;
		} else {
			return "No Players Available";
		}
	}
//---------------------------------------------------------
		@GetMapping( "/api/player/{playerId}")
	public Player getPlayerById(@PathVariable("playerId") int playerId) {
			Player playerById = playerService.getPlayerById(playerId);
			return playerById;	
		}
//----------------------------------------------------------------
		@PutMapping("/api/player/{Id}")
		public Object updatePlayerById(@PathVariable("Id") int Id , @RequestBody Player PlayerList) {
		Object updateplayerById = playerService.updateplayerById(Id, PlayerList);
			return updateplayerById;
		}
//------------------------------------------------------------------------
		@DeleteMapping("/api/Deleteplayer")
		public String deletPlayerById(@RequestParam int id) {
			
			String deletPlayerById = playerService.deletPlayerById(id);
			return deletPlayerById;
			
		}
}
