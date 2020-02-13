package com.pjt.edu.board.review;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pjt.edu.board.BoardVO;
import com.pjt.edu.board.DAO;

@Repository("revdao")
public class REVDAO implements DAO {
	
	@Autowired
	SqlSession session;
	

	@Override
	public int insertBoard(BoardVO vo) {
		session.insert("newrevboard",vo);
		
		return 1;
	}

	@Override
	public int deleteBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return session.selectList("allrev");
	}
	


}
