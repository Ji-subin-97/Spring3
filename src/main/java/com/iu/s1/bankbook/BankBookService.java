package com.iu.s1.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s1.util.Pager;

@Service
public class BankBookService {
	
	@Autowired
	private BankBookDAO bankBookDAO;
	
	public BankBookDTO getSelect(BankBookDTO bankBookDTO) {
		return bankBookDAO.getSelect(bankBookDTO);
	}
	
	public List<BankBookDTO> getList(Pager pager) {
		System.out.println(pager.getKind());
		System.out.println(pager.getSearch());
		//totalCount 구하기
		Long totalCount = bankBookDAO.getCount(pager);
		pager.makeNum(totalCount);
		pager.makeRow();
		return bankBookDAO.getList(pager);
	}
	
	public int setInsert(BankBookDTO bankBookDTO) {
		return bankBookDAO.setInsert(bankBookDTO);
	}
	
	public int setDelete(Integer bookNumber) {
		return bankBookDAO.setDelete(bookNumber);
	}
	
	public int setUpdate(BankBookDTO bankBookDTO) {
		return bankBookDAO.setUpdate(bankBookDTO);
	}
}
