import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

public class CafeMenuDAO {

//	private Connection GetConnection() throws Exception {
//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
//		String id = "kh";
//		String pw = "kh";
//		Connection con = DriverManager.getConnection(url,id,pw);
//		return con;
//	}
	
	private static CafeMenuDAO instance = null; 
	public synchronized static CafeMenuDAO getInstance() { //클래스 메소드
		//synchronized : 한번에 한명만 실행가능하고 중간에 못들어오고 대기 /동시에 여러명 들어오면안될때 동기화
		//return new CafeMenuDAO();   
		if(instance == null) {
			instance =  new CafeMenuDAO();  //CafeMenuDAO 하나만 만드려고 singleton 적용완료
		}
		return instance;
	}//static쓰는 이유 : static안쓰면 인스턴스메소드라 객체 생성 후 사용가능한데 cafemenudao는 객체 생성이 안되서
	
	//생성자가 private이면 밖에서 new못하고 내부에서는 가능.public메소드 하나 생성하기
	private CafeMenuDAO() { //이것들은 getConnection때 반복할 필요없이 한번만 하면되니까 생성자로 뺌
						   //객체 생성 시 한 번만 세팅됨
		this.bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe"); 
		this.bds.setUsername("kh");
		this.bds.setPassword("kh");
		this.bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		this.bds.setInitialSize(30);
	}
	//Connection pool 객체 생성  외부라이브러리 추가 /의존성 라이브러리라 여러개 추가했음
	private BasicDataSource bds=new BasicDataSource();
	private Connection GetConnection() throws Exception{
		
		//this.bds=new BasicDataSource();  //Connection 객체를 만들어서줌
							  //DriverManager.getConnection과 동일한 기능
							  //에러나는 이유 : GetConnection할때마다 dbcp 계속 새로만드니까 에러
//		this.bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe"); 
//		this.bds.setUsername("kh");
//		this.bds.setPassword("kh");
//		this.bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		//Class.forName();
//		this.bds.setInitialSize(30); //Connection Pool객체가 30개의 connection가짐
		return bds.getConnection(); //connection 내놔
	}

	public int Insert(CafeMenuDTO dto) throws Exception{


		Connection con=GetConnection();
		//Statement stat = con.createStatement();

		String sql = 
				"insert into cafe_menu values(cafe_menu_seq.nextval,?,?,?)";
		PreparedStatement pstat=con.prepareStatement(sql); //Statement 업그레이드
		pstat.setString(1,dto.getPname());
		pstat.setInt(2,dto.getPprice());
		pstat.setString(3,dto.getPiced());

		int result = pstat.executeUpdate();

		//		if(result>0) {                       MVC-M에서 출력코드는 절대X
		//			System.out.println("입력 완료");
		//		}
		con.commit();
		con.close();
		return result;
	}

	public int remove(int delPID) throws Exception{ //값 여러개 넘기는게 아닐때는 dto 굳이x

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "kh";
		String pw = "kh";

		Connection con = DriverManager.getConnection(url,id,pw);
		//Statement stat = con.createStatement();
		String sql = "delete from cafe_menu where pid = ?";
		PreparedStatement pstat=con.prepareStatement(sql);
		pstat.setInt(1, delPID);

		int result = pstat.executeUpdate();
		con.commit();
		con.close();
		return result;
	}

	public int  update(CafeMenuDTO dto) throws Exception{


		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "kh";
		String pw = "kh";

		Connection con = DriverManager.getConnection(url,id,pw);
		//Statement stat = con.createStatement();
		String sql = 
				"update cafe_menu set pname=?,pprice=?,iced=? where pid=?";
		PreparedStatement pstat=con.prepareStatement(sql);
		pstat.setString(1, dto.getPname());
		pstat.setInt(2, dto.getPprice());
		pstat.setString(3,dto.getPiced());
		pstat.setInt(4, dto.getPid());
		int result = pstat.executeUpdate();

		con.commit();
		con.close();

		return result;
	}

	//ArrayList는 List 인터페이스를 상속받은 클래스로 List로 사용해도 노상관임
	public List<CafeMenuDTO> selectAll() throws Exception {
		Connection con = GetConnection();
		//Statement stat = con.createStatement();
		String sql = "select * from cafe_menu order by 1";
		PreparedStatement pstat=con.prepareStatement(sql);
		ResultSet rs = pstat.executeQuery();
		
		List<CafeMenuDTO>result=new ArrayList<>(); //object형 배열
							//제너릭 포함안하면 다형성때문에 downCasting해서 써야함
		// ResultSet은 connection이 close되기 전까지 동작
		//Connection은 자바와 db연결해주는 통로,이 다리를 통해 resultSet이 동작

		while(rs.next()) {
			int pid = rs.getInt("pid");
			String pname = rs.getString("pname");
			int pprice = rs.getInt("pprice");
			String iced = rs.getString("iced");
			CafeMenuDTO dto = new CafeMenuDTO(pid,pname,pprice,iced);
			result.add(dto);
		}
		con.close(); //java db사이의 연결 끊어짐
		return result;
	}

}
