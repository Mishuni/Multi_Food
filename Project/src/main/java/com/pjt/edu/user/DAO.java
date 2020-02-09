package com.pjt.edu.user;

public interface DAO {
	
	public int insertUser(UserVO vo);

	public int deleteUser(UserVO vo);

	public UserVO getUser(UserVO vo);

}