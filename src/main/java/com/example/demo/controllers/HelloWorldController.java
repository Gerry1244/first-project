package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Whisper;
import com.example.demo.models.Yeller;

@Controller
@RequestMapping({ "/", "/HelloWorld" })
public class HelloWorldController {

	private String title;

	public HelloWorldController() {
		title = "Hello Java and Spring!";
	}

	@GetMapping("")
	public String index() {
		return "helloworld/index";
	}

	@GetMapping("whisper")
	public ModelAndView makeThingsQuiet(
			@RequestParam(required = false, defaultValue = "«shhhhhh»") String submittedMessage) {
		Whisper quietMaker = new Whisper(submittedMessage);
		String result = quietMaker.quiet();

		ModelAndView mv = new ModelAndView("helloworld/message");
		mv.addObject("title", title);
		mv.addObject("message", result);
		return mv;
	}

	@GetMapping("message") // URL to which the form submits
	public ModelAndView messageMethod(
			@RequestParam(required = false, defaultValue = "«silence»") String submittedMessage) {
		Yeller asdlkjfnalsdfkj = new Yeller(submittedMessage);
		String result = asdlkjfnalsdfkj.makeUpper();

		ModelAndView mv = new ModelAndView("helloworld/message");
		mv.addObject("title", title);
		mv.addObject("message", result);
		return mv;
	}

	@GetMapping("say-something")
	public String makeAChoice(
		 String submittedMessage,
		 String speechChoice,
		 Model theThingIPutDataIntoTheView
	 ) {
		 //f speechChoice is yell
		 if (speechChoice.equals("yell")) {
		 //make submittedMessage loud
			 Yeller aVariableThatHoldsaYellerObject = new Yeller(submittedMessage);
			 String loud = aVariableThatHoldsaYellerObject.makeUpper();
			 theThingIPutDataIntoTheView.addAttribute("output", loud);
			
		 } else {//otherwise
		 //make submittedMessage quiet
		
			 Whisper someQuietThing = new Whisper(submittedMessage);
			 String quiet = someQuietThing.quiet();
			 theThingIPutDataIntoTheView.addAttribute("output", quiet);
		 }
		 return "helloWorld/mixed-messages";
	 }
}