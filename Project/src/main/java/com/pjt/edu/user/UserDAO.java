package com.pjt.edu.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.pjt.edu.common.JDBCUtil;

@Repository
public class UserDAO implements DAO {
	
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	// SQL 명령어
	private final String USERS_INSERT = "insert into USERS(id,pw,role,name,classno,money,tickets,total) "
			+ "values(?,?,user,?,?,0,0,0)";
	//private final String USERS_UPDATE = "update USERS set title=?,content=? where seq=?";
	private final String USERS_DELETE = "delete USERS where id=? and pw=?";
	private final String USERS_GET = "select * from USERS where id=? and pw=?";
	
	@Override
	public int insertUser(UserVO vo) {
		int result = 0 ;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USERS_INSERT);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPw());
			stmt.setString(3, vo.getName());
			stmt.setInt(4, vo.getClassNo());
			result = stmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtil.close(stmt, conn);
		}
		return result;
	}
	
	@Override
	public int deleteUser(UserVO vo) {
		int result = 0 ;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USERS_DELETE);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPw());
			result = stmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtil.close(stmt, conn);
		}
		return result;
	}
	
	@Override
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
				user.setPoint(rs.getInt("POINT"));
				user.setTickets(rs.getInt("TICKETS"));
				user.setTotal(rs.getInt("TOTAL"));
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
