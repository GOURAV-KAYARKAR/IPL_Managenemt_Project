package com.jbk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.MatchDao;
import com.jbk.model.Match;

@Service
public class MatchService {
	@Autowired
	private MatchDao matchDao;

	public String addMatch(Match match) {

		String msg = matchDao.addMatch(match);

		return msg;
		// TODO Auto-generated method stub

	}

//----------------------------------------------------------
	public List<Match> getAllMatchs() {
		List<Match> listMatch = matchDao.getAllMatchs();
		return listMatch;
	}

//-------------------------------------------------------------
	public Match getMatchById(int matchId) {
		Match getmatchByid = matchDao.getMatchByid(matchId);
		return getmatchByid;

	}
//-------------------------------------------------------------

	public Object updatematchById(int id, Match matchList) {
		return matchDao.updateMatchById(id, matchList);
	}

//----------------------------------------------------------
	public String deletMatchById(int id) {
		String deletMatchById = matchDao.deletMatchById(id);
		return deletMatchById;

	}

}
