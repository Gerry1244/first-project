package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Adder;
import com.example.demo.models.Whisper;
import com.example.demo.models.Yeller;

@Controller
@RequestMapping({"/", "/HelloWorld"})
public class HelloWorldController {
	
	private String title;
	
	public HelloWorldController() {
		title = "Hello Java and Spring!";
	}
	
	@GetMapping("")
	public String index() {
		return "helloworld/index";
	}
	
	//Create a class named Whisperer that makes Strings lower case
	//Using the method below, create a method named "whisper' for a Getmapping that does essentially the same thing *BUT* uses Whisperer.
	//This means that you should map a GT to the path "whisper"
	//This means you should have a method named'whisper' that returns a ModelAndView
	
/*	
	@GetMapping("Whisper")
	public ModelAndView whisper(@RequestParam(required=false, defaultValue="«silence»") String message) { 
		ModelAndView mv = new ModelAndView("helloworld/message");
		// added next two lines 
		Whisper theThingThatMakesLowerCase = new Whisper (message);
		String lowercase = theThingThatMakesLowerCase.makelower();
		mv.addObject("title", title);
		mv.addObject("message", lowercase);
		return mv;
	}
*/
	
	@GetMapping("whisper")
	public ModelAndView Whisper(@RequestParam(required=false, defaultValue="«silence»") String message) {
	ModelAndView mv = new ModelAndView("helloworld/message");
	mv.addObject("title", title);
	Whisper whisper = new Whisper(message);
	String result = whisper.makelower();
	mv.addObject("message", result);
	return mv;
	}
	
	
	@GetMapping("message")
	public ModelAndView message(@RequestParam(required=false, defaultValue="«silence»") String submittedMessage) { 
		ModelAndView mv = new ModelAndView("helloworld/message");
		// added next two lines 
		Yeller yeller = new Yeller(submittedMessage);
		String resultingLoudWords = yeller.makeupper();
		mv.addObject("title", title);
		mv.addObject("message", resultingLoudWords);
		return mv;
	}
/* 	New lines
	@GetMapping("message")
	public ModelAndView message(@RequestParam(required=false, defaultValue="«silence»") String submittedMessage) { 
		ModelAndView mv = new ModelAndView("helloworld/message");
		// added next two lines 
		Yeller yeller = new Yeller(submittedMessage);
		String resultingLoudWords = yeller.lowercase();
		mv.addObject("title", title);
		mv.addObject("message", resultingLoudWords);
		return mv;

	 
	@PostMapping("adder")
	public String addTwoNumbers(@RequestParam(name="left") int first, @RequestParam(name="right") double second, Model model) {
		Adder adder = new Adder(first, second);
		double result = adder.calculate();
		

		
		model.addAttribute("sum", result);
		return "helloworld/sum-result";
	}
*/	
	
}
