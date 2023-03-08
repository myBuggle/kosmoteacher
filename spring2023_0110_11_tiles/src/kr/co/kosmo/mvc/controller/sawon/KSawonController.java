package kr.co.kosmo.mvc.controller.sawon;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.dao.SawonDaoInter;
import kr.co.kosmo.mvc.vo.DeptVO;
import kr.co.kosmo.mvc.vo.SawonVO;

@Controller
public class KSawonController {
	@Autowired
	private SawonDaoInter sawonDao;
	
	@GetMapping(value="/sPhoneList")
	public String sawonPhonelist(Model m) {
		List<SawonVO> list = sawonDao.getSawonPhoneList();
		m.addAttribute("splist", list);
		return "sawonPhoneList";
	}
	@GetMapping(value="/deptForm")
	public String deptchooseForm() {
		return "deptchooseform";
	}
	@PostMapping(value="/deptlist")
	public ModelAndView deptlist(int deptno) {
		ModelAndView mav = new ModelAndView("deptList");
		DeptVO list  = sawonDao.getDeptList(deptno);
		mav.addObject("dlist",list);
		return mav;
	}
}
