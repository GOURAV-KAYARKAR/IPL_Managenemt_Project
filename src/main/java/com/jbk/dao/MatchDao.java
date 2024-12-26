package com.jbk.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jbk.model.Match;

@Repository
public class MatchDao {

	List<Match> matchs = new ArrayList<Match>();
	 public MatchDao() {
	       matchs.add(new Match(1, "MI", "CSK", "2024-05-01", "Wankhede Stadium", "Mumbai Indians won"));
	       
	    }
	

	public String addMatch(Match match) {
		matchs.add(match);
		return "Match Added sussfully";
	}

	// -----------------------------------------
	public List<Match> getAllMatchs() {

		return matchs;
	}
//-------------------------------------------------

	public Match getMatchByid(int matchId) {

		for (Match match : matchs) {
			if (match.getMatchId() ==matchId) {
				return match;
			}

		}
		return null;
	}
//-----------------------------------------------------------

	public Object updateMatchById(int id, Match matchList) {
		
		for (Match match : matchs) {
			if (match.getMatchId() ==id) {
			int index = matchs.indexOf(match);
			matchs.set(index, matchList);
			
//			if (match.getMatchId().equals(id)) {
//				match.setMatchName(matchList.getMatchName());
//				match.setCity(matchList.getCity());
//				match.setCoach(matchList.getCoach());
			return matchList;
			}
			}
		return "Update Id not found";
	
		

		}
		
	
//------------------------------------------------------------------

	public String deletMatchById(int id) {
		for (Match match : matchs) {
			if (match.getMatchId() == id) {
				matchs.remove(match);
			}
		}
		return "Match deleted Successfully";

	}
//-------------------------------------------------------------------
}
