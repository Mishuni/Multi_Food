package com.pjt.edu.board.mcreview;

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
import com.pjt.edu.board.review.REVBoardVO;
import com.pjt.edu.board.sug.SUGBoardVO;
import com.pjt.edu.user.UserVO;

@Controller
public class MCREVcontroller {
	@Autowired
	MCREVBoardDAO dao;

//湲��벐湲� �뤌�솕硫�
	@RequestMapping(value = "/insertformMCREV", method = RequestMethod.GET)
	public String inertBoardForm() {
		return "/insertformMCREV";
	}

//湲��벐湲� �썑 ���옣
	@RequestMapping(value = "/insertformMCREV", method = RequestMethod.POST)
	public String insertBoard(MCREVBoardVO vo) {
		dao.insertBoard(vo);

		return "redirect:/listMCREV";
	}

//湲�紐⑸줉
	@RequestMapping("/listMCREV")
	public ModelAndView getAllBoard(String num) {
//		ModelAndView mv = new ModelAndView();
//		MCREVBoardVO vo = new MCREVBoardVO();
//		List<BoardVO> list = dao.getBoardList(vo);
//
//		mv.addObject("list", list);
//		mv.setViewName("listMCREV");
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
		mv.setViewName("listMCREV");
		
		return mv;
	}

//湲� �븯�굹 議고쉶 detail
	@RequestMapping(value = "/detailMCREV", method = RequestMethod.GET)
	public ModelAndView getBoardDetail(MCREVBoardVO vo) {
		vo = (MCREVBoardVO) dao.getBoard(vo);
		ModelAndView mv = new ModelAndView();
		mv.addObject("detail", vo);
		mv.setViewName("detailMCREV");
		return mv;

	}
	//�닔�젙�븷 湲� title,contents瑜� updateform �쑝濡� 媛��졇�삤湲�. 湲��벖�씠, admin留� �닔�젙媛��뒫.
	@RequestMapping(value = "/updateMCREV", method = RequestMethod.GET)
	public ModelAndView updateBoard(/* @ModelAttribute("update") */ MCREVBoardVO vo, HttpSession session) {
			ModelAndView mv = new ModelAndView();
			System.out.println(vo);
			MCREVBoardVO loginVO = (MCREVBoardVO) dao.getBoard(vo);
			String roll = ((UserVO)session.getAttribute("member")).getRole();
			
			
			if (loginVO.getWriter().equals(vo.getWriter())) {
				vo = (MCREVBoardVO) dao.getBoard(vo);
				System.out.println(vo);
				mv.addObject("update", vo);
				mv.setViewName("updateformMCREV");
				return mv;
			} else if (roll.equals("admin")) {
				vo = (MCREVBoardVO) dao.getBoard(vo);
				System.out.println(vo);
				mv.addObject("update", vo);
				mv.setViewName("updateformMCREV");
				return mv;
			} else {
				mv.setViewName("cannotDelete");
				return mv;
			}

		}

	// �닔�젙�븳 湲� �뾽�뜲�씠�듃.
	@RequestMapping(value = "/updateMCREV", method = RequestMethod.POST)
	public String updateformBoard(/* @ModelAttribute("update") */ MCREVBoardVO vo) {
		dao.updateBoard(vo);
		return "redirect:./listMCREV";
	}
	
	
	
	// 寃뚯떆臾� �궘�젣
	@RequestMapping(value = "/deleteMCREV", method = RequestMethod.GET)
	public String deleteBoardResult(MCREVBoardVO vo,HttpSession session) {
		System.out.println(vo);
		MCREVBoardVO loginVO = (MCREVBoardVO) dao.getBoard(vo);
		String roll = ((UserVO)session.getAttribute("member")).getRole();

//		UserVO uvo= new UserVO();
//		uvo.setId(vo.getWriter());
//		
//		uvo=udao.getUser(uvo);
		if (loginVO.getWriter().equals(vo.getWriter())) {
			dao.deleteBoard(vo);
			return "redirect:/listMCREV";
		} else if (roll.equals("admin")) {
			dao.deleteBoard(vo);
			return "redirect:listMCREV";
		} else {
			return "cannotDelete";
		}
	}
}
