package com.pjt.edu.board;

import java.util.List;


public interface DAO {

	public int insertBoard(BoardVO vo);

	public int deleteBoard(BoardVO vo);

	public int updateBoard(BoardVO vo);

	public BoardVO getBoard(BoardVO vo);

	public List<BoardVO> getBoardList(BoardVO vo);
}