package com.pjt.edu.board.sug;

import java.util.List;


public interface SUGDAO {

	public int insertBoard(SUGBoardVO vo);

	public int deleteBoard(SUGBoardVO vo);

	public int updateBoard(SUGBoardVO vo);

	public SUGBoardVO getBoard(SUGBoardVO vo);

	public List<SUGBoardVO> getBoardList(SUGBoardVO vo);
}