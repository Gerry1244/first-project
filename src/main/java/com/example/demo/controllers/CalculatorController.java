package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.calculator.Calculator;



@Controller
@RequestMapping("/Calculate")

public class CalculatorController {

	@PostMapping("")
	public ModelAndView addTwoNumbers(
			@RequestParam(name = "left") int first, 
			@RequestParam(name = "right") double second,
			@RequestParam(name = "value", required=false) String value, 
			@RequestParam(name = "mathOperations", required=false) String mathOperations,
			Model model) {
		
		Double result = null;

		if (mathOperations.equals("Add")) {
			Calculator adder = new Calculator(first, second);
			result = adder.adder();
			
		} 
		else if (mathOperations.equals("Subtract")) {
			Calculator subtractor = new Calculator(first, second);
			result = subtractor.subtractor();
				
		} 
		
		else if (mathOperations.equals("Multiply")) {
			Calculator multiplier = new Calculator(first, second);
			result = multiplier.multiplier();
			
		
		} 
		else if (mathOperations.equals("Divide")) {
			Calculator divider = new Calculator(first, second);
			result = divider.divider();
			
		} 
		else if (mathOperations.equals("Modulus")) {
			Calculator modulus = new Calculator(first, second);
			result = modulus.modulus();	
		} 
		
		else { (mathOperations.equals("Exponent")) {
			Calculator exponent = new Calculator(first, second);
			Object function;
			result = exponent.exponent();
		}
		}
	} 
		
		private int modulo() {
		// TODO Auto-generated method stub
		return 0;
	}

		ModelAndView mv = new ModelAndView("Calculator/calculator-result");
		mv.addObject("sum", result);
		return mv;	


	@GetMapping("")
	public String adder(Model model) {
		model.addAttribute("sum", "Enter numbers here");
		return "Calculator/calculator-result";
		
		
	}
}
