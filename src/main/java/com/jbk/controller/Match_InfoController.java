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

import com.jbk.model.Match_Info;
import com.jbk.service.Match_InfoService;

@RestController
public class Match_InfoController {

	@Autowired
	private Match_InfoService matchService;

	@PostMapping("/api/matchs")
	public String addMatch(@RequestBody Match_Info match) {
		String msg = matchService.addMatch_Info(match);
		return msg;
	}

//-----------------------------------------------------------------
	@GetMapping("/api/matchs")
	public Object getAllMatchs() {
		List<Match_Info> listMatch = matchService.getAllMatch_Infos();
		if (listMatch != null) {
			return listMatch;
		} else {
			return "No Matchs Available";
		}
	}

//---------------------------------------------------------
	@GetMapping("/api/match/{matchId}")
	public Object getMatchById(@PathVariable("matchId") int matchId) {
		Object matchById = matchService.getMatch_InfoById(matchId);
		return matchById;
	}

//----------------------------------------------------------------
	@PutMapping("/api/match/{Id}")
	public Object updateMatchById(@PathVariable("Id") int Id, @RequestBody Match_Info MatchList) {
		Object updatematchById = matchService.updatematch_infoById(Id, MatchList);
		return updatematchById;
	}

//------------------------------------------------------------------------
	@DeleteMapping("/api/Deletematch")
	public String deletMatchById(@RequestParam int id) {

		String deletMatchById = matchService.deletMatch_InfoById(id);
		return deletMatchById;

	}
}
