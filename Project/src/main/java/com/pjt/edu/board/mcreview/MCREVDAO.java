package com.pjt.edu.board.mcreview;

import java.util.List;


public interface MCREVDAO {

	public int insertBoard(MCREVBoardVO vo);

	public int deleteBoard(MCREVBoardVO vo);

	public int updateBoard(MCREVBoardVO vo);

	public MCREVBoardVO getBoard(MCREVBoardVO vo);

	public List<MCREVBoardVO> getBoardList(MCREVBoardVO vo);
}