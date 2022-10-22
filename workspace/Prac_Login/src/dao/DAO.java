package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.dbcp2.BasicDataSource;

import dto.DTO;

public class DAO {

	private static DAO instance=null;
	public synchronized static DAO getInstance() {
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
	BasicDataSource bds = new BasicDataSource();
	private Connection getConnection() throws Exception {
		return this.bds.getConnection();
	}

	public int insert(DTO dto) throws Exception {
		String sql="insert into info values(?,?,?)";
		try(Connection con=getConnection();
				PreparedStatement pstat=con.prepareStatement(sql);){
			pstat.setString(1, dto.getName());
			pstat.setString(2, dto.getId());
			pstat.setString(3, dto.getPw());
			int result=pstat.executeUpdate();
			con.commit();
			return result;
		}
	}

	public boolean login(DTO dto) throws Exception {
		boolean result=false;
		String sql="select * from info where id=?,pw=?";
		try(Connection con=getConnection();
				PreparedStatement pstat=con.prepareStatement(sql);){
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());
			try(ResultSet rs = pstat.executeQuery();){
				result=true;
			}
			return result;
		}
	}
}

