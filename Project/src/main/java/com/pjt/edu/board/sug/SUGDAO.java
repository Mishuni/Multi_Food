package com.pjt.edu.board.sug;

import java.util.List;

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
		return 0;
	}

	@Override
	public int deleteBoard(BoardVO vo) {
		return 0;
	}

	@Override
	public int updateBoard(BoardVO vo) {
		
		return 0;
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

}