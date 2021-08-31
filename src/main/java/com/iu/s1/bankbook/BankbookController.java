package com.iu.s1.bankbook;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.util.DBConnector;

@Controller  // 해당 클래스의 객체를 만들어 주세요.
@RequestMapping("/bankbook/*")
public class BankbookController {
	//pojo (Plain Old Java Object)
	
	@Autowired
	private BankbookService bankbookService;
	
	@RequestMapping(value = "bankbookList.do", method = RequestMethod.GET)   // 파싱작업
	public ModelAndView list(ModelAndView mv) {
		
		ArrayList<BankBookDTO> ar = bankbookService.getList();
		System.out.println("bankbook리스트 입니다.");
		
		//ModelAndView mv = new ModelAndView();
		mv.addObject("list", ar);
		mv.setViewName("bankbook/bankbookList");
		return mv;
	}
	
	@RequestMapping("bankbookSelect.do")
	public void select(@RequestParam(defaultValue = "1", value= "n") Integer num, String name , Model model) {

		System.out.println("num : " + num);
		System.out.println("name : " + name);
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookName("BookName");
		
		model.addAttribute("dto", bankBookDTO);
		model.addAttribute("test", "iu");
		// return "bankbook/bankbookSelect";
	}
	
	@RequestMapping("bankbookInsert.do")
	public String insert(BankBookDTO bankBookDTO) {
		System.out.println(bankBookDTO.getBookName());
		System.out.println("insert");
		return "redirect:../";
	}
}
