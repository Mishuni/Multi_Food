package com.pjt.edu.board.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pjt.edu.board.BoardVO;

@Controller
public class REVcontroller {
	@Autowired
	REVDAO dao;

	// 삽입
	@RequestMapping(value = "/insertformREV", method = RequestMethod.GET)
	public void insertBordForm() {

	}

	// 삽입2
	@RequestMapping(value = "/insertformREV", method = RequestMethod.POST)
	public String insertBoareResult(REVBoardVO vo) {

		dao.insertBoard(vo);
		return "redirect:/listREV";

	}

	// 조회

	@RequestMapping("/listREV")
	public ModelAndView getBoardlist() {

		ModelAndView mv = new ModelAndView();
		REVBoardVO vo = new REVBoardVO();

		List<BoardVO> list = dao.getBoardList(vo);

		mv.addObject("list", list);

		mv.setViewName("listREV");

		return mv;

	}

	/*
	 * @RequestMapping("/mybatis/emplist") public ModelAndView getAllEmp(){
	 * 
	 * List<EmpVO> list = dao.getAllEmp(); ModelAndView mv = new ModelAndView();
	 * mv.addObject("list", list); return mv; }
	 */

	// 상세보기
	@RequestMapping("/detailREV")
	public void getBoardDetail() {
	}

	// 수정
	@RequestMapping("/updateREV")
	public String updateBoard() {
		return "updateresultREV";
	}

	// 삭제
	@RequestMapping("/deleteREV")
	public String deleteBoard() {
		return "deleteresultREV";
	}

}
