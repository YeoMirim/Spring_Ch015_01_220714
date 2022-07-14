// [방법 3 - pom.xml에 내용 추가]


package com.mirim.ch1501;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mirim.Ch1504Dto.Member;

@Controller
public class LoginController {
	

	@RequestMapping("/loginForm") 
	public String loginForm() {
	
		return "login"; 
	}

/*	
	@RequestMapping("/loginOk")
	public String loginOk(Member member, BindingResult result) {
		
		String view = "loginOk";
		
		MemberValidator validator = new MemberValidator();
		validator.validate(member, result);
		if (result.hasErrors()) {		// 에러가 발생하면
			view = "login";				// 다시 loginForm 페이지로 되돌아감
		}
		
		return view;
	}
*/	
	
	
	@RequestMapping("/loginOk")
	public String loginOk(@Valid Member member, BindingResult result) {
		
		String view = "loginOk";
		
		if (result.hasErrors()) {		// 에러가 발생하면
			view = "login";				// 다시 loginForm 페이지로 되돌아감
		}
		
		return view;
	}
	
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new MemberValidator());
	}
}
