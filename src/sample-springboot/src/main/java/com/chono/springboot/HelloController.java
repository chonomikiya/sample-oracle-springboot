package com.chono.springboot;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@Autowired
	private UserDataRepository repository;
	
	@RequestMapping("/")
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		List<MyData> list = repository.findAll();
		mav.addObject("datalist", list);
		return mav;
	}
	
	@RequestMapping("/hello")
	public ModelAndView hello(ModelAndView mav) {
		mav.addObject("message", "Hello Thymeleaf");
		return mav;
	}
}
