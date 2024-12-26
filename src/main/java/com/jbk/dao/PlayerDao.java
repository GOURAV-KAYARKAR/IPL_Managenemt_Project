package com.jbk.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jbk.model.Player;

@Component
public class PlayerDao {

	List<Player> players = new ArrayList<Player>();
	 public PlayerDao() {
	        // Adding the given player data to the players list
	        players.add(new Player(1, "Rohit Sharma", 33, "MI", "Batsman"));
	        players.add(new Player(2, "MS Dhoni", 39, "CSK", "Wicketkeeper-Batsman"));
	    }
	

	public String addPlayer(Player player) {
		players.add(player);
		return "Player Added sussfully";
	}

	// -----------------------------------------
	public List<Player> getAllPlayers() {

		return players;
	}
//-------------------------------------------------

	public Player getPlayerByid(int playerId) {

		for (Player player : players) {
			if (player.getPlayerId() ==playerId) {
				return player;
			}

		}
		return null;
	}
//-----------------------------------------------------------

	public Object updatePlayerById(int id, Player playerList) {
		
		for (Player player : players) {
			if (player.getPlayerId() ==id) {
			int index = players.indexOf(player);
			players.set(index, playerList);
			
//			if (player.getPlayerId().equals(id)) {
//				player.setPlayerName(playerList.getPlayerName());
//				player.setCity(playerList.getCity());
//				player.setCoach(playerList.getCoach());
			return playerList;
			}
			}
		return "Update Id not found";
	
		

		}
		
	
//------------------------------------------------------------------

	public String deletPlayerById(int id) {
		for (Player player : players) {
			if (player.getPlayerId() == id) {
				players.remove(player);
			}
		}
		return "Player deleted Successfully";

	}
//-------------------------------------------------------------------
}
