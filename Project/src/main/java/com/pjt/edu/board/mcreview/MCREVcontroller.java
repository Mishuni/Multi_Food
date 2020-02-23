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
import com.pjt.edu.user.UserVO;

@Controller
public class MCREVcontroller {
	@Autowired
	MCREVBoardDAO dao;
	
	List<Integer> allrow=new ArrayList<Integer>(); 
	
	//paging 처리 매서드
	public List<Integer> pagemap(){
		String row = dao.rowcount();
		List<Integer> allrow= new ArrayList<Integer>();
		int length;
		if((Integer.valueOf(row)%5)==0) {length=Integer.valueOf(row)/5;}
		else{length=(Integer.valueOf(row)/5)+1;}
		
		
		
		for(int i=0;i<length;i++) {
			allrow.add(i, i+1);			
		}
		return allrow;
	}
	
	//글쓰기 폼 띄우기.
	@RequestMapping(value = "/insertformMCREV", method = RequestMethod.GET)
	public String inertBoardForm() {
		return "/insertformMCREV";
	}

	//글쓰기 완료후 DB 저장후 목록으로 이동.
	@RequestMapping(value = "/insertformMCREV", method = RequestMethod.POST)
	public String insertBoard(MCREVBoardVO vo) {
		vo.setContents(vo.getContents().replace("\n", "<br>"));
		dao.insertBoard(vo);
		return "redirect:/listMCREV";
	}

	//MCREV Board list 출력.
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
		ModelAndView mv = new ModelAndView();
		
		
		String row = dao.rowcount();
		allrow=this.pagemap();
		
		
		List<BoardVO> list = dao.getBoardList5(num);
		
		mv.addObject("list", list);
		mv.addObject("page",allrow);
		mv.setViewName("listMCREV");
		
		return mv;
	}

	//세부글 출력.
	@RequestMapping(value = "/detailMCREV", method = RequestMethod.GET)
	public ModelAndView getBoardDetail(MCREVBoardVO vo) {
		vo = (MCREVBoardVO) dao.getBoard(vo);
		ModelAndView mv = new ModelAndView();
		mv.addObject("detail", vo);
		mv.setViewName("detailMCREV");
		return mv;

	}
	//글 수정. 작성자와 admin만 수정가능. 수정할 글을 updateformMCREV로 가져옴.
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

	// 수정 완료후 DB에 저장.
	@RequestMapping(value = "/updateMCREV", method = RequestMethod.POST)
	public String updateformBoard(/* @ModelAttribute("update") */ MCREVBoardVO vo) {
		dao.updateBoard(vo);
		return "redirect:./listMCREV";
	}
	
	
	
	// 글 삭제기능. 작성자와 admin만 삭제 가능.
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
	//검색기능. title or writer 로 검색.
	@RequestMapping(value="/listMCREV",method=RequestMethod.POST)
	public ModelAndView researchBoardList(MCREVBoardVO vo, String search,String choice) {
		ModelAndView mv = new ModelAndView();
		search = "%"+search+"%";
		if(choice.equals("writer")) {
			String writer = search;
			List<BoardVO> list = dao.writerList(writer);
			System.out.println(list);
			mv.addObject("list", list) ;
		}else if(choice.equals("title")) {
			String title=search;
			mv.addObject("list", dao.titleList(title)) ;
		}
		
		allrow=this.pagemap();
		mv.addObject("page",allrow);
		
		return mv;
	}
	
	
}
