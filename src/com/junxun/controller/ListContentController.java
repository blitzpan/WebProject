package com.junxun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.junxun.service.ListContentService;

@Controller
public class ListContentController {
	@Autowired
	private ListContentService listContentService;
	
	@RequestMapping("/listContent")
	public ModelAndView listContent(){
		try{
			
		}catch(Exception e){
			e.printStackTrace();
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "hello world!");
		mv.setViewName("index");
		return mv;
	}

	public ListContentService getListContentService() {
		return listContentService;
	}

	public void setListContentService(ListContentService listContentService) {
		this.listContentService = listContentService;
	}
}
