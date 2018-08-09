package com.marc2web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.marc2web.model.User;


@Controller

public class UserController {
	

	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String  register() 
	{
		return "register";
	}
	

	
	
	@RequestMapping(value="/success",method=RequestMethod.POST)
	public ModelAndView registerSuccess(HttpServletRequest request,HttpServletResponse response) 
	{
	String name=request.getParameter("name");
	int age=Integer.parseInt(request.getParameter("age"));
	String email=request.getParameter("email");
	String city=request.getParameter("city");
		User user= new User(name, age, email, city);
		ModelAndView modelAndView = new ModelAndView("success");
		//List<User> userList=userService.getuserlist();
		modelAndView.addObject("user",user); 
		
        return modelAndView;
        
	}

	//@RequestParam("name")String name,@RequestParam("age") int age,@RequestParam(required=true ,name="email")String email,@RequestParam("city")String city
	//User user= new User(parmap.get("name"),Integer.parseInt(parmap.get("age")),parmap.get("email"),parmap.get("city"));
}
