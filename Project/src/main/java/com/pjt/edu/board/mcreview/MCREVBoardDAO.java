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
	//�옄諛붾�� 紐⑤Ⅴ�땲源뚣뀪�뀪�뀪�뀪�뀪�뀪�뀪�뀪�뀪�뀪
	public int insertBoard(BoardVO vo) {
		session.insert ("newboard",vo);
		return 1;
	}

	@Override
	public int deleteBoard(BoardVO vo) {
		return session.delete("deletemcboard",vo);	
	}

	@Override
	public int updateBoard(BoardVO vo) {
		return session.update("updatemcrevboard", vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return session.selectOne("boardDetail",vo);
	}
	
	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return session.selectList("boardList");
	}
	public List<BoardVO> getBoardList5(String page){
		int count = Integer.valueOf(page);
		Map<String,Integer> row = new HashMap<String,Integer>();
		int start = 5*(count-1)+1;
		int end = 5*(count);
		row.put("start", start);
		row.put("end",end);
		System.out.println(start +","+end);
		System.out.println(session.selectList("selectfivemc", row));
		return session.selectList("selectfivemc", row);
	}
	public String rowcount() {
		return session.selectOne("pagecountmc");
	}

}
