package kr.co.kosmo.mvc.controller.survey;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.controller.service.SurveyService;
import kr.co.kosmo.mvc.vo.SurveyContentVO;
import kr.co.kosmo.mvc.vo.SurveyVO;

@Controller
@RequestMapping("/survey")
public class SurveyController {
	@Autowired
	private SurveyService surveyService;
	
	
	@RequestMapping(value="/surveyForm")
	public String surform() {
		return "survey/surveyAddform";
	}
	@PostMapping(value="/addsurvey")
	public ModelAndView surveyadd(SurveyVO vo,HttpServletRequest request) {
		// ���� �̸����� �Ѿ���� �Ķ���ʹ� �迭�� ���� �� �ִ�. 2 ~ 5 
		String[] surveytitle = request.getParameterValues("surveytitle");
		
		// DB�� �����ϱ� ���� List �����
		List<SurveyContentVO> list = new ArrayList<>();
		
		char stype = 'A';
		
		for(String e : surveytitle) {
			SurveyContentVO sv = new SurveyContentVO();
			sv.setSurveytitle(e);
			sv.setSurveycnt(0);
			sv.setSubtype(String.valueOf(stype));
			System.out.println("surveytitle => "+e);
			list.add(sv);
			stype++; //���ĺ��� ���� 
		}
		System.out.println("Sub => "+vo.getSub());
		// SurveyVO �� ���� Ÿ��Ʋ�� ������ List<SurveyContentVO> ���ڷ� ���� 
		vo.setSubvey(list);
		// Serivce�� ���� �����Ѵ�.
		surveyService.addSurvey(vo, list);
		
		ModelAndView mav = new ModelAndView("redirect:surveylist");
		return mav;
	}
	@RequestMapping(value="/surveylist")
	public ModelAndView surveylist() {
		ModelAndView mav = new ModelAndView("survey/surveyList");
		mav.addObject("list", surveyService.listSurvey());
		return mav;
	}	
	
	@RequestMapping(value="/surveyAdminDetail")
	public ModelAndView surveyDetail(int num) {
		ModelAndView mav = new ModelAndView("survey/surveyDetail");
		SurveyVO vo = surveyService.adminDetail(num);
		mav.addObject("vo", vo);
		return mav;
	}
	@RequestMapping(value="/surveyDetail")
	public ModelAndView surveyClientDetail(int num) {
		ModelAndView mav = new ModelAndView("survey/surveyClientDetail");
		SurveyVO vo = surveyService.adminDetail(num);
		mav.addObject("vo", vo);
		return mav;
	}
	// addSurveyClient
	@PostMapping(value="/addSurveyClient")
	public String clientSurveyAdd(Model m, SurveyContentVO scvo) {
		System.out.println("subcode : "+scvo.getSubcode()+" subtype : "+scvo.getSubtype());
		surveyService.updateSurveyCnt(scvo);
		return "redirect:surveylist";
	}
}

