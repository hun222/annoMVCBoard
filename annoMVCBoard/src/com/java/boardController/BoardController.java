package com.java.boardController;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.boardDTO.BoardDTO;
import com.java.boardService.BoardService;

@Controller
public class BoardController{
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/board/test.do", method=RequestMethod.GET)
	public void test(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("OK");
	}
	
	@RequestMapping(value="/board/write.do", method=RequestMethod.GET)
	public ModelAndView boardWrite(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("request",request);
		
		boardService.boardWrite(mv);
		
		return mv;
	}
	
	@RequestMapping(value="/board/writeOk.do", method=RequestMethod.POST)
	public ModelAndView boardWriteOk(HttpServletRequest request, HttpServletResponse response, BoardDTO boardDTO) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("request",request);
		mv.addObject("boardDTO",boardDTO);
		
		boardService.boardWriteOk(mv);
		
		return mv;
	}
	
	@RequestMapping(value="/board/list.do", method=RequestMethod.GET)
	public ModelAndView boardList(HttpServletRequest request, HttpServletResponse response, BoardDTO boardDTO) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("request",request);
		mv.addObject("boardDTO",boardDTO);
		
		boardService.boardList(mv);
		
		return mv;
	}
	
	@RequestMapping(value="/board/read.do", method=RequestMethod.GET)
	public ModelAndView boardRead(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("request",request);
		
		boardService.boardRead(mv);
		
		return mv;
	}
	
	@RequestMapping(value="/board/delete.do", method=RequestMethod.GET)
	public ModelAndView boardDelete(HttpServletRequest request, HttpServletResponse response) {
		int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("boardNumber",boardNumber);
		mv.addObject("pageNumber",pageNumber);
		mv.setViewName("board/delete");
		
		return mv;
	}

	@RequestMapping(value="/board/deleteOk.do", method=RequestMethod.POST)
	public ModelAndView boardDeleteOk(HttpServletRequest request, HttpServletResponse response) {
		int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		String password = request.getParameter("password");
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("request",request);
		mv.addObject("boardNumber",boardNumber);
		mv.addObject("pageNumber",pageNumber);
		mv.addObject("password",password);
		
		boardService.boardDeleteOk(mv);
		
		return mv;
	}
	
	@RequestMapping(value="/board/update.do", method=RequestMethod.GET)
	public ModelAndView boardUpdate(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("request",request);
		
		boardService.boardUpdate(mv);
		
		return mv;
	}
	
	@RequestMapping(value="/board/updateOk.do", method=RequestMethod.POST)
	public ModelAndView boardUpdateOk(HttpServletRequest request, HttpServletResponse response, BoardDTO boardDTO)  {
		ModelAndView mv = new ModelAndView();
		mv.addObject("request",request);
		mv.addObject("boardDTO",boardDTO);
		
		boardService.boardUpdateOk(mv);
		
		return mv;
	}
}
