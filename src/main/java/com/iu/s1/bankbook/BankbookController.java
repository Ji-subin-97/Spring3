package com.iu.s1.bankbook;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller  // 해당 클래스의 객체를 만들어 주세요.
@RequestMapping("/bankbook/*")
public class BankbookController {
	//pojo (Plain Old Java Object)
	
	@RequestMapping(value = "bankbookList.do", method = RequestMethod.GET)   // 파싱작업
	public String list() {
		System.out.println("bankbook리스트 입니다.");
		return "bankbook/bankbookList";
	}
	
	@RequestMapping("bankbookSelect.do")
	public String select(int num, String name) {

		System.out.println("num : " + num);
		System.out.println("name : " + name);
		return "bankbook/bankbookSelect";
	}
}
