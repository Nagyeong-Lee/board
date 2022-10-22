package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

import dto.DTO;



public class DAO {

	public static DAO instance=null;
	public synchronized static DAO getInstance() {
		if(instance==null) {
			instance=new DAO();
		}
		return instance;
	}
	
	
	private DAO () {

		this.bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		this.bds.setUsername("gb");
		this.bds.setPassword("1234");
		this.bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		this.bds.setInitialSize(30);
	}

	private BasicDataSource bds = new BasicDataSource();
	private Connection getConnection() throws Exception{

			return bds.getConnection();
	}

	public int insert(DTO dto) throws Exception{

		String sql=

				"insert into guestbook values(guestbook_seq.nextval,?,?,sysdate)";

		try(Connection con = getConnection();

				PreparedStatement pstat=con.prepareStatement(sql);){

			pstat.setString(1, dto.getWriter());

			pstat.setString(2, dto.getText());

			int result=pstat.executeUpdate();

			con.commit();

			return result;

		}

	}



	public int delete(int delWrite_num) throws Exception{

		String sql="delete from guestbook where write_num=?";

		try(Connection con = getConnection();

				PreparedStatement pstat=con.prepareStatement(sql);){

			pstat.setInt(1, delWrite_num);

			int result=pstat.executeUpdate();

			con.commit();

			return result;

		}

	}



	public int update(DTO dto) throws Exception{

		String sql=

				"update guestbook set writer=?,text=? where write_num=? ";

		try(Connection con = getConnection();

				PreparedStatement pstat= con.prepareStatement(sql);){

			pstat.setString(1, dto.getWriter());

			pstat.setString(2, dto.getText());

			pstat.setInt(3, dto.getWrite_num());

			int result=pstat.executeUpdate();

			con.commit();

			return result;



		}

	}





	public List<DTO> search(String searchName) throws Exception {

		String sql=

				"select * from guestbook where writer=?";

		try(Connection con = getConnection();

				PreparedStatement pstat=con.prepareStatement(sql);){

			pstat.setString(1, searchName);

			try(ResultSet rs = pstat.executeQuery();){

				List<DTO> result=new ArrayList<>();

				while(rs.next()) {

					int write_num=rs.getInt("write_num");

					String writer=rs.getString("writer");

					String text=rs.getString("text");

					Timestamp write_date=rs.getTimestamp("write_date");

					result.add(new DTO(write_num,writer,text,write_date));

				}

				return result;



			}

		}

	}



	public List<DTO> selectAll() throws Exception{

		String sql="select * from guestbook order by 1";

		try(Connection con = getConnection();

				PreparedStatement pstat=con.prepareStatement(sql);

				ResultSet rs = pstat.executeQuery();){

			List<DTO>result=new ArrayList<>();

			while(rs.next()) {

				int write_num=rs.getInt("write_num");

				String writer=rs.getString("writer");

				String text=rs.getString("text");

				Timestamp write_date=rs.getTimestamp("write_date");

				result.add(new DTO(write_num,writer,text,write_date));

			}

			return result;

		}

	}

}

