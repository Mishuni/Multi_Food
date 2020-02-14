package com.pjt.edu.board.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pjt.edu.board.BoardVO;
import com.pjt.edu.user.UserDAO_mybatis;
import com.pjt.edu.user.UserVO;

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
	@RequestMapping(value = "/detailREV", method = RequestMethod.GET)
	public ModelAndView getBoardDetail(REVBoardVO vo) {
		ModelAndView mv = new ModelAndView();
		vo = (REVBoardVO) dao.getBoard(vo);
		mv.addObject("detail", vo);
		mv.setViewName("detailREV");
		return mv;
	}

	// 글쓴이만 수정 가능
	@RequestMapping(value="/updateREV", method=RequestMethod.GET)
	public ModelAndView updateBoard(REVBoardVO vo) {
		ModelAndView mv = new ModelAndView();
		REVBoardVO loginVO = (REVBoardVO) dao.getBoard(vo);
		
		if (loginVO.getWriter().equals(vo.getWriter())) {
			vo = (REVBoardVO)dao.getBoard(vo);
			mv.addObject("update", vo);
			mv.setViewName("updateformREV");
			return mv;
//		} else if (vo.getWriter().equals("admin")) {
//			dao.deleteBoard(vo);
//			return mv;
		} else {
			mv.setViewName("cannotDelete");
			return mv;
		}
		
		
	}
	//수정한 글 업데이트.
	@RequestMapping(value="/updateREV",method=RequestMethod.POST)
	public String updateformBoard(REVBoardVO vo) {
		
		dao.updateBoard(vo);
		return "redirect:./listREV";
	}

	// 게시물 삭제
	@RequestMapping(value = "/deleteREV", method = RequestMethod.GET)
	public String deleteBoardResult(REVBoardVO vo) {
		System.out.println(vo);
		REVBoardVO loginVO = (REVBoardVO) dao.getBoard(vo);

//			UserVO uvo= new UserVO();
//			uvo.setId(vo.getWriter());
//			
//			uvo=udao.getUser(uvo);
		if (loginVO.getWriter().equals(vo.getWriter())) {
			dao.deleteBoard(vo);
			return "redirect:/listREV";
		} else if (vo.getWriter().equals("admin")) {
			dao.deleteBoard(vo);
			return "redirect:/listREV";
		} else {
			return "cannotDelete";
		}
	}
	
	

}
