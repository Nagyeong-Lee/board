package dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.dbcp2.BasicDataSource;

import dto.DTO;

public class DAO {


	// DAO
	private static DAO instance = null;

	public static DAO getInstance() {

		if (instance == null) {
			instance = new DAO();
			return instance;
		}
		return instance;
	}

	private BasicDataSource bds = new BasicDataSource();

	private DAO() { // 생성자 접근제한자 변경 (Singleton)


		this.bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		this.bds.setUsername("kh");
		this.bds.setPassword("kh");
		this.bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		this.bds.setInitialSize(30); 
	}
	private Connection getConnection() throws Exception{

		return bds.getConnection();
		
	}


	public boolean login(String uId, String uPw) throws Exception {
		String sql = "select * from User_Account where Id = ? and Pw = ?";

		try (Connection con = getConnection(); PreparedStatement pstat = con.prepareStatement(sql);) {
			pstat.setString(1, uId);
			pstat.setString(2, uPw);
			try (ResultSet rs = pstat.executeQuery();) {
				return rs.next();

			}

		}

	}

	public int createAccount(DTO dto) throws Exception { // 회원가입

		String sql = "insert into User_ACCOUNT values(?,?)";

		try (Connection con = getConnection(); PreparedStatement pstat = con.prepareStatement(sql);) {

			pstat.setString(1, dto.getuId());
			pstat.setString(2, dto.getPw());
			int result = pstat.executeUpdate();
			con.commit();
			return result;
		}
	}
	public static String getSHA512(String input){

		String toReturn = null;
		try {
		    MessageDigest digest = MessageDigest.getInstance("SHA-512");
		    digest.reset();
		    digest.update(input.getBytes("utf8"));
		    toReturn = String.format("%0128x", new BigInteger(1, digest.digest()));
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		return toReturn;
	    }

}