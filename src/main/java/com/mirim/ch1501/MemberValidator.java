package com.mirim.ch1501;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mirim.Ch1504Dto.Member;

public class MemberValidator implements Validator {		// 추상메소드 오버라이딩 강제함

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Member.class.isAssignableFrom(clazz);		
		// 검증할 객체의 클래스 타입 정보 반환
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
		Member member = (Member) target;		// 검증할 객체를 target에 담아줘야함, 최상위 개념의 Object를 상속 받으므로 Member로 캐스팅 해줘야함
/*		[방법 1- validate사용]	
		String id = member.getId();
		if (id == null || id.trim().isEmpty()) {	// 아이디 공백 유무 확인
			System.out.println("ID is Null...!!");
			errors.rejectValue("id", "ID is Null"); 		// 에러 발생시킴("에러명(속성값)", "에러내용")
		}
*/
		
///*		[방법 2 - ValidationUtils 사용]		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "ID is Null");
//*/		
			
		
		String pw = member.getPw();
		if (pw == null || pw.trim().isEmpty()) {	// 비밀번호 공백 유무 확인
			System.out.println("Password is Null...!!");
			errors.rejectValue("pw", "Password is Null");  // 에러 발생시킴("에러명(속성값)", "에러내용")
		}
		
	}  // 실제 검증할 내용

	
}
