package com.pjt.edu.board.sug;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pjt.edu.board.BoardVO;
import com.pjt.edu.user.UserVO;

@Controller
public class SUGcontroller {

	@Autowired
	SUGDAO dao;
	List<Integer> allrow = new ArrayList<Integer>();

	// paging 泥섎━ 留ㅼ꽌�뱶
	public List<Integer> pagemap() {
		String row = dao.rowcount();
		List<Integer> allrow = new ArrayList<Integer>();
		int length;
		if ((Integer.valueOf(row) % 5) == 0) {
			length = Integer.valueOf(row) / 5;
		} else {
			length = (Integer.valueOf(row) / 5) + 1;
		}

		for (int i = 0; i < length; i++) {
			allrow.add(i, i + 1);
		}
		return allrow;
	}

	//湲��벐湲� �뤌 �쓣�슦湲�.
	@RequestMapping(value = "/insertformSUG", method = RequestMethod.GET)
	public String insertBordForm() {
		return "insertformSUG";
	}

	//湲��벐湲� �셿猷뚰썑 DB ���옣�썑 紐⑸줉�쑝濡� �씠�룞.
	@RequestMapping(value = "/insertformSUG", method = RequestMethod.POST)
	public String insertBoareResult(SUGBoardVO vo) {
		vo.setContents(vo.getContents().replace("\n", "<br>"));
		dao.insertBoard(vo);
		return "redirect:/listSUG";
	}

	//SUG Board list 異쒕젰.
	@RequestMapping("/listSUG")
	public ModelAndView sugboardlist(String num) {

		if (num == null) {
			num = "1";
		}
		ModelAndView mv = new ModelAndView();
		String row = dao.rowcount();

		allrow=this.pagemap();


		List<BoardVO> list = dao.getBoardList5(num);

		mv.addObject("list", list);
		mv.addObject("page", allrow);
		mv.setViewName("listSUG");

		return mv;
	}

	//�꽭遺�湲� 異쒕젰.
	@RequestMapping(value = "/detailSUG", method = RequestMethod.GET)
	public ModelAndView sugboardone(SUGBoardVO vo) {

		//System.out.println(vo);

		ModelAndView mv = new ModelAndView();
		vo = (SUGBoardVO) dao.getBoard(vo);
		mv.addObject("detail", vo);
		return mv;
	}


	//湲� �닔�젙. �옉�꽦�옄�� admin留� �닔�젙媛��뒫. �닔�젙�븷 湲��쓣 updateformMCREV濡� 媛��졇�샂.
	@RequestMapping(value = "/updateSUG", method = RequestMethod.GET)
	public ModelAndView updateBoard(/* @ModelAttribute("update") */ SUGBoardVO vo, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		//System.out.println(vo);
		
		SUGBoardVO loginVO = (SUGBoardVO) dao.getBoard(vo);
		
		String roll = ((UserVO) session.getAttribute("member")).getRole();
		String name = ((UserVO) session.getAttribute("member")).getId();
			
		if (vo.getWriter().equals(name)) {
			vo = (SUGBoardVO) dao.getBoard(vo);
			//System.out.println(vo);
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

	// 湲� �궘�젣湲곕뒫. �옉�꽦�옄�� admin留� �궘�젣 媛��뒫.
	@RequestMapping(value = "/updateSUG", method = RequestMethod.POST)
	public String updateformBoard(/* @ModelAttribute("update") */ SUGBoardVO vo) {
		dao.updateBoard(vo);
		return "redirect:./listSUG";
	}
	// 湲� �궘�젣湲곕뒫. �옉�꽦�옄�� admin留� �궘�젣 媛��뒫.
	@RequestMapping(value = "/deleteSUG", method = RequestMethod.GET)
	public String deleteBoardResult(SUGBoardVO vo, HttpSession session) {
		System.out.println(vo);
		SUGBoardVO loginVO = (SUGBoardVO) dao.getBoard(vo);
		String roll = ((UserVO) session.getAttribute("member")).getRole();
		String name = ((UserVO) session.getAttribute("member")).getId();
//		UserVO uvo= new UserVO();
//		uvo.setId(vo.getWriter());
//		
//		uvo=udao.getUser(uvo);
		if (vo.getWriter().equals(name)) {
			dao.deleteBoard(vo);
			return "redirect:/listSUG";
		} else if (roll.equals("admin")) {
			dao.deleteBoard(vo);
			return "redirect:listSUG";
		} else {
			return "cannotDelete";
		}
	}
	//寃��깋湲곕뒫. title or writer 濡� 寃��깋.
		@RequestMapping(value="/listSUG",method=RequestMethod.POST)
		public ModelAndView researchBoardList(SUGBoardVO vo, String search,String choice) {
			ModelAndView mv = new ModelAndView();
			search = "%"+search+"%";
			if(choice.equals("writer")) {
				String writer = search;
				List<BoardVO> list = dao.writerList(writer);
				//System.out.println(list);
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
