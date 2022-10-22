package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

import dto.DTO;

public class DAO {

	private static DAO instance=null;
	public static synchronized DAO getInstance() {
		if(instance==null) {
			instance=new DAO();
		}
		return instance;
	}

	private DAO() {
		bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		bds.setUsername("kh");
		bds.setPassword("kh");
		bds.setInitialSize(30);
	}

	private BasicDataSource bds=new BasicDataSource();

	private Connection getConnection() throws SQLException {
		return bds.getConnection();
	}

	
	public int insert(DTO dto) throws Exception {
		String sql="insert into guestbook values(guestbook_seq.nextval,?,?,sysdate)";
		try(Connection con=getConnection();
				PreparedStatement pstat=con.prepareStatement(sql);){
			pstat.setString(1, dto.getWriter());
			pstat.setString(2, dto.getText());
			int result=pstat.executeUpdate();
			con.commit();
			return result;
		}
	}

	public List<DTO> select() throws Exception{
		String sql="select * from guestbook order by 1";
		try(Connection con=getConnection();
				PreparedStatement pstat=con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery();){
			List<DTO>list = new ArrayList<>();
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

	public boolean isText_NumExist(int text_num) throws Exception {
		String sql="select * from guestbook where text_num=? order by 1 ";
		boolean result=false;
		try(Connection con=getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setInt(1, text_num);
			try(ResultSet rs = pstat.executeQuery();){
				while(rs.next()) {
					result=true;
				}
				return result;
			}
		}
	}

	public int delete(int text_num) throws Exception {
		String sql="delete from guestbook where text_num=?";
		try(Connection con=getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setInt(1, text_num);
			int result=pstat.executeUpdate();
			con.commit();
			return result;
		}
	}

	public int update(DTO dto) throws Exception{
		String sql="update guestbook set writer=?,text=?,write_time=? where text_num=?";
		try(Connection con = getConnection();
				PreparedStatement pstat=con.prepareStatement(sql);){
			pstat.setString(1, dto.getWriter());
			pstat.setString(2, dto.getText());
			pstat.setTimestamp(3, dto.getWrite_time());
			pstat.setInt(4, dto.getText_num());
			int result=pstat.executeUpdate();
			con.commit();
			return result;
		}
	}

	public boolean isWriterExist(String writer) throws Exception{
		String sql="select * from guestbook where writer=?";
		boolean result=false;
		try(Connection con = getConnection();
				PreparedStatement pstat=con.prepareStatement(sql);){
			pstat.setString(1, writer);
			try(ResultSet rs = pstat.executeQuery();){
				while(rs.next()) {
					result=true;
				}
				return result;
			}
		}
	}

	public List<DTO> searchByWriter(String searchWriter) throws Exception{
		String sql="select * from guestbook where writer=?";
		try(Connection con = getConnection();
				PreparedStatement pstat=con.prepareStatement(sql);){
			pstat.setString(1, searchWriter);
			try(ResultSet rs = pstat.executeQuery();){
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
	}
}
