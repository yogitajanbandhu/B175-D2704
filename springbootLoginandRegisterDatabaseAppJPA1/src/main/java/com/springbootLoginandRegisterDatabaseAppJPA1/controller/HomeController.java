package com.springbootLoginandRegisterDatabaseAppJPA1.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springbootLoginandRegisterDatabaseAppJPA1.model.Student;
import com.springbootLoginandRegisterDatabaseAppJPA1.service.StudentServiceI;

@Controller
public class HomeController {

	@Autowired
	StudentServiceI ssi;
	
	@RequestMapping("/")
	public String preLogin()
	{
		System.out.println("in prelogin");
		return "login";
	}
	
	@RequestMapping("/register")
	public String preRegister()
	{
		System.out.println("in register");
		return "register";
	}
	
	@RequestMapping("/save")
	public String registerdata(@ModelAttribute Student s, Model m)
	{
		System.out.println("in save");
	    ssi.saveData(s);

		return "login";
	}
	
	@RequestMapping("/login")
	public String loginStudent(@RequestParam String username,@RequestParam String password,Model m1)
	{
		List<Student> list= ssi.loginStudent(username, password);
		
		if(!list.isEmpty()) {
			m1.addAttribute("dataadd",list);
			return "success";
			//return this.paging(0, m1);
		}
		else
		{
			return "login";
		}
	}
	
	
	@RequestMapping("/delete")
	public String deleteStudent(@RequestParam int rollno,Model m)
	{
		            List<Student> l= ssi.deleteStudent(rollno);
		            m.addAttribute("dataadd",l);
		            return "success";
		            
	}
	
	@RequestMapping("/edit")
	public String editStudent(@RequestParam int rollno,Model m)
	{
		       Student s= ssi.editStudent(rollno);
		       
		       m.addAttribute("dataadd",s);
		
		return "edit";
	}
	
	@RequestMapping("/update")
	public String updateStudent(@ModelAttribute Student s, Model m)
	{
		       List<Student> list =ssi.updateStudent(s);
		       
		       m.addAttribute("dataadd",list);
		       
		       return "success";
	}
	
	@RequestMapping("/paging")
	public String paging(@RequestParam int pageNo,Model m)
	{
		          List<Student> s =ssi.paging(pageNo,3);
		           
		          m.addAttribute("dataadd",s);
		          
		          return "success";
	}
	
}

