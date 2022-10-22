import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Ex_01_Insert {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//JDBC
		//Java DataBase Connectivity
		//자바 프로그램을 이용해서 DBMS를 사용하는 문법
		//(sqlDeveloper말고 자바를 이용해서 쿼리 날림)
		//오라클 라이브러리 사용-ojdbc6
		
		//Step 1. DBMS에 라이브러리 등록하기
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//Step 2. DBMS에 접속하기
		String dbURL="jdbc:oracle:thin:@localhost:1521:xe"; //DBMS 어디있는지 경로
		String dbID="kh";
		String dbPW="kh";
		Connection con = DriverManager.getConnection(dbURL,dbID,dbPW);
		
		//Step 3. Query 전달 인스턴스 생성 및 실행
		Statement stat = con.createStatement();
		
		String sql=
				"insert into cafe_menu values(cafe_menu_seq.nextval,'Orange',5000,'Y')";
		int result=stat.executeUpdate(sql);  //select는 executeQuery 나머지 DML은 executeUpdate
		
		//Step 4. Query 실행 결과 확인
		if(result>0) { // ex)1개 행을 insert했습니다.
			System.out.println("삽입 성공");
		}else {
			System.out.println("삽입 실패");
		}
		
		//Step 5. 마무리 작업
		con.commit(); //DML
		con.close(); 
	}

}
