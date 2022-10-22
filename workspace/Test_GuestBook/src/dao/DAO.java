package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.DTO;

public class DAO {


	public int insert(DTO dto) throws SQLException {
		String sql="insert into guestbook values(guestbook_seq.nexval,sysdate,?,?,?)";
		try(Connection con = DriverManager.getConnection(sql);
				PreparedStatement pstat=con.prepareStatement(sql);){
			pstat.setString(1, dto.getWriter());
			pstat.setString(1, dto.getTitle());
			pstat.setString(1, dto.getText());
			int result=pstat.executeUpdate();
			con.commit();
			return result;
		}
	}

	public List<DTO>selectAll() throws SQLException {
		List<DTO>arr=new ArrayList<>();
		String sql="select * from guestbook";
		try(Connection con = DriverManager.getConnection(sql);
				PreparedStatement pstat=con.prepareStatement(sql);){
			try(ResultSet rs=pstat.executeQuery();){
				if(rs.next()) {
					int text_number=rs.getInt("text_number");
					Date write_date=rs.getDate("write_date");
					String writer=rs.getString("writer");
					String title=rs.getString("title");
					String text=rs.getString("text");
					arr.add(new DTO(text_number,write_date,writer,title,text));
				}
				return arr;
			}
		}
	}

	public boolean isTextExistByWriter(String writer) throws SQLException {
		boolean flag=false;
		String sql="select * from guestbook where title=?";
		try(Connection con = DriverManager.getConnection(sql);
				PreparedStatement pstat=con.prepareStatement(sql);){
			pstat.setString(1, writer);
			try(ResultSet rs = pstat.executeQuery();){
				if(rs.next()) {
					flag=true;
				}
			}
			return flag;
		}
	}

	public int deleteByWriter(String writer) throws SQLException {
		String sql="delete from guestbook where writer=?";
		try(Connection con = DriverManager.getConnection(sql);
				PreparedStatement pstat=con.prepareStatement(sql);){
			pstat.setString(1, writer);
			int result=pstat.executeUpdate();
			con.commit();
			return result;
		}
	}

	public boolean isTextExistByTitle(String title) throws SQLException {
		boolean flag=false;
		String sql="select * from guestbook where title=?";
		try(Connection con = DriverManager.getConnection(sql);
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setString(1, title);
			ResultSet rs = pstat.executeQuery();
			if(rs.next()) {
				flag=true;
			}
			return flag;
		}
	}

	public List<DTO> searchByTitle(String inputTitle) throws SQLException {
		List<DTO>arr=new ArrayList<>();
		String sql="select * from guestbook where title=?";
		try(Connection con = DriverManager.getConnection(sql);
				PreparedStatement pstat=con.prepareStatement(sql);){
			pstat.setString(1, inputTitle);
			try(ResultSet rs=pstat.executeQuery();){
				if(rs.next()) {
					int text_number=rs.getInt("text_number");
					Date write_date=rs.getDate("write_date");
					String writer=rs.getString("writer");
					String title=rs.getString("title");
					String text=rs.getString("text");
					arr.add(new DTO(text_number,write_date,writer,title,text));
				}
				return arr;
			}
		}
	}
}
