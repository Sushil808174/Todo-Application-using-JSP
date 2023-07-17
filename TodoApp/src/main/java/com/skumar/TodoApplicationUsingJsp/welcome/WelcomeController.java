package com.skumar.TodoApplicationUsingJsp.welcome;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.security.core.Authentication;

@Controller
@SessionAttributes("name")
public class WelcomeController {
	
	
	@RequestMapping(value ="/",method = RequestMethod.GET)
	public String goToWelcomePage(ModelMap model) {
		model.put("name",getLoggedInUserName());
		return "welcome";
	}
	
	private String getLoggedInUserName() {
		Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}
