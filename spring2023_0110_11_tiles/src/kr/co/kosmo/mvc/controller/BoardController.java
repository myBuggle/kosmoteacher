package kr.co.kosmo.mvc.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.vo.BoardVO;
@Controller
public class BoardController {

	//ViewName - String 鋼発
	//View拭辞 葵聖 穿勺 : mav.addObject("list", list); 企重 Model聖 爽脊聖 閤焼辞 坦軒
	//board/boardList.jsp拭辞 jstl引 EL稽 list研 窒径 
	@RequestMapping(value="/boardlist")
	public String boardList(Model model) {
		//Dao人 尻疑
		List<BoardVO> list = new ArrayList<BoardVO>();
		// 績獣 汽戚斗 幻級奄
		for(int i=0; i<10;i++) {
			BoardVO vo = new BoardVO();
			vo.setNum(i+1);
			vo.setTitle("神潅精 陣走 ぞぞぞぞぞ"+i);
			vo.setWriter("沿掩疑");
			vo.setBdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			list.add(vo);
		}
		model.addAttribute("list", list);
		return "board/boardList";
	}
	@RequestMapping(value="/boardForm")
	public ModelAndView bordForm() {
		ModelAndView mav = new ModelAndView("board/boardForm");
		return mav;
	}
	@RequestMapping(value="/boardIn", method = RequestMethod.POST)
	public ModelAndView boardInsert(BoardVO vo) {
		ModelAndView mav = new ModelAndView("redirect:boardlist");
		System.out.println("reip :"+vo.getReip());
		System.out.println("title : "+vo.getTitle());
		System.out.println("content : "+vo.getContent());
		return mav;
	}
	//<a href="boardDetail?num=1">
	@RequestMapping(value="/boardDetail",method = RequestMethod.GET)
	public String boardDetail(Model model, HttpServletRequest req) {
		int num = Integer.parseInt(req.getParameter("num"));
		// DB拭辞 雌室左奄 亜閃臣 慎蝕 
		BoardVO vo = new BoardVO();
		vo.setNum(num);
		vo.setTitle("神潅精 陣走 ぞぞぞぞぞ"+num);
		vo.setWriter("沿掩疑");
		vo.setReip("192.168.0.11");
		vo.setContent("馬馬 硲硲斐");
		vo.setBdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		model.addAttribute("vo", vo);
		return "board/boardDetail";
	}
	
	
	
	
	
	
}
