package com.jbk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.TeamDao;
import com.jbk.model.Team;

@Service
public class TeamService {
	@Autowired
	private TeamDao teamDao;

	public String addTeam(Team team) {

		String msg = teamDao.addTeam(team);

		return msg;
		// TODO Auto-generated method stub

	}

//----------------------------------------------------------
	public List<Team> getAllTeams() {
		List<Team> listTeam = teamDao.getAllTeams();
		return listTeam;
	}

//-------------------------------------------------------------
	public Object getTeamById(String teamId) {
		Object getteamByid = teamDao.getTeamByid(teamId);
		return getteamByid;

	}
//-------------------------------------------------------------

	public Object updateteamById(String id, Team teamList) {
		return teamDao.updateTeamById(id, teamList);
	}

//----------------------------------------------------------
	public String deletTeamById(String id) {
		String deletTeamById = teamDao.deletTeamById(id);
		return deletTeamById;

	}

}
