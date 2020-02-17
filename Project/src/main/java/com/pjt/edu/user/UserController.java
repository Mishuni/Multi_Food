package com.pjt.edu.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public String login(HttpServletRequest request, @RequestParam("id") String id, String pw, String button) {
		/*
		 * if(vo.getId()==null || vo.getId().equals("")) { throw new
		 * IllegalArgumentException("�븘�씠�뵒�뒗 諛섎뱶�떆 �엯�젰�빐�빞 �빀�땲�떎."); }
		 */
		HttpSession session = request.getSession();
		if(button.equals("Sign up")) {
			List<ClassVO> list = cdao.getAllClass();
			session.setAttribute("clist", list);
			return "signup";
		}
		UserVO user = null;
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPw(pw);
		user = dao.getUser(vo);
		ModelAndView mav = new ModelAndView();
		//System.out.println(user.getPoint());

		if (user != null) {
			mav.addObject("user", user);
//			if (user.getRole().equals("admin")) {
//				mav.setViewName("mypage");
//				return mav;
//			}
			ClassVO cvo = new ClassVO();
			cvo.setClassNo(user.getClassNo());
			ClassVO lecture = cdao.getClass(cvo);
			
			session.setAttribute("member", user);
			session.setAttribute("lecture", lecture);
			return "mypage";
		} else
			return "main";

	}
	
	//회원가입
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(UserVO vo) {

		
		ModelAndView mv = new ModelAndView();
		System.out.println(vo.getId());
		UserVO mem = null;
		mem=mdao.getUser(vo);
		if(mem==null) {
			mdao.insertUser(vo);
			
			return "signupsuccess";
		}
		else {
			return "signupfail";
		}

	}
	
	//logout
	   @RequestMapping(value = "/logout")
	   public String logout(HttpSession session) {
	      session.invalidate();
	      return "main";
	      
	   }
	
	
	/* �떚耳볦갹 �쓣�슦湲� */

	@RequestMapping(value = "/useticket")
	public String useticket() {

		return "/useticket";
	}

	
	/* �떚耳� 援щℓ 李� �쓣�슦湲� */
	@RequestMapping(value = "/buyticket")
	public String buyticket() {
		
		return "buyticket";
	}

	@RequestMapping(value = "/todaymenu")
	public String todaymenu() {
		return "/todaymenu";
	}
	
	
	/* �떚耳볦궗�슜 */
	@RequestMapping(value = "/useticketClick")
	public String useticketClick(UserVO vo, HttpSession session) {
		
		String sessionId = ((UserVO)session.getAttribute("member")).getId();
		
		mdao.useticket(sessionId);

		return "/result";
	}
	
	   
	   
	   //�떚耳볤뎄留�//
		@RequestMapping(value = "/buyticketClick", method = RequestMethod.GET)
		public String buyticketClick(@RequestParam("ticket")String ticket,  HttpSession session, UserVO vo) {
			
			
			String sessionId = ((UserVO)session.getAttribute("member")).getId();
			

			Map map = new HashMap();
			map.put("ticket", Integer.parseInt(ticket));
			map.put("sessionID", sessionId);
			System.out.println(ticket);
			System.out.println(sessionId);
			
			mdao.addticket(map);


			return "/result";
		}
	   
	   
	   //�룷�씤�듃 異⑹쟾李�//
	   @RequestMapping(value = "/addpoint")
		public String addPoint(UserVO vo) {
		   return "/addpoint";
		}
		
	  
	   //�룷�씤�듃 異⑹쟾//
	   
		@RequestMapping(value = "/addpointClick",  method = RequestMethod.GET)
		public String addPointClick(@RequestParam("money")String money,  HttpSession session) {
			
			String sessionId = ((UserVO)session.getAttribute("member")).getId();
			
			Map map = new HashMap();
			map.put("point", Integer.parseInt(money));
			map.put("sessionID", sessionId);
			System.out.println(money);
			System.out.println(sessionId);
			System.out.println(map);
			mdao.addpoint(map);

			return "/result";
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
