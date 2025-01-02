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

	public String addPlayer(Player player) {
		Session openSession = sessionFactory.openSession();
		openSession.save(player);
		return "Player Added Successuflly";

	}

	// -----------------------------------------
	public List<Player> getAllPlayers() {
		List<Player> list = null;
		Session Session = sessionFactory.openSession();
		Criteria criteria = Session.createCriteria(Player.class);
		list = criteria.list();

		return list;

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

	}
//-------------------------------------------------------------------
}
