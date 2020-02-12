package com.pjt.edu.board.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class REVcontroller {
	@Autowired
	REVDAO revdao;

	// 삽입
	@RequestMapping(value = "/insertformREV", method = RequestMethod.GET)
	public void insertBordForm() {

	}

	// 삽입2
	@RequestMapping(value = "/insertformREV", method = RequestMethod.POST)
	public String insertBoareResult() {
		
		return "insertresultREV";
	}

	// 조회
	
	@RequestMapping("/listREV")
	public void getBoardlist() {
		
	}
	
	//상세보기
	@RequestMapping("/detailREV")
	public void getBoardDetail() {}

	// 수정
	@RequestMapping("/updateREV")
	public String updateBoard() {
		return "updateresultREV";
	}

	//삭제
	@RequestMapping("/deleteREV")
	public String deleteBoard() {
		return "deleteresultREV";
	}

}
