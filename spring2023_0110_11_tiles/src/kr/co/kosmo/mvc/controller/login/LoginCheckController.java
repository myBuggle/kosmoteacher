package kr.co.kosmo.mvc.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.dao.MemberDaoInter;
import kr.co.kosmo.mvc.vo.MemberDTO;


@Controller
@RequestMapping(value="/login")
public class LoginCheckController {

	@Autowired
	private MemberDaoInter memberList;
	
	@RequestMapping(value="/loginForm")
	public String loginForm() {
		return "login/loginForm";
	}
	
	// 폼에서 전송되어 온 파라미터의 값을 기준으로 데이터베이스에서 
	// 인증된 회원이면 세션의 값을 저장하고 , 아니면 오류 메세지를 보여줘야 하지 않나
	// String userAgent : Aspect에서 받을 데이터 => @RequestHeader("User-Agent") 
	@PostMapping("/loginProcess")
	public ModelAndView loginfProcess(HttpSession session,HttpServletRequest request,
			MemberDTO vo,@RequestHeader("User-Agent") String userAgent) {
		
		//System.out.println("User-Agent : "+userAgent);
		ModelAndView mav = new ModelAndView("redirect:/web/main");
		// test
		//String dbid="xman";
		//String dbpwd ="kosmo123";
		MemberDTO dto =memberList.loginCheck(vo);
		//System.out.println(dto);
		//if(dbid.equals(vo.getId()) && dbpwd.equals(vo.getPwd())) { // login success
		if(dto == null) {
			mav.setViewName("error/paramException");
			mav.addObject("emsg", "로그인 실패 입니다.");
		}else {
			session.setAttribute("sessionName", dto.getName());
			session.setAttribute("sessionID", dto.getId());
			System.out.println("로그인 실행! 및 세션 저장 => Proceeding Call");
		}
		return mav;
	}
	
	@GetMapping("/logout")
	public ModelAndView loginfoutProcess(HttpSession session,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		//session.invalidate();
		session.removeAttribute("sessionName");
		session.removeAttribute("sessionID");
		mav.setViewName("redirect:/web/main");
		System.out.println("로그아웃 실행! 및 세션 삭제  => Proceeding Call");
		return mav;
	}
}




