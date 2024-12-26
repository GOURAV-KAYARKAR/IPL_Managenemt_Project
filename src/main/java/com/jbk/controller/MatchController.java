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

import com.jbk.model.Match;
import com.jbk.service.MatchService;

@RestController
public class MatchController {

	@Autowired
	private MatchService matchService;

	@PostMapping("/api/matchs")
	public String addMatch(@RequestBody Match match) {
		String msg = matchService.addMatch(match);
		return msg;
	}
//---------------------------------------------------------
	@GetMapping("/api/matchs")
	public Object getAllMatchs() {
		List<Match> listMatch = matchService.getAllMatchs();
		if (listMatch != null) {
			return listMatch;
		} else {
			return "No Matchs Available";
		}
	}
//---------------------------------------------------------
		@GetMapping( "/api/match/{matchId}")
	public Match getMatchById(@PathVariable("matchId") int matchId) {
			Match matchById = matchService.getMatchById(matchId);
			return matchById;	
		}
//----------------------------------------------------------------
		@PutMapping("/api/match/{Id}")
		public Object updateMatchById(@PathVariable("Id") int Id , @RequestBody Match MatchList) {
		Object updatematchById = matchService.updatematchById(Id, MatchList);
			return updatematchById;
		}
//------------------------------------------------------------------------
		@DeleteMapping("/api/Deletematch")
		public String deletMatchById(@RequestParam int id) {
			
			String deletMatchById = matchService.deletMatchById(id);
			return deletMatchById;
			
		}
}
