package com.pjt.edu.board.mcreview;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pjt.edu.board.BoardVO;
import com.pjt.edu.board.DAO;

@Repository("mcrevdao")
public class MCREVBoardDAO implements DAO {
	
	@Autowired
	SqlSession session;
	
	@Override
	//글 삽입
	public int insertBoard(BoardVO vo) {
		session.insert ("newboard",vo);
		return 1;
	}
	//글 삭제
	@Override
	public int deleteBoard(BoardVO vo) {
		return session.delete("deletemcboard",vo);	
	}
	//글 수정
	@Override
	public int updateBoard(BoardVO vo) {
		return session.update("updatemcrevboard", vo);
	}
	//detail select return
	@Override
	public BoardVO getBoard(BoardVO vo) {
		vo=session.selectOne("boardDetail", vo);
		session.update("mccountup", vo);
		return session.selectOne("boardDetail",vo);
	}
	//paging 처리
	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return session.selectList("boardList");
	}
	//seq 높은순으로 5개씩 출력
	public List<BoardVO> getBoardList5(String page){
		int count = Integer.valueOf(page);
		Map<String,Integer> row = new HashMap<String,Integer>();
		int start = 5*(count-1)+1;
		int end = 5*(count);
		row.put("start", start);
		row.put("end",end);
		return session.selectList("selectfivemc", row);
	}
	//총 글갯수 return
	public String rowcount() {
		return session.selectOne("pagecountmc");
	}
	//title로 검색한 글 return
	public List<BoardVO> titleList(String title){
		return session.selectList("mconebytitle",title);
	}
	//writer 로 검색한 글 return
	public List<BoardVO> writerList(String writer){
		return session.selectList("mconebywriter",writer);
	}

}
