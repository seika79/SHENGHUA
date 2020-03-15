package com.main.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.board.dto.BoardDto;
import com.main.service.MainService;

@Controller
public class MainController {

	@Autowired
	private MainService mainService;
	
	private void setMainService(MainService mainService){
		this.mainService = mainService;
	}
	
	@RequestMapping(value="/main.do")
	public ModelAndView mainList() throws Exception{

		ArrayList<BoardDto> boardList = mainService.mainBoardList();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		mav.addObject("mainBoard", boardList);
		
		
		return mav;
	}
}
