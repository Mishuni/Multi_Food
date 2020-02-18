package com.pjt.edu.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.pjt.edu.common.JDBCUtil;

@Repository
public class ClassDAO {
   
   private Connection conn = null;
   private PreparedStatement stmt = null;
   private ResultSet rs = null;
   
   // SQL 紐낅졊�뼱
   private final String CLASS_INSERT = 
         "insert into CLASS(classNo, className, startDay, endDay, studentCnt) "
         + "values("
         + "(select nvl(max(classno),0)+1 from CLASS),"
         + "?,sysdate,sysdate,?)";

   private final String CLASS_UPDATE = "update CLASS set studentcnt=? where classno=?";
   private final String CLASS_DELETE = "delete CLASS where classno=?";
   private final String CLASS_GET = "select * from CLASS where classno=?";
   private final String CLASS_GETALL = "select * from CLASS";
   
   public int insertClass(ClassVO vo) {
      int result = 0 ;
      try {
         conn = JDBCUtil.getConnection();
         stmt = conn.prepareStatement(CLASS_INSERT);
         stmt.setString(1, vo.getClassName());
         stmt.setInt(2, vo.getStudentCnt());
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

   public int deleteClass(ClassVO vo) {
      int result = 0 ;
      try {
         conn = JDBCUtil.getConnection();
         stmt = conn.prepareStatement(CLASS_DELETE);
         stmt.setInt(1,vo.getClassNo());
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
   
   public int updateClass(ClassVO vo) {
      int result = 0 ;
      try {
         conn = JDBCUtil.getConnection();
         stmt = conn.prepareStatement(CLASS_UPDATE);
         stmt.setInt(1,vo.getStudentCnt());
         stmt.setInt(2, vo.getClassNo());
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

   public ClassVO getClass(ClassVO vo) {
      ClassVO lecture = null;
      try {
         
         conn = JDBCUtil.getConnection();
         stmt = conn.prepareStatement(CLASS_GET);
         stmt.setInt(1, vo.getClassNo());
         rs = stmt.executeQuery();
         if(rs.next()) {
            lecture = new ClassVO();
            lecture.setClassName(rs.getString("CLASSNAME"));
            lecture.setClassNo(rs.getInt("CLASSNO"));
            lecture.setEndDay(rs.getString("ENDDAY"));
            lecture.setStartDay(rs.getString("STARTDAY"));
            lecture.setStudentCnt(rs.getInt("STUDENTCNT"));
         }
         
      }catch(Exception e) {
         e.printStackTrace();
      }
      finally {
         JDBCUtil.close(stmt, conn);
      }
      return lecture;
   }
   
   public List<ClassVO> getAllClass(){
      List<ClassVO> list = new ArrayList<ClassVO>();
      
      try {
         
         conn = JDBCUtil.getConnection();
         stmt = conn.prepareStatement(CLASS_GETALL);
         rs = stmt.executeQuery();
         while(rs.next()) {
            ClassVO lecture = new ClassVO();
            lecture.setClassName(rs.getString("CLASSNAME"));
            lecture.setClassNo(rs.getInt("CLASSNO"));
            lecture.setEndDay(rs.getString("ENDDAY"));
            lecture.setStartDay(rs.getString("STARTDAY"));
            lecture.setStudentCnt(rs.getInt("STUDENTCNT"));
            list.add(lecture);
         }
         
      }catch(Exception e) {
         e.printStackTrace();
      }
      finally {
         JDBCUtil.close(stmt, conn);
      }
      return list;
   }
}