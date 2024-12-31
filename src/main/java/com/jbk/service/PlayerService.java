package com.jbk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.PlayerDao;
import com.jbk.model.Player;

@Service
public class PlayerService {
	@Autowired
	private PlayerDao playerDao;

	public String addPlayer(Player player) {

		String msg = playerDao.addPlayer(player);

		return msg;
		// TODO Auto-generated method stub

	}

//----------------------------------------------------------
	public List<Player> getAllPlayers() {
		List<Player> listPlayer = playerDao.getAllPlayers();
		return listPlayer;
	}

//-------------------------------------------------------------
	public Object getPlayerById(int playerId) {
		Object getplayerByid = playerDao.getPlayerByid(playerId);
		return getplayerByid;

	}
//-------------------------------------------------------------

	public Object updateplayerById(int id, Player playerList) {
		return playerDao.updatePlayerById(id, playerList);
	}

//----------------------------------------------------------
	public String deletPlayerById(int id) {
		String deletPlayerById = playerDao.deletPlayerById(id);
		return deletPlayerById;

	}

}
