package dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.MembersDTO;

public class MembersDAO {

	private static MembersDAO instance=null;
	public static MembersDAO getInstance() {
		if(instance==null) {
			instance=new MembersDAO();
		}
		return instance;
	}
	private MembersDAO() {}
	private Connection getConnection() throws Exception {

		Context cx= new InitialContext();
		DataSource ds = (DataSource)cx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();

	}

	//아이디 중복검사
	public boolean isIdExist(String id) throws Exception {
		boolean result=false;
		String sql="select * from members where id=?";
		try(
				Connection con = getConnection();
				PreparedStatement pstat=con.prepareStatement(sql);){
			pstat.setString(1,id);
			try(
					ResultSet rs = pstat.executeQuery();){
				if(rs.next()) {
					result=true;
				}
			}
			return result;
		}
	}



	//비밀번호 암호화
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

	//insert
	public int insert(MembersDTO dto) throws Exception {
		int result=0;
		String sql="insert into members values(?,?,?,?,?,?,?,?,sysdate)";
		try(
				Connection con = getConnection();
				PreparedStatement pstat=con.prepareStatement(sql);){
			pstat.setString(1,dto.getId());
			pstat.setString(2,getSHA512(dto.getPw()));
			pstat.setString(3,dto.getName());
			pstat.setString(4,dto.getPhone());
			pstat.setString(5,dto.getEmail());
			pstat.setString(6,dto.getZipcode());
			pstat.setString(7,dto.getAddress1());
			pstat.setString(8,dto.getAddress2());
			System.out.println("ID :"+dto.getId());
			System.out.println("pw :"+dto.getPw());
			System.out.println("name :"+dto.getName());
			System.out.println("ph :"+dto.getPhone());
			System.out.println("em :"+dto.getEmail());
			System.out.println("zc :"+dto.getZipcode());
			System.out.println("ad1 :"+dto.getAddress1());
			System.out.println("ad2 :"+dto.getAddress2());
			result=pstat.executeUpdate();
			con.commit();
			
		}
		return result;
	}

	//isAccountExist
	public boolean isLoginAvailable(String loginID,String loginPW)throws Exception {
		boolean result=false;
		String sql="select * from members where id=? and pw=?";
		try(
				Connection con = getConnection();
				PreparedStatement pstat=con.prepareStatement(sql);){
			pstat.setString(1,loginID);
			pstat.setString(2,loginPW);
			try(
					ResultSet rs = pstat.executeQuery();){
				if(rs.next()) {
					result=true;
				}
			}
		}
		return result;
	}
	
	//탈퇴하기
	public int delAccount(String loginID) throws Exception {
		int result=0;
		String sql="delete from members where id=?";
		try(
				Connection con = getConnection();
				PreparedStatement pstat=con.prepareStatement(sql);){
			pstat.setString(1,loginID);
			result=pstat.executeUpdate();
			con.commit();
		}
		return result;
	}

	//마이페이지 출력
	public List<MembersDTO> selectAll(String loginID)throws Exception {
		List<MembersDTO>list = new ArrayList<>();
		String sql="select * from members where id=?";
		try(
				Connection con = getConnection();
				PreparedStatement pstat=con.prepareStatement(sql);){
			pstat.setString(1,loginID);
			try(
					ResultSet rs = pstat.executeQuery();){
				if(rs.next()) {
					String id=rs.getString("id");
					String pw=rs.getString("pw");
					String name=rs.getString("name");
					String phone=rs.getString("phone");
					String email=rs.getString("email");
					String zipcode=rs.getString("zipcode");
					String address1=rs.getString("address1");
					String address2=rs.getString("address2");
					list.add(new MembersDTO(id,pw,name,phone,email,zipcode,address1,address2,null));
				}
			}
		}
		return list;
	}
	
	
	//update
	public int update(MembersDTO dto,String loginID) throws Exception {
		int result=0;
		String sql="update members set pw=?,name=?,phone=?,email=?,zipcode=?,address1=?,address2=? where id=?";
		try(
				Connection con = getConnection();
				PreparedStatement pstat=con.prepareStatement(sql);){
			pstat.setString(1,getSHA512(dto.getPw()));
			pstat.setString(2,dto.getName());
			pstat.setString(3,dto.getPhone());
			pstat.setString(4,dto.getEmail());
			pstat.setString(5,dto.getZipcode());
			pstat.setString(6,dto.getAddress1());
			pstat.setString(7,dto.getAddress2());
			pstat.setString(8,loginID);
			System.out.println("ID :"+dto.getId());
			System.out.println("pw :"+dto.getPw());
			System.out.println("name :"+dto.getName());
			System.out.println("ph :"+dto.getPhone());
			System.out.println("em :"+dto.getEmail());
			System.out.println("zc :"+dto.getZipcode());
			System.out.println("ad1 :"+dto.getAddress1());
			System.out.println("ad2 :"+dto.getAddress2());
			result=pstat.executeUpdate();
			con.commit();
		}
		return result;
	}
	
}
