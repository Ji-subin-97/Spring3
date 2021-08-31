package com.iu.s1.bankbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;


public class BankBookDAO {
	
	@Autowired
	private DataSource dataSource;
	
	//setInsert
	public int setInsert(String bookName, String bookRate, String bookSale) {
		
		Connection con = null;
		try {
			con = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement st = null;
		int result = 0;
		
		String sql = "insert into bankbook (bookNumber, bookName, bookRate, bookSale)"
				+ "values (BANKBOOK_SEQ.NEXTVAL,?,?,?)";
		
		try {
			st = con.prepareStatement(sql);
			st.setString(1, bookName);
			st.setDouble(2, Double.parseDouble(bookRate));
			st.setInt(3, Integer.parseInt(bookSale));
			
			result = st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		}
		
		return result;
	}
	
	
	//getList
	public ArrayList<BankBookDTO> getList() {
		Connection con = null;
		try {
			con = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<BankBookDTO> ar = new ArrayList<BankBookDTO>();
		
		String sql= "select * from bankbook";
		
		try {
			st = con.prepareStatement(sql);
			
			rs = st.executeQuery();
			
			while(rs.next()) {
				BankBookDTO bankBookDTO = new BankBookDTO();
				bankBookDTO.setBookNumber(rs.getLong("bookNumber"));
				bankBookDTO.setBookName(rs.getString("bookName"));
				bankBookDTO.setBookRate(rs.getDouble("bookRate"));
				bankBookDTO.setBookSale(rs.getInt("bookSale"));
				ar.add(bankBookDTO);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		}
		
		return ar;
		
	}
	
	public BankBookDTO getSelect(BankBookDTO bankBookDTO) {
		
		Connection con = null;
		try {
			con = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Con : "+con);
		PreparedStatement st=null;
		ResultSet rs = null;
		BankBookDTO result=null;
		String sql ="SELECT * FROM BANKBOOK WHERE BOOKNUMBER=?";
		
		try {
			st = con.prepareStatement(sql);
			
			st.setLong(1, bankBookDTO.getBookNumber());
			
			rs = st.executeQuery();
			
			if(rs.next()) {
				result = new BankBookDTO();
				result.setBookNumber(rs.getLong("bookNumber"));
				result.setBookName(rs.getString("bookName"));
				result.setBookRate(rs.getDouble("bookRate"));
				result.setBookSale(rs.getInt("bookSale"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		}
		
		return result;
		
	}
	

}
