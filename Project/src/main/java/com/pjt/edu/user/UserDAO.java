package com.pjt.edu.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.pjt.edu.common.JDBCUtil;

@Repository
public class UserDAO  {
	
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	// SQL 紐낅졊�뼱


	private final String USERS_GET = "select * from USERS where id=? and pw=?";

	
	public UserVO getUser(UserVO vo) {
		UserVO user = null;
		try {
			
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USERS_GET);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPw());
			rs = stmt.executeQuery();
			if(rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPw(rs.getString("PW"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
				user.setClassNo(rs.getInt("CLASSNO"));
				user.setTickets(rs.getInt("TICKETS"));
				user.setTotal(rs.getInt("TOTAL"));
				user.setPoint(rs.getInt("POINT"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtil.close(stmt, conn);
		}
		return user;
	}

}
