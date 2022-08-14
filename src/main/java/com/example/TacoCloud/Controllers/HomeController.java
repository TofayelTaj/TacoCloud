package com.example.TacoCloud.Controllers;

import com.example.TacoCloud.DomanObject.Ingredient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.TacoCloud.DomanObject.Ingredient.Type;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@GetMapping("/")
	public ModelAndView getHomePage() {
		Ingredient ingredient = new Ingredient(1, "my taco", Type.CHEESE);
		System.out.println(ingredient);
		return new ModelAndView("home");
	}
}
