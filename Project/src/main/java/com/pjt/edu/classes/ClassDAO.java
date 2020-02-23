package com.pjt.edu.classes;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ClassDAO {
	@Autowired
	private SqlSession session;
	
	public ClassVO getClass(ClassVO vo) {
		return session.selectOne("classNO",vo);
	}
	
	public List<ClassVO> getAllClass(){
		return session.selectList("classList");
	}
}