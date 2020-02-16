package com.pjt.edu.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pjt.edu.classes.ClassDAO;
import com.pjt.edu.classes.ClassVO;

@Controller
public class UserController {
	@Autowired
	// 1.<beans:bean id="dao" class="xxx.BoardDAO"
	// 2. @Repository("dao") class BoardDAO
	UserDAO dao;
	@Autowired
	UserDAO_mybatis mdao;

	@Autowired
	ClassDAO cdao;

	@RequestMapping(value = "/main")
	public String getMain() {
		ModelAndView mav = new ModelAndView();

		return "main";
	}

	@RequestMapping(value = "/mypage")
	public String UserMain(HttpSession session) {

		return "mypage";

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, @RequestParam("id") String id, String pw) {
		/*
		 * if(vo.getId()==null || vo.getId().equals("")) { throw new
		 * IllegalArgumentException("아이디는 반드시 입력해야 합니다."); }
		 */
		UserVO user = null;
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPw(pw);
		user = dao.getUser(vo);
		ModelAndView mav = new ModelAndView();
		System.out.println(user.getPoint());

		if (user != null) {
			mav.addObject("user", user);
//			if (user.getRole().equals("admin")) {
//				mav.setViewName("mypage");
//				return mav;
//			}
			ClassVO cvo = new ClassVO();
			cvo.setClassNo(user.getClassNo());
			ClassVO lecture = cdao.getClass(cvo);
			HttpSession session = request.getSession();
			session.setAttribute("member", user);
			session.setAttribute("lecture", lecture);
			return "mypage";
		} else
			return "main";

	}

	/* 티켓창 띄우기 */

	@RequestMapping(value = "/useticket")
	public String useticket() {

		return "/useticket";
	}

	/* 티켓사용 */
	@RequestMapping(value = "/useticketClick")
	public String useticketClick(HttpSession session) {
		
		UserVO user = (UserVO) session.getAttribute("member");
		if(user!=null&&user.getTickets()>0) {
			String sessionId = user.getId();
			mdao.useticket(sessionId);
			return "/useticketresult";}
		else if(user==null) {
			return "login";
		}
		// 식권이 없으면 경고창 띄우기
		
		return "mypage";
	}
	
	
	/* 티켓 구매 창 띄우기 */
	@RequestMapping(value = "/buyticket")
	public String buyticket() {
		
		return "buyticket";
	}

	@RequestMapping(value = "/todaymenu")
	public String todaymenu() {
		return "/todaymenu";
	}

//	@RequestMapping(value="/mypage")
//	public ModelAndView getMypage(@ModelAttribute("user")UserVO vo) {
//		ModelAndView mav = new ModelAndView();
//		UserVO user = vo;
//		mav.addObject("user",user);
//		mav.setViewName("mypage");
//		return mav;
//	}
}
