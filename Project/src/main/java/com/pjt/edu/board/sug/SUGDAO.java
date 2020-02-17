package com.pjt.edu.board.sug;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pjt.edu.board.BoardVO;
import com.pjt.edu.board.DAO;

@Repository
public class SUGDAO implements DAO {

	@Autowired
	private SqlSession session;

	public void setSession(SqlSession session) {
		this.session = session;
	}

	@Override
	public int insertBoard(BoardVO vo) {
		session.insert("newsugboard", vo);

		return 1;
	}

	@Override
	public int deleteBoard(BoardVO vo) {
		return session.delete("deletesugboard",vo);
	}

	@Override
	public int updateBoard(BoardVO vo) {

		return session.update("updatesugboard", vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return session.selectOne("getoneboard", vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return session.selectList("getboardlist");
	}

	public void upViewCount(BoardVO vo) {
		session.update("upviewcount", vo);
	}
	public List<BoardVO> getBoardList5(String page){
		int count = Integer.valueOf(page);
		Map<String,Integer> row = new HashMap<String,Integer>();
		int start = 5*(count-1)+1;
		int end = 5*(count);
		row.put("start", start);
		row.put("end",end);
		System.out.println(start +","+end);
		System.out.println(session.selectList("selectfivesug", row));
		return session.selectList("selectfivesug", row);
	}
	public String rowcount() {
		return session.selectOne("pagecountsug");
	}
	

}