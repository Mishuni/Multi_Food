package com.pjt.edu.user;



import java.util.Map;

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
	

	public int userRoll(UserVO vo) {
		return session.selectOne("userroll");
	}
	
	
	//�떇沅뚯궗�슜
	public void useticket(String name) {
		session.update("useticket",name);
	}
	
	//�떚耳볤뎄留�
	
	public int addticket(Map map) {
		return session.update("addticket",map);
	}
	
	//�룷�씤�듃 異⑹쟾
	public int addpoint(Map map) {
		return session.update("addpoint",map);
	}
	

}
