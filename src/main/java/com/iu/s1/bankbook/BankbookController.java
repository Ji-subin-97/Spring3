package com.iu.s1.bankbook;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.util.Pager;

@Controller  // 해당 클래스의 객체를 만들어 주세요.
@RequestMapping("/bankbook/*")
public class BankbookController {
	//pojo (Plain Old Java Object)
	
	@Autowired
	private BankBookService bankbookService;
	
	@RequestMapping(value = "bankbookList")   // 파싱작업
	public ModelAndView list(ModelAndView mv, Pager pager) {
	
		List<BankBookDTO> ar = bankbookService.getList(pager);
		mv.addObject("list", ar);
		mv.setViewName("bankbook/bankbookList");
		
		return mv;
	}
	
	@RequestMapping("bankbookSelect")
	public void select(BankBookDTO bankBookDTO, Model model) {
		
		bankBookDTO = bankbookService.getSelect(bankBookDTO);
		model.addAttribute("dtov",bankBookDTO);	
	}
	
	@RequestMapping("bankbookInsert")
	public void insert() {}

	@RequestMapping(value = "bankbookInsert", method = {RequestMethod.POST})
	public String insert(BankBookDTO bankBookDTO) {
		System.out.println(bankBookDTO.getBookName());
		int result = bankbookService.setInsert(bankBookDTO);
		
		return "redirect:./bankbookList";
		
	}
	
	@RequestMapping("bankbookDelete")
	public String delete(Integer bookNumber) {
		int result = bankbookService.setDelete(bookNumber);
		
		return "redirect:./bankbookList";
	}
	
	@RequestMapping("bankbookUpdate")
	public void update(BankBookDTO bankBookDTO, Model model) {
		bankBookDTO = bankbookService.getSelect(bankBookDTO);
		model.addAttribute("dtov", bankBookDTO);
	}
	
	@RequestMapping(value = "bankbookUpdate", method = {RequestMethod.POST})
	public String update(BankBookDTO bankBookDTO) {
		System.out.println(bankBookDTO.getBookName());
		int result = bankbookService.setUpdate(bankBookDTO);
		
		return "redirect:./bankbookList";
	}
	
	
}
