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
	
	
//	List<Team> teams = new ArrayList<Team>();
//	TeamDao(){
//		
//		  teams.add(new Team("MI", "Mumbai Indians", "Mumbai", "Mahela Jayawardene"));
//	        teams.add(new Team("CSK", "Chennai Super Kings", "Chennai", "Stephen Fleming"));
//		
//	}
	

	public String addTeam(Team team) {
		
		Session openSession = sessionFactory.openSession();
		openSession.save(team);
		return "Team Added Successuflly";
		
//		teams.add(team);
//		return "Team Added sussfully";
		}
//
// -----------------------------------------
	public List<Team> getAllTeams() {
		List<Team>list = null;
Session Session = sessionFactory.openSession();
Criteria criteria = Session.createCriteria(Team.class);		
 list = criteria.list();
 
 return list;
//		return teams;
	}
//-------------------------------------------------

	public Object getTeamByid(String teamId) {
		Session Session = sessionFactory.openSession();
Team DBTeam=Session.get(Team.class, teamId); 
try {
	if ( DBTeam !=null) {
		Session.beginTransaction().commit();
		return DBTeam;
		
	}else {
		return "Team Not Found ";
	}
} catch (Exception e) {
return "SOMETHING WENTS WRONG";
}
		
//		for (Team team : teams) {
//			if (team.getTeamId().equals(teamId)) {
//				return team;
//			}
//
//		}
//		return null;
	}
//-----------------------------------------------------------

	public Object updateTeamById(String id, Team teamList) {
		Session Session = sessionFactory.openSession();
		
		Team DBTeam=Session.get(Team.class, id); 
		try {
			if (DBTeam != null) {
				Session.saveOrUpdate(id, teamList);
				Session.beginTransaction().commit();
				
				return DBTeam; 
			}else return "Team Not Updated";
			
		} catch (Exception e) {
			return "SOMETHING WENTS WRONG";
			// TODO: handle exception
		}
		
//		for (Team team : teams) {
//			if (team.getTeamId().equals(id)) {
//			int index = teams.indexOf(team);
//			teams.set(index, teamList);
//			
////			if (team.getTeamId().equals(id)) {
////				team.setTeamName(teamList.getTeamName());
////				team.setCity(teamList.getCity());
////				team.setCoach(teamList.getCoach());
//			return teamList;
//			}
//			}
//		return "Update Id not found";
		}
		
	
//------------------------------------------------------------------

	public String deletTeamById(String id) {
		Session openSession = sessionFactory.openSession();
		Team DBteam = openSession.get(Team.class, id);
		try {
			if (DBteam !=null) {
				openSession.remove(DBteam);
				return"Team deleted successfully";
			} else {
				return " Team Not Found";
			}
		} catch (Exception e) {
			return "SOMETHING WENTS WRONG";
			// TODO: handle exception
		}
		
		
//		for (Team team : teams) {
//			if (team.getTeamId().equals(id)) {
//				teams.remove(team);
//			}
//		}
//		return "Team deleted Successfully";

	}
//-------------------------------------------------------------------
}
