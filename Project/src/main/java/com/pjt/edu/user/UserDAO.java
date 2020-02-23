package com.pjt.edu.user;



import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserDAO  {
   @Autowired
   private SqlSession session;
   public void setSession(SqlSession session) {
      this.session = session;
   }
   
   public void insertUser(UserVO vo) {
      
      session.insert("insertuser",vo);
   }

   public void deleteUser(UserVO vo) {
      

   }

   public UserVO getUser(UserVO vo) {
      //System.out.println(vo.getId());
      UserVO user = session.selectOne("oneUser",vo.getId());
      return user;
   }
   
   public UserVO login(UserVO vo) {
	   return session.selectOne("oneLogin",vo);
   }

   public int userRoll(UserVO vo) {
      return session.selectOne("userroll");
   }
   
   
   //占쎈뻼亦낅슣沅쀯옙�뒠
   public void useticket(String name) {
      session.update("useticket",name);
   }
   
   //占쎈뼒�노낀�럡筌랃옙
   
   public int addticket(Map map) {
      return session.update("addticket",map);
   }
   
   //占쎈７占쎌뵥占쎈뱜 �빊�뫗�읈
   public int addpoint(Map map) {
      return session.update("addpoint",map);
   }
   
   

}