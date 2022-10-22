package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.DTO;

public class DAO {

	private Connection getConnection() throws Exception{
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String id="cafe";
		String pw="cafe";
		Connection con=DriverManager.getConnection(url, id, pw);
		return con;
	}

	//insert
	public int insert(DTO dto) throws Exception{
		String sql="insert into cafe values(cafe_seq.nextval,?,?,?,?)";
		try(Connection con = getConnection();
				PreparedStatement pstat=con.prepareStatement(sql);){

			pstat.setString(1, dto.getPname());
			pstat.setInt(2, dto.getPprice());
			pstat.setString(3, dto.getIced());
			pstat.setString(4, dto.getTopping());
			int result=pstat.executeUpdate();
			con.commit();
			return result;
		}
	}

	//select
	public List<DTO> select() throws Exception{
		String sql="select * from cafe order by 1";
		try(Connection con=getConnection();
				PreparedStatement pstat=con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery();){

			List<DTO>arr=new ArrayList<>();
			while(rs.next()) {
				int pid=rs.getInt("pid");
				String pname=rs.getString("pname");
				int pprice=rs.getInt("pprice");
				String iced=rs.getString("iced");
				String topping=rs.getString("topping");
				arr.add(new DTO(pid,pname,pprice,iced,topping));
			}
			con.commit();
			return arr;
		}
	}

	//아이디 존재 여부
	public boolean pidExist(int pid) throws Exception{
		String sql="select * from cafe where pid=? order by 1";
		try(Connection con=getConnection();
				PreparedStatement pstat=con.prepareStatement(sql);
				){
			pstat.setInt(1, pid);
			try(ResultSet rs = pstat.executeQuery();){

				boolean pidExist=false;
				while(rs.next()) {
					pidExist=true;
				}
				con.commit();
				return pidExist;
			}

		}
	}

	//메뉴 이름 존재 여부
	public boolean pnameExist(String pname) throws Exception{
		String sql="select * from cafe where pname=? order by 1";
		boolean pnameExist=false;
		try(Connection con=getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setString(1, pname);
			try(ResultSet rs =pstat.executeQuery();){
				while(rs.next()) {
					pnameExist=true;
				}
				con.commit();
				return pnameExist;
			}
		}


	}

	//delete
	public int delete(int delPID) throws Exception{
		String sql="delete from cafe where pid=?";
		try(Connection con=getConnection();
				PreparedStatement pstat=con.prepareStatement(sql);){
			pstat.setInt(1, delPID);
			int result=pstat.executeUpdate();
			con.commit();
			return result;
		}
	}


	//update
	public int update(DTO dto) throws Exception {
		String sql="update cafe set pname=?,pprice=?,iced=?,topping=? where pid=?";
		try(Connection con = getConnection();
				PreparedStatement pstat=con.prepareStatement(sql);){

			pstat.setString(1, dto.getPname());
			pstat.setInt(2, dto.getPprice());
			pstat.setString(3, dto.getIced());
			pstat.setString(4, dto.getTopping());
			pstat.setInt(5, dto.getPid());

			int result=pstat.executeUpdate();
			con.commit();
			return result;
		}
	}

	//searchByName
	public List<DTO> searchByName(String pname) throws Exception {
		String sql="select * from cafe where pname=?";
		try(Connection con=getConnection();
				PreparedStatement pstat=con.prepareStatement(sql);	){
			pstat.setString(1, pname);
			try(ResultSet rs = pstat.executeQuery();){

				List<DTO>arr=new ArrayList<>();
				while(rs.next()) {
					int pid=rs.getInt("pid");
					String pname2=rs.getString("pname");
					int pprice=rs.getInt("pprice");
					String iced=rs.getString("iced");
					String topping=rs.getString("topping");

					arr.add(new DTO(pid,pname2,pprice, iced,topping));
				}
				return arr;
			}
		}
	}

}
