package com.iu.s1.bankbook;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyJunitTest;

public class BankbookDAOTest extends MyJunitTest{
	
	@Autowired
	private BankBookDAO bankbookDAO;
	
	//@Test
	public void setUpdateTest() {
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(1111);
		bankBookDTO.setBookName("Pizza");
		bankBookDTO.setBookRate(1.77);
		bankBookDTO.setBookSale(1);
		int result = bankbookDAO.setUpdate(bankBookDTO);
		assertNotEquals(0, result);
	}
	
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
	
	@Test
	public void setInsertTest() throws Exception{
		
		Random random = new Random();
		for(int i=0; i<200; i++) {
			
			BankBookDTO bankBookDTO = new BankBookDTO();
			bankBookDTO.setBookName("BookName" + i);
			int rate = random.nextInt(400);
			
			bankBookDTO.setBookRate(rate/100.0);
			bankBookDTO.setBookSale(random.nextInt(2));
			int result = bankbookDAO.setInsert(bankBookDTO);
			
			if(i%10==0) {
				Thread.sleep(500);
			}
		}
		
		System.out.println("Finish=====================================");
	}
	
	//@Test
	public void setDeleteTest() {
		int result = bankbookDAO.setDelete(999);
		assertEquals(1, result);
	}
}
