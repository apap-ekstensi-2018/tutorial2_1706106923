package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	
		@RequestMapping("/hello")
		public String index()
		{
			return "hello";
		}
		
//		@RequestMapping("/greeting")
//		public String greeting(@RequestParam(value="name",required=false,defaultValue="dunia") String name, Model model)
//		{
//			model.addAttribute("name",name);
//			return "greeting";
//		}

		@RequestMapping(value= {"/greeting","greeting/{name}"})
		public String greetingPath(@PathVariable Optional<String> name, Model model)
		{
			if(name.isPresent()) {
				model.addAttribute("name",name.get());
			}else {
				model.addAttribute("name","apap");
			}
			return "greeting";
		}
		
		@RequestMapping("/greeting")
		public String greeting(@RequestParam(value="name",required=false,defaultValue="dunia") String name, Model model)
		{
			model.addAttribute("name",name);
			return "greeting";
		}
		
		@RequestMapping("/perkalian")
		public String getitem(
				@RequestParam(value="a",defaultValue="0") Integer aa,
				@RequestParam(value="b",defaultValue="0") Integer bb,
				Model model)
		{
				model.addAttribute("aa",aa);
				model.addAttribute("bb",bb);
				model.addAttribute("cc",aa*bb);
		    return "perkalian";
		}

}
