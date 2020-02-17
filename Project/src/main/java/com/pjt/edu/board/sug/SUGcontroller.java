package com.pjt.edu.board.sug;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pjt.edu.board.BoardVO;
import com.pjt.edu.user.UserDAO_mybatis;
import com.pjt.edu.user.UserVO;

@Controller
public class SUGcontroller {

	@Autowired
	SUGDAO dao;
	@Autowired
	UserDAO_mybatis udao;
	//�궫�엯
	@RequestMapping(value = "/insertformSUG", method = RequestMethod.GET)
	public String insertBordForm() {
		return "insertformSUG";
	}
	
	// �궫�엯2
	@RequestMapping(value = "/insertformSUG", method = RequestMethod.POST)
	public String insertBoareResult(SUGBoardVO vo) {
		
		dao.insertBoard(vo);
		return "redirect:/listSUG";
	}
	
	//議고쉶
	@RequestMapping("/listSUG")
	public ModelAndView sugboardlist(String num) {
		
//		ModelAndView mv = new ModelAndView();
//		SUGBoardVO vo = new SUGBoardVO();
//		List<BoardVO> list = dao.getBoardList(vo);
//		
//		mv.addObject("list", list);
//		return mv;
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
		mv.setViewName("listSUG");
		
		return mv;
	}
	//�긽�꽭蹂닿린
	@RequestMapping(value="/detailSUG", method=RequestMethod.GET )
	public ModelAndView sugboardone(SUGBoardVO vo) {
		
		System.out.println(vo);
		
		ModelAndView mv = new ModelAndView();
//		dao.upViewCount(vo);	
		vo = (SUGBoardVO)dao.getBoard(vo);
		mv.addObject("detail", vo);
		return mv;
	}
	
//	@RequestMapping(value="/insertFormSUG", method=RequestMethod.GET)
//	public ModelAndView updateform(SUGBoardVO vo) {
//		ModelAndView mv = new ModelAndView();
//		
//		vo=(SUGBoardVO)dao.getBoard(vo);
//		mv.addObject("update",vo);
//		return mv;
//	}
//	@RequestMapping(value="/insertFormSUG", method=RequestMethod.POST)
//	public String updateboard(SUGBoardVO vo) {
//		
//		
//		
//		return "redirect:detailSUG";
//		
//	}
	//�닔�젙�븷 湲� title,contents瑜� updateform �쑝濡� 媛��졇�삤湲�. 湲��벖�씠, admin留� �닔�젙媛��뒫.
		@RequestMapping(value = "/updateSUG", method = RequestMethod.GET)
	public ModelAndView updateBoard(/* @ModelAttribute("update") */ SUGBoardVO vo, HttpSession session) {
			ModelAndView mv = new ModelAndView();
			System.out.println(vo);
			SUGBoardVO loginVO = (SUGBoardVO) dao.getBoard(vo);
			String roll = ((UserVO)session.getAttribute("member")).getRole();
			
			
			if (loginVO.getWriter().equals(vo.getWriter())) {
				vo = (SUGBoardVO) dao.getBoard(vo);
				System.out.println(vo);
				mv.addObject("update", vo);
				mv.setViewName("updateformSUG");
				return mv;
			} else if (roll.equals("admin")) {
				vo = (SUGBoardVO) dao.getBoard(vo);
				System.out.println(vo);
				mv.addObject("update", vo);
				mv.setViewName("updateformSUG");
				return mv;
			} else {
				mv.setViewName("cannotDelete");
				return mv;
			}

		}

		// �닔�젙�븳 湲� �뾽�뜲�씠�듃.
		@RequestMapping(value = "/updateSUG", method = RequestMethod.POST)
	public String updateformBoard(/* @ModelAttribute("update") */ SUGBoardVO vo) {
			dao.updateBoard(vo);
			return "redirect:./listSUG";
		}
	
	@RequestMapping(value="/deleteSUG", method=RequestMethod.GET)
	public String deleteBoardResult(SUGBoardVO vo, HttpSession session) {
		System.out.println(vo);
		SUGBoardVO loginVO = (SUGBoardVO)dao.getBoard(vo);
		String roll = ((UserVO)session.getAttribute("member")).getRole();
		
//		UserVO uvo= new UserVO();
//		uvo.setId(vo.getWriter());
//		
//		uvo=udao.getUser(uvo);
		if(loginVO.getWriter().equals(vo.getWriter())) {
		dao.deleteBoard(vo);
			return "redirect:/listSUG";
		}else if(roll.equals("admin")) {
			dao.deleteBoard(vo);
			return "redirect:listSUG";
		}
		else {
			return "cannotDelete";
		}
	} 
	
}
