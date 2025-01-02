package com.jbk.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.model.Team;

@Repository
public class TeamDao {

	@Autowired
	private SessionFactory sessionFactory;

	public String addTeam(Team team) {

		Session openSession = sessionFactory.openSession();
		openSession.save(team);
		return "Team Added Successuflly";

	}

// -----------------------------------------
	public List<Team> getAllTeams() {
		List<Team> list = null;
		Session Session = sessionFactory.openSession();
		Criteria criteria = Session.createCriteria(Team.class);
		list = criteria.list();

		return list;

	}
//-------------------------------------------------

	public Object getTeamByid(String teamId) {
		Session Session = sessionFactory.openSession();
		Team DBTeam = Session.get(Team.class, teamId);
		try {
			if (DBTeam != null) {
				Session.beginTransaction().commit();
				return DBTeam;

			} else {
				return "Team Not Found ";
			}
		} catch (Exception e) {
			return "SOMETHING WENTS WRONG";
		}

	}
//-----------------------------------------------------------

	public Object updateTeamById(String id, Team teamList) {
		Session Session = sessionFactory.openSession();

		Team DBTeam = Session.get(Team.class, id);
		try {
			if (DBTeam != null) {
				Session.saveOrUpdate(id, teamList);
				Session.beginTransaction().commit();

				return DBTeam;
			} else
				return "Team Not Updated";

		} catch (Exception e) {
			return "SOMETHING WENTS WRONG";
			// TODO: handle exception
		}

	}

//------------------------------------------------------------------

	public String deletTeamById(String id) {
		Session openSession = sessionFactory.openSession();
		Team DBteam = openSession.get(Team.class, id);
		try {
			if (DBteam != null) {
				openSession.remove(DBteam);
				return "Team deleted successfully";
			} else {
				return " Team Not Found";
			}
		} catch (Exception e) {
			return "SOMETHING WENTS WRONG";
			// TODO: handle exception
		}

	}
//-------------------------------------------------------------------
}
