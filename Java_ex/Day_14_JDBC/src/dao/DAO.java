package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.GuestBook_DTO;

public class DAO {

	public int insert(GuestBook_DTO dto) throws Exception{
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "kh";
		String pw = "kh";

		String sql = "insert into guestbook values(guestbook_seq.nextval, ? , ? , sysdate)";

		Connection con = DriverManager.getConnection(url,id,pw);
		PreparedStatement pstat = con.prepareStatement(sql);

		pstat.setString(1, dto.getWriter());
		pstat.setString(2, dto.getText());
		int result = pstat.executeUpdate();

		con.commit();
		con.close();
		return result;
	}

	public int delete(int seq) throws Exception{
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "kh";
		String pw = "kh";

		String sql = "delete from guestbook where seq = ?";

		Connection con = DriverManager.getConnection(url,id,pw);
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setInt(1, seq);
		int result = pstat.executeUpdate();
		con.commit();
		con.close();
		return result;
	}

	public boolean isSeqExist(int seq) throws Exception{
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "kh";
		String pw = "kh";

		String sql = "select * from guestbook where seq = ?";

		Connection con = DriverManager.getConnection(url,id,pw);
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setInt(1, seq);
		ResultSet rs = pstat.executeQuery();
		boolean result = rs.next();
		return result;
	}

	public boolean isWriterExist(String writer) throws Exception{
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "kh";
		String pw = "kh";
		String sql = "select * from guestbook where writer = ?";
		Connection con = DriverManager.getConnection(url,id,pw);
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setString(1,writer);

		ResultSet rs = pstat.executeQuery();
		boolean result = rs.next();
		return result;
	}


	public int update(int seq, String writer, String contents) throws Exception{
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "kh";
		String pw = "kh";

		String sql = "update guestbook set writer=?, contents=? where seq = ?";
		Connection con = DriverManager.getConnection(url,id,pw);
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setString(1, writer);
		pstat.setString(2, contents);
		pstat.setInt(3, seq);
		int result = pstat.executeUpdate();

		con.commit();
		con.close();
		return result;
	}



}
