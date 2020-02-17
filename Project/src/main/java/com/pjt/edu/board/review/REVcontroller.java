package com.pjt.edu.board.review;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pjt.edu.board.BoardVO;
import com.pjt.edu.board.mcreview.MCREVBoardVO;
import com.pjt.edu.user.UserVO;

@Controller
public class REVcontroller {
	@Autowired
	REVDAO dao;

	// �궫�엯
	@RequestMapping(value = "/insertformREV", method = RequestMethod.GET)
	public String insertBordForm() {
		return "insertformREV";
	}

	// �궫�엯2
	@RequestMapping(value = "/insertformREV", method = RequestMethod.POST)
	public String insertBoareResult(REVBoardVO vo) {

		dao.insertBoard(vo);
		return "redirect:/listREV";

	}

	// 議고쉶
	@RequestMapping("/listREV")
	public ModelAndView getBoardlist(String num) {
		if(num==null) {
			num="1";
		}
		System.out.println(num);
		ModelAndView mv = new ModelAndView();
		
		
		String row = dao.rowcount();
		
		int length;
		if((Integer.valueOf(row)%5)==0) {length=Integer.valueOf(row)/5;}
		else{length=(Integer.valueOf(row)/5)+1;}
		
		
		List<Integer> allrow= new ArrayList<Integer>();
		for(int i=0;i<length;i++) {
			allrow.add(i, i+1);			
		}
		
		List<BoardVO> list = dao.getBoardList5(num);
		
		mv.addObject("list", list);
		mv.addObject("page",allrow);
		mv.setViewName("listREV");
		
		return mv;

	}

	/*
	 * @RequestMapping("/mybatis/emplist") public ModelAndView getAllEmp(){
	 * 
	 * List<EmpVO> list = dao.getAllEmp(); ModelAndView mv = new ModelAndView();
	 * mv.addObject("list", list); return mv; }
	 */

	// �긽�꽭蹂닿린
	@RequestMapping(value = "/detailREV", method = RequestMethod.GET)
	public ModelAndView getBoardDetail(REVBoardVO vo) {
		ModelAndView mv = new ModelAndView();
		vo = (REVBoardVO) dao.getBoard(vo);
		mv.addObject("detail", vo);
		mv.setViewName("detailREV");
		return mv;
	}

	//�닔�젙�븷 湲� title,contents瑜� updateform �쑝濡� 媛��졇�삤湲�. 湲��벖�씠, admin留� �닔�젙媛��뒫.
	@RequestMapping(value = "/updateREV", method = RequestMethod.GET)
	public ModelAndView updateBoard(/* @ModelAttribute("update") */ REVBoardVO vo, HttpSession session) {
			ModelAndView mv = new ModelAndView();
			System.out.println(vo);
			REVBoardVO loginVO = (REVBoardVO) dao.getBoard(vo);
			String roll = ((UserVO)session.getAttribute("member")).getRole();
			
			
			if (loginVO.getWriter().equals(vo.getWriter())) {
				vo = (REVBoardVO) dao.getBoard(vo);
				System.out.println(vo);
				mv.addObject("update", vo);
				mv.setViewName("updateformREV");
				return mv;
			} else if (roll.equals("admin")) {
				vo = (REVBoardVO) dao.getBoard(vo);
				System.out.println(vo);
				mv.addObject("update", vo);
				mv.setViewName("updateformREV");
				return mv;
			} else {
				mv.setViewName("cannotDelete");
				return mv;
			}

		}
	

	// �닔�젙�븳 湲� �뾽�뜲�씠�듃.
	@RequestMapping(value = "/updateREV", method = RequestMethod.POST)
	public String updateformBoard(/* @ModelAttribute("update") */REVBoardVO vo) {
		dao.updateBoard(vo);
		return "redirect:./listREV";
	}

	// 寃뚯떆臾� �궘�젣
	@RequestMapping(value = "/deleteREV", method = RequestMethod.GET)
	public String deleteBoardResult(REVBoardVO vo,HttpSession session) {
		System.out.println(vo);
		String roll = ((UserVO)session.getAttribute("member")).getRole();
		REVBoardVO loginVO = (REVBoardVO) dao.getBoard(vo);

//			UserVO uvo= new UserVO();
//			uvo.setId(vo.getWriter());
//			
//			uvo=udao.getUser(uvo);
		if (loginVO.getWriter().equals(vo.getWriter())) {
			dao.deleteBoard(vo);
			return "redirect:/listREV";
		} else if (roll.equals("admin")) {
			dao.deleteBoard(vo);
			return "redirect:/listREV";
		} else {
			return "cannotDelete";
		}
	}

}
