package com.jbk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.Match_InfoDao;
import com.jbk.dao.Match_InfoDao;
import com.jbk.model.Match_Info;

@Service
public class Match_InfoService {
	@Autowired
	private Match_InfoDao match_infoDao;

	public String addMatch_Info(Match_Info match_info) {

		String msg = match_infoDao.addMatch_Info(match_info);

		return msg;
		// TODO Auto-generated method stub

	}

//----------------------------------------------------------
	public List<Match_Info> getAllMatch_Infos() {
		List<Match_Info> listMatch_Info = match_infoDao.getAllMatch_Infos();
		return listMatch_Info;
	}

//-------------------------------------------------------------
	public Object getMatch_InfoById(int match_infoId) {
		Object getmatch_infoByid = match_infoDao.getMatch_InfoByid(match_infoId);
		return getmatch_infoByid;

	}
//-------------------------------------------------------------

	public Object updatematch_infoById(int id, Match_Info match_infoList) {
		return match_infoDao.updateMatch_InfoById(id, match_infoList);
	}

//----------------------------------------------------------
	public String deletMatch_InfoById(int id) {
		String deletMatch_InfoById = match_infoDao.deletMatch_InfoById(id);
		return deletMatch_InfoById;

	}

}
