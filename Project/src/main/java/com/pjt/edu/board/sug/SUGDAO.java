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
	//글 삽입
	@Override
	public int insertBoard(BoardVO vo) {
		session.insert("newsugboard", vo);

		return 1;
	}
	//글 삭제
	@Override
	public int deleteBoard(BoardVO vo) {
		return session.delete("deletesugboard",vo);
	}
	//글 수정
	@Override
	public int updateBoard(BoardVO vo) {

		return session.update("updatesugboard", vo);
	}
	//deatil select return
	@Override
	public BoardVO getBoard(BoardVO vo) {
		vo=session.selectOne("getoneboard", vo);
		session.update("countupsug", vo);
		return session.selectOne("getoneboard", vo);
	}
	
	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return session.selectList("getboardlist");
	}

	public void upViewCount(BoardVO vo) {
		session.update("upviewcount", vo);
	}
	//seq 높은순으로 5개씩 출력
	public List<BoardVO> getBoardList5(String page){
		int count = Integer.valueOf(page);
		Map<String,Integer> row = new HashMap<String,Integer>();
		int start = 5*(count-1)+1;
		int end = 5*(count);
		row.put("start", start);
		row.put("end",end);
		//System.out.println(start +","+end);
		//System.out.println(session.selectList("selectfivesug", row));
		return session.selectList("selectfivesug", row);
	}
	//총 글갯수 return
	public String rowcount() {
		return session.selectOne("pagecountsug");
	}
	//title로 검색한 글 return
	public List<BoardVO> titleList(String title){
		return session.selectList("sugonebytitle",title);
	}
	//writer 로 검색한 글 return
	public List<BoardVO> writerList(String writer){
		return session.selectList("sugonebywriter",writer);
	}
	

}