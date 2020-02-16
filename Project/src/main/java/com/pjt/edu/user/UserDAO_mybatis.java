package com.pjt.edu.user;



import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserDAO_mybatis  {
	@Autowired
	private SqlSession session;
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	public void insertUser(UserVO vo) {
		
	
	}

	public void deleteUser(UserVO vo) {
		

	}

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
