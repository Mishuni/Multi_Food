package com.pjt.edu.board.review;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pjt.edu.board.BoardVO;
import com.pjt.edu.board.DAO;

@Repository("revdao")
public class REVDAO implements DAO {
	
	@Autowired
	SqlSession session;
	
	//글 삽입
	@Override
	public int insertBoard(BoardVO vo) {
		session.insert("newrevboard",vo);
		
		return 1;
	}
	//글 삭제
	@Override
	public int deleteBoard(BoardVO vo) {
		return session.delete("deleterevboard",vo);
	}
	//글 수정
	@Override
	public int updateBoard(BoardVO vo) {
		System.out.println(vo);
		return session.update("updaterevboard", vo);
	}
	//detail select return
	@Override
	public BoardVO getBoard(BoardVO vo) {
		vo=session.selectOne("getonerev", vo);
		session.update("countup", vo);
		return session.selectOne("getonerev", vo);
	}
	//paging 처리
	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return session.selectList("allrev");
	}
	//seq 높은순으로 5개씩 출력
	public List<BoardVO> getBoardList5(String page){
		int count = Integer.valueOf(page);
		Map<String,Integer> row = new HashMap<String,Integer>();
		int start = 5*(count-1)+1;
		int end = 5*(count);
		row.put("start", start);
		row.put("end",end);
		System.out.println(start +","+end);
		System.out.println(session.selectList("selectfive", row));
		return session.selectList("selectfive", row);
	}
	//총 글갯수 return
	public String rowcount() {
		return session.selectOne("pagecount");
	}
	//title로 검색한 글 return
	public List<BoardVO> titleList(String title){
		return session.selectList("revonebytitle",title);
	}
	//writer 로 검색한 글 return
	public List<BoardVO> writerList(String writer){
		return session.selectList("revonebywriter",writer);
	}
	
	

}
