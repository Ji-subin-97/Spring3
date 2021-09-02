package com.iu.s1.bankbook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyJunitTest;

public class BankbookDAOTest extends MyJunitTest{
	
	@Autowired
	private BankBookDAO bankbookDAO;
	
	//@Test
	public void getSelectTest() {
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(1);
		bankBookDTO = bankbookDAO.getSelect(bankBookDTO);
		System.out.println(bankBookDTO.getBookName());
		assertNotNull(bankBookDTO);
	}
	
	//@Test
	public void getListTest() {
		List<BankBookDTO> ar = bankbookDAO.getList();
		assertNotEquals(0, ar.size());
	}
	
//	@Test
	public void setInsertTest() {
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookName("Spring");
		bankBookDTO.setBookRate(3.35);
		bankBookDTO.setBookSale(1);
		int result = bankbookDAO.setInsert(bankBookDTO);
		assertEquals(1, result);
	}
	
	@Test
	public void setDeleteTest() {
		int result = bankbookDAO.setDelete(999);
		assertEquals(1, result);
	}
}
