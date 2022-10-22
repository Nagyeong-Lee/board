package guestbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import dto.GuestBook_DTO;

public class GuestBook_DAO {

	public Connection getConnection() throws Exception{
		String url="jdbc:oracle:thin:@localhost:1521:xe"; //DB의 위치
		String id="gb";
		String pw="1234";
		Connection con = DriverManager.getConnection(url,id,pw);
		return con;
	}
	public int insert(GuestBook_DTO dto) throws Exception{
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
				PreparedStatement pstat=con.prepareStatement(sql);	){

			pstat.setInt(1, delWrite_num);
			int result=pstat.executeUpdate();
			con.commit();
			return result;
		}

	}

	public int update(GuestBook_DTO dto) throws Exception{
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

	//search
	public List<GuestBook_DTO> search(String searchName) throws Exception {
		String sql=
				"select * from guestbook where writer=?";
		try(Connection con = getConnection();
				PreparedStatement pstat=con.prepareStatement(sql);){
			pstat.setString(1, searchName);
			try(ResultSet rs = pstat.executeQuery();){
				List<GuestBook_DTO> result=new ArrayList<>();
				while(rs.next()) {
					int write_num=rs.getInt("write_num");
					String writer=rs.getString("writer");
					String text=rs.getString("text");
					Timestamp write_date=rs.getTimestamp("write_date");
					//if안쓰는 이유가 ?가 아니면 select가 안되기 때문?
					result.add(new GuestBook_DTO(write_num,writer,text,write_date));
				}
				return result;

			}
		}

	}

	public List<GuestBook_DTO> selectAll() throws Exception{
		String sql="select * from guestbook order by 1";
		try(Connection con = getConnection();
				PreparedStatement pstat=con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery();){
			List<GuestBook_DTO>result=new ArrayList<>();
			while(rs.next()) {
				int write_num=rs.getInt("write_num");
				String writer=rs.getString("writer");
				String text=rs.getString("text");
				Timestamp write_date=rs.getTimestamp("write_date");

				//SimpleDateFormat sdf = new SimpleDateFormat("MM월dd일hh시mm분");
				//				System.out.println(write_num+" : "+writer+" : "+text+" : "
				//						+sdf.format(write_date.getTime()));
				result.add(new GuestBook_DTO(write_num,writer,text,write_date));
			}
			//DATE 타입은 시분초 안나와서 TIMESTAMP로 
			return result;
		}
	}
}

//ex)
//public List<GuestBook_DTO> selectAll() throws Exception{
//String sql="select * from guestbook where pid=? order by 1";
//try(Connection con = getConnection();
//		PreparedStatement pstat=con.prepareStatement(sql);
//pstat.setInt(pid);
//		ResultSet rs = pstat.executeQuery();){
//	List<GuestBook_DTO>result=new ArrayList<>();
//	while(rs.next()) {
//		int write_num=rs.getInt("write_num");
//		String writer=rs.getString("writer");
//		String text=rs.getString("text");
//		Timestamp write_date=rs.getTimestamp("write_date");
//
//		//SimpleDateFormat sdf = new SimpleDateFormat("MM월dd일hh시mm분");
//		//				System.out.println(write_num+" : "+writer+" : "+text+" : "
//		//						+sdf.format(write_date.getTime()));
//		result.add(new GuestBook_DTO(write_num,writer,text,write_date));
//	}
//	//DATE 타입은 시분초 안나와서 TIMESTAMP로 
//	return result;
//}
//}
//db 컬럼명,데이터타입이랑 dto 필드명,데이터타입 일치하게 짜기
//ResultSET,Connection,PreparedStatement 다 close해야됨
//--> try(){} --try 리소스 close가 필요한것들 ()안에 넣기
//()안에 있는 것들은 {}안에서 예외가 발생하든 정상종료하든 무조건 close됨   //안하면 exception타고 나가서 close안되고 과부하
// close알아서해서 나중에 close필요없고,commit은 해줘야함
//select 에 where있을때는 try-resource 이중으로 <순서때문에>, try-resource-catch-finally 붙이기 가능

