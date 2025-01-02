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

import com.jbk.model.Team;
import com.jbk.service.TeamService;

@RestController
public class TeamController {

	@Autowired
	private TeamService teamservice;

	@PostMapping("/api/teams")
	public String addTeam(@RequestBody Team team) {
		String msg = teamservice.addTeam(team);
		return msg;
	}

//---------------------------------------------------------
	@GetMapping("/api/teams")
	public Object getAllTeams() {
		List<Team> listTeam = teamservice.getAllTeams();
		if (listTeam != null) {
			return listTeam;
		} else {
			return "No Teams Available";
		}
	}

//---------------------------------------------------------
	@GetMapping("/api/team/{teamId}")
	public Object getTeamById(@PathVariable("teamId") String teamId) {
		Object teamById = teamservice.getTeamById(teamId);
		return teamById;
	}

//----------------------------------------------------------------
	@PutMapping("/api/team/{Id}")
	public Object updateTeamById(@PathVariable("Id") String Id, @RequestBody Team TeamList) {
		Object updateteamById = teamservice.updateteamById(Id, TeamList);
		return updateteamById;
	}

//------------------------------------------------------------------------
	@DeleteMapping("/api/Deleteteam")
	public String deletTeamById(@RequestParam String id) {

		String deletTeamById = teamservice.deletTeamById(id);
		return deletTeamById;

	}
}
