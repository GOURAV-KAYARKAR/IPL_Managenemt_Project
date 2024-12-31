package com.jbk.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.model.Match_Info;

@Repository
public class Match_InfoDao {

	@Autowired
	private SessionFactory sessionFactory;

//	List<Match_Info> matchs = new ArrayList<Match_Info>();
//
//	public Match_InfoDao() {
//		matchs.add(new Match_Info(1, "MI", "CSK", "2024-05-01", "Wankhede Stadium", "Mumbai Indians won"));
//
//	}

	public String addMatch_Info(Match_Info match) {
		Session openSession = sessionFactory.openSession();
		openSession.save(match);
		return "Match Added Successuflly";

//		matchs.add(match);
//		return "Match_Info Added sussfully";
	}

	// -----------------------------------------
	public List<Match_Info> getAllMatch_Infos() {
		List<Match_Info> list = null;
		Session Session = sessionFactory.openSession();
		Criteria criteria = Session.createCriteria(Match_Info.class);
		list = criteria.list();

		return list;
//		return matchs;
	}
//-------------------------------------------------

	public Object getMatch_InfoByid(int matchId) {
		Session Session = sessionFactory.openSession();
		Match_Info DBMatch_Info = Session.get(Match_Info.class, matchId);
		try {
			if (DBMatch_Info != null) {
				Session.beginTransaction().commit();
				return DBMatch_Info;

			} else {
				return "Match Not Found ";
			}
		} catch (Exception e) {
			return "SOMETHING WENTS WRONG";
		}
//		for (Match_Info match : matchs) {
//			if (match.getMatchId() == matchId) {
//				return match;
//			}
//
//		}
//		return null;
	}
//-----------------------------------------------------------

	public Object updateMatch_InfoById(int id, Match_Info matchList) {
		Session Session = sessionFactory.openSession();

		Match_Info DBMatch_Info = Session.get(Match_Info.class, id);
		try {
			if (DBMatch_Info != null) {
				Session.saveOrUpdate(id);
				Session.beginTransaction().commit();

				return DBMatch_Info;
			} else
				return "Match Not Updated";

		} catch (Exception e) {
			return "SOMETHING WENTS WRONG";
			// TODO: handle exception
		}

//		for (Match_Info match : matchs) {
//			if (match.getMatchId() == id) {
//				int index = matchs.indexOf(match);
//				matchs.set(index, matchList);
//
////			if (match.getMatch_InfoId().equals(id)) {
////				match.setMatch_InfoName(matchList.getMatch_InfoName());
////				match.setCity(matchList.getCity());
////				match.setCoach(matchList.getCoach());
//				return matchList;
//			}
//		}
//		return "Update Id not found";

	}

//------------------------------------------------------------------

	public String deletMatch_InfoById(int id) {
		Session openSession = sessionFactory.openSession();
		Match_Info DBMatch_Info = openSession.get(Match_Info.class, id);
		try {
			if (DBMatch_Info != null) {
				openSession.remove(DBMatch_Info);
				return "Match deleted successfully";
			} else {
				return " Match Not Found";
			}
		} catch (Exception e) {
			return "SOMETHING WENTS WRONG";
			// TODO: handle exception
		}

//		for (Match_Info match : matchs) {
//			if (match.getMatchId() == id) {
//				matchs.remove(match);
//			}
//		}
//		return "Match_Info deleted Successfully";

	}
//-------------------------------------------------------------------
}
