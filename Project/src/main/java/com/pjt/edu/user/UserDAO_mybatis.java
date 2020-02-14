package com.pjt.edu.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pjt.edu.common.JDBCUtil;

@Repository
public class UserDAO_mybatis implements DAO {
	@Autowired
	private SqlSession session;
	public void setSession(SqlSession session) {
		this.session = session;
	}
	@Override
	public int insertUser(UserVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int deleteUser(UserVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public UserVO getUser(UserVO vo) {
		System.out.println(vo.getId());
		UserVO user = session.selectOne("oneUser",vo.getId());
		return user;
	}
	
	public void useticket(String name) {
		session.update("useticket",name);
	}
	
	public int userRoll(UserVO vo) {
		return session.selectOne("userroll");
	}
	
	

}
