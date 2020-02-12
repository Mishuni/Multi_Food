package com.pjt.edu.board.review;

import java.util.List;


public interface REVDAO {

	public int insertBoard(REVBoardVO vo);

	public int deleteBoard(REVBoardVO vo);

	public int updateBoard(REVBoardVO vo);

	public REVBoardVO getBoard(REVBoardVO vo);

	public List<REVBoardVO> getBoardList(REVBoardVO vo);
}