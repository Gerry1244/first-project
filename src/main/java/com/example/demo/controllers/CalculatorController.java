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
	public String addTwoNumbers(
			@RequestParam(name = "left") int first, 
			@RequestParam(name = "right") double second,
			@RequestParam(name = "value", required=false) String value, 
			@RequestParam(name = "mathOperations", required=false) String mathOperations,
			Model model) {
		
		Calculator calc = new Calculator(first, second);
		Double result = null;

		if (mathOperations.equals("Add")) {
			result = calc.adder();
			
		} 
		else if (mathOperations.equals("Subtract")) {
			result = calc.subtractor();
				
		} 
		
		else if (mathOperations.equals("Multiply")) {
			result = calc.multiplier();
			
		
		} 
		else if (mathOperations.equals("Divide")) {
			result = calc.divider();
			
		} 
		
		else if (mathOperations.equals("Modulus")) {
			result = calc.modulus();	
			
		} else {
			result = calc.exponent();
		}
	 
	model.addAttribute("sum", result);
	return "Calculator/calculator-result";	
	}
		
	@GetMapping("")
	public String adder(Model model) {
		return "Calculator/calculator-form";
		
		
	}
	
}
