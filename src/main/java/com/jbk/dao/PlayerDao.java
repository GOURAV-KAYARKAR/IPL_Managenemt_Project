package com.jbk.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.model.Player;

@Repository
public class PlayerDao {
	@Autowired
	private SessionFactory sessionFactory;

//	List<Player> players = new ArrayList<Player>();
//	 public PlayerDao() {
//	        // Adding the given player data to the players list
//	        players.add(new Player(1, "Rohit Sharma", 33, "MI", "Batsman"));
//	        players.add(new Player(2, "MS Dhoni", 39, "CSK", "Wicketkeeper-Batsman"));
//	    }

	public String addPlayer(Player player) {
		Session openSession = sessionFactory.openSession();
		openSession.save(player);
		return "Player Added Successuflly";

		// players.add(player);
//		return "Player Added sussfully";
	}

	// -----------------------------------------
	public List<Player> getAllPlayers() {
		List<Player> list = null;
		Session Session = sessionFactory.openSession();
		Criteria criteria = Session.createCriteria(Player.class);
		list = criteria.list();

		return list;
//		return players;
	}
//-------------------------------------------------

	public Object getPlayerByid(int playerId) {
		Session Session = sessionFactory.openSession();
		Player DBPlayer = Session.get(Player.class, playerId);
		try {
			if (DBPlayer != null) {
				Session.beginTransaction().commit();
				return DBPlayer;

			} else {
				return "Player Not Found ";
			}
		} catch (Exception e) {
			return "SOMETHING WENTS WRONG";

//		for (Player player : players) {
//			if (player.getPlayerId() == playerId) {
//				return player;
//			}
//
//		}
//		return null;
		}
	}
//-----------------------------------------------------------

	public Object updatePlayerById(int id, Player player) {

		Session Session = sessionFactory.openSession();

		Player DBPlayer = Session.get(Player.class, id);
		try {
			if (DBPlayer != null) {
				Session.saveOrUpdate(DBPlayer);
				;
				Session.beginTransaction().commit();

				return DBPlayer;
			} else
				return "Player Not Updated";

		} catch (Exception e) {
			return "SOMETHING WENTS WRONG";
			// TODO: handle exception
		}

//		for (Player player : players) {
//			if (player.getPlayerId() == id) {
//				int index = players.indexOf(player);
//				players.set(index, playerList);
//
////			if (player.getPlayerId().equals(id)) {
////				player.setPlayerName(playerList.getPlayerName());
////				player.setCity(playerList.getCity());
////				player.setCoach(playerList.getCoach());
//				return playerList;
//			}
//		}
//		return "Update Id not found";

	}

//------------------------------------------------------------------

	public String deletPlayerById(int id) {
		Session openSession = sessionFactory.openSession();
		Player DBPlayer = openSession.get(Player.class, id);
		try {
			if (DBPlayer != null) {
				openSession.remove(DBPlayer);
				return "Player deleted successfully";
			} else {
				return " Player Not Found";
			}
		} catch (Exception e) {
			return "SOMETHING WENTS WRONG";
			// TODO: handle exception
		}

//		for (Player player : players) {
//			if (player.getPlayerId() == id) {
//				players.remove(player);
//			}
//		}
//		return "Player deleted Successfully";

	}
//-------------------------------------------------------------------
}
