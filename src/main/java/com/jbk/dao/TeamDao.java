package com.jbk.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jbk.model.Team;

@Component
public class TeamDao {

	List<Team> teams = new ArrayList<Team>();
	TeamDao(){
		
		  teams.add(new Team("MI", "Mumbai Indians", "Mumbai", "Mahela Jayawardene"));
	        teams.add(new Team("CSK", "Chennai Super Kings", "Chennai", "Stephen Fleming"));
		
	}
	

	public String addTeam(Team team) {
		teams.add(team);
		return "Team Added sussfully";
	}

	// -----------------------------------------
	public List<Team> getAllTeams() {

		return teams;
	}
//-------------------------------------------------

	public Team getTeamByid(String teamId) {

		for (Team team : teams) {
			if (team.getTeamId().equals(teamId)) {
				return team;
			}

		}
		return null;
	}
//-----------------------------------------------------------

	public Object updateTeamById(String id, Team teamList) {
		
		for (Team team : teams) {
			if (team.getTeamId().equals(id)) {
			int index = teams.indexOf(team);
			teams.set(index, teamList);
			
//			if (team.getTeamId().equals(id)) {
//				team.setTeamName(teamList.getTeamName());
//				team.setCity(teamList.getCity());
//				team.setCoach(teamList.getCoach());
			return teamList;
			}
			}
		return "Update Id not found";
	
		

		}
		
	
//------------------------------------------------------------------

	public String deletTeamById(String id) {
		for (Team team : teams) {
			if (team.getTeamId().equals(id)) {
				teams.remove(team);
			}
		}
		return "Team deleted Successfully";

	}
//-------------------------------------------------------------------
}
