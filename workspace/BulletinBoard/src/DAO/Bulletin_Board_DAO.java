package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

import DTO.Bulletin_Board_DTO;

public class Bulletin_Board_DAO {

	public static Bulletin_Board_DAO instance=null;
	public static Bulletin_Board_DAO  getInstance() {
		if(instance==null) {
			instance= new Bulletin_Board_DAO();
		}
		return instance;
	}

	private BasicDataSource bds = new BasicDataSource();

	private Bulletin_Board_DAO() {
		this.bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		this.bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		this.bds.setUsername("Bulletin_Board");
		this.bds.setPassword("Bulletin_Board");
		this.bds.setInitialSize(30);
	}

	private Connection getConnection() throws Exception {
		return this.bds.getConnection();
	}

	//insert
	public int insertText(Bulletin_Board_DTO dto) throws Exception {
		int result=0;
		String sql="insert into Bulletin_Board values(Bulletin_Board_seq.nextval,?,?,sysdate)";
		try(
				Connection con=getConnection();
				PreparedStatement pstat=con.prepareStatement(sql);
				){
			pstat.setString(1, dto.getWriter());
			pstat.setString(2, dto.getText());
			result=pstat.executeUpdate();
			con.commit();
		}
		return result;
	}

	//checkWriterExist
	public boolean isWriterExist(String writer) throws Exception {
		boolean isWriterExist=false;
		String sql="select * from Bulletin_Board where writer=?";
		try(
				Connection con = getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setString(1, writer);
			try(ResultSet rs = pstat.executeQuery();){
				if(rs.next()) {
					isWriterExist=true;
				}
			}
		}
		return isWriterExist;
	}

	//update
	public int updateText(String writer,String updateWriter,String updateText) throws Exception{
		int result=0;
		String sql="update Bulletin_Board set writer=?,text=? where writer=?";
		try(
				Connection con = getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setString(1, updateWriter);
			pstat.setString(2, updateText);
			pstat.setString(3, writer);
			result=pstat.executeUpdate();
			con.commit();
		}
		return result;
	}



	//selectAll
	public List<Bulletin_Board_DTO> selectAll() throws Exception {
		String sql="select * from Bulletin_Board order by 1";
		List<Bulletin_Board_DTO>list = new ArrayList<>();
		try(
				Connection con=getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery();
				){
			while(rs.next()) {
				int text_num=rs.getInt("text_num");
				String writer=rs.getString("writer");
				String text=rs.getString("text");
				Timestamp write_time=rs.getTimestamp("write_time");
				list.add(new Bulletin_Board_DTO(text_num,writer,text,write_time));
			}
			return list;
		}
	}

	//checkTextExist
	public boolean checkTextExist(int deleteTextNum) throws Exception {
		boolean isTextExist=false;
		String sql="select * from Bulletin_Board where text_num = "+deleteTextNum+" ";
		try(
				Connection con = getConnection();
				Statement stat= con.createStatement();
				ResultSet rs = stat.executeQuery(sql);
				){
			if(rs.next()) {
				isTextExist=true;
			}
		}
		return isTextExist;
	}

	//delete
	public int deleteText(int deleteTextNum) throws Exception {
		int result=0;
		String sql="delete from Bulletin_Board where text_num= "+deleteTextNum+"";
		try(
				Connection con = getConnection();
				Statement stat=con.createStatement();){
			result=stat.executeUpdate(sql);
			con.commit();
		}
		return result;
	}

	//search
	public List<Bulletin_Board_DTO> searchText(String writer) throws Exception{
		int result=0;
		List<Bulletin_Board_DTO>list=new ArrayList<>();
		String sql="select * from Bulletin_Board where writer=? order by 1";
		try(
				Connection con=getConnection();
				PreparedStatement pstat=con.prepareStatement(sql);){
			pstat.setString(1, writer);
			try(ResultSet rs= pstat.executeQuery();){
				while(rs.next()) {
					int text_num=rs.getInt("text_num");
					String writer_name=rs.getString("writer");
					String text=rs.getString("text");
					Timestamp write_time=rs.getTimestamp("write_time");
					list.add(new Bulletin_Board_DTO(text_num,writer_name,text,write_time));
				}
			}
		}
		return list;
	}


	//transformTime
	public String getTransformedTime(Timestamp write_time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String formedTime=sdf.format(write_time);
		return formedTime;
	}
}
