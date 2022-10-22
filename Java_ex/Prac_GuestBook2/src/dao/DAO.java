package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

import dto.DTO;

public class DAO {


	private BasicDataSource bds = new BasicDataSource();
	private DAO() {
		bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		bds.setUsername("kh");
		bds.setPassword("kh");
		bds.setInitialSize(30);
	}

	private static DAO instance=null;
	public static DAO getInstance() {
		if(instance==null) {
			instance=new DAO();
		}
		return instance;
	}

	private Connection getConnection() throws Exception{
		return bds.getConnection();
	}

	public int insert(DTO dto) throws Exception{
		String sql="insert into gb values(gb_seq.nextval,?,?,sysdate)";
		try(Connection con = getConnection();
				PreparedStatement pstat=con.prepareStatement(sql);){
			pstat.setString(1, dto.getWriter());
			pstat.setString(2, dto.getText());
			int result=pstat.executeUpdate();
			con.commit();
			return result;
		}
	}

	public List<DTO> selectAll() throws Exception{
		String sql="select * from gb order by 1";
		try(Connection con = getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery();){
			List<DTO>list=new ArrayList<>();
			while(rs.next()) {
				int text_num=rs.getInt("text_num");
				String writer=rs.getString("writer");
				String text=rs.getString("text");
				Timestamp write_time=rs.getTimestamp("write_time");
				list.add(new DTO(text_num,writer,text,write_time));
			}
			return list;
		}
	}

	public boolean isText_numExist(int text_num) throws Exception {
		String sql="select * from gb where text_num=?";
		try(Connection con = getConnection();
				PreparedStatement pstat=con.prepareStatement(sql);){
			pstat.setInt(1, text_num);
			try(ResultSet rs = pstat.executeQuery();){
				boolean result=false;
				while(rs.next()) {
					result=true;
				}
				return result;
			}
		}
	}

	public boolean isWriterExist(String writer) throws Exception {
		boolean result=false;
		String sql="select * from gb where writer=?";
		try(Connection con = getConnection();
				PreparedStatement pstat=con.prepareStatement(sql);){
			pstat.setString(1, writer);
			try(ResultSet rs=pstat.executeQuery();){
				while(rs.next()) {
					result=true;
				}
			}
			return result;
		}

	}

	public int deleteByText_num(int text_num) throws Exception {
		String sql="delete from gb where text_num=?";
		try(Connection con = getConnection();
				PreparedStatement pstat=con.prepareStatement(sql);){
			pstat.setInt(1, text_num);
			int result=pstat.executeUpdate();
			con.commit();
			return result;
		}

	}

	public int update(DTO dto) throws Exception {
		String sql="update gb set writer=?,text=?,write_time=sysdate where text_num=? ";
		try(Connection con = getConnection();
				PreparedStatement pstat=con.prepareStatement(sql);){
			pstat.setString(1, dto.getWriter());
			pstat.setString(2, dto.getText());
			//			pstat.setDate(3, dto.getWrite_time());
			pstat.setInt(3, dto.getText_num());
			int result=pstat.executeUpdate();
			con.commit();
			return result;
		}
	}

	public List<DTO> searchByText_num(int text_num) throws Exception {
		List<DTO>list=new ArrayList<>();
		String sql="select * from gb where text_num=? ";
		try(Connection con = getConnection();
				PreparedStatement pstat=con.prepareStatement(sql);){
			pstat.setInt(1, text_num);
			try(ResultSet rs = pstat.executeQuery();){
				while(rs.next()) {
					int text_num2=rs.getInt("text_num");
					String writer=rs.getString("writer");
					String text=rs.getString("text");
					Timestamp write_time=rs.getTimestamp("write_time");
					list.add(new DTO(text_num2,writer,text,write_time));
				}
				return list;
			}
		}
	}

	public List<DTO> searchByWriter(String writer) throws Exception {
		List<DTO>list=new ArrayList<>();
		String sql="select * from gb where writer=? ";
		try(Connection con = getConnection();
				PreparedStatement pstat=con.prepareStatement(sql);){
			pstat.setString(1, writer);
			try(ResultSet rs = pstat.executeQuery();){
				while(rs.next()) {
					int text_num=rs.getInt("text_num");
					String writer2=rs.getString("writer");
					String text=rs.getString("text");
					Timestamp write_time=rs.getTimestamp("write_time");		
					list.add(new DTO(text_num,writer2,text,write_time));
				}
				return list;
			}
		}
	}
}
