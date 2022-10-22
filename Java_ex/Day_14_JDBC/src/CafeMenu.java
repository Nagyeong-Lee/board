import java.util.List;
import java.util.Scanner;

public class CafeMenu {

	public static void main(String[] args) {
		// 원래 main에 throws Exception x

		Scanner sc = new Scanner(System.in);
		CafeMenuDAO dao = CafeMenuDAO.getInstance();
		//CafeMenuDAO를 계속 new하면 dbcp도 계속 new되니까 overflow발생
		//new를 막아버리되, 특정 인스턴스 얻어오기
		
		while(true) {
			System.out.println("<< 카페 메뉴 관리 프로그램 >>");
			System.out.println("1. 신규 메뉴 등록");
			System.out.println("2. 메뉴 목록 출력");
			System.out.println("3. 메뉴 정보 삭제 (상품코드로 삭제)");
			System.out.println("4. 메뉴 정보 수정 (상품코드로 변경)");
			System.out.println("0. 프로그램 종료");
			System.out.print(">> ");
			int menu = Integer.parseInt(sc.nextLine());

			if(menu == 1) {
				System.out.print("메뉴 이름 : ");
				String pname = sc.nextLine();

				System.out.print("메뉴 가격 : ");
				int pprice = Integer.parseInt(sc.nextLine());

				System.out.print("아이스 가능 (Y,N) ? ");
				String iced = sc.nextLine();
				try {
					int result=dao.Insert(new CafeMenuDTO(0,pname,pprice,iced));
					// DTO에 값 묶어서 전달하는데 어차피 SEQ니까 0이나 아무값으로 해도 노상관
					if(result>0) {
						System.out.println("입력 완료");
					}
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("같은 오류가 반복되면 관리자에게 문의하세요");
				}


			}else if(menu == 2) {
				
				try {
				List<CafeMenuDTO> result =dao.selectAll();
				for(CafeMenuDTO dto : result) {
					System.out.println(dto.getPid()+" : "+dto.getPname()+": "+dto.getPprice()
					+" : "+dto.getPiced());
				}
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("같은 오류가 반복되면 관리자에게 문의하세요");
				}
				
			}else if(menu == 3) {
				System.out.print("삭제할 상품 코드 : ");
				int delPID = Integer.parseInt(sc.nextLine());
				try {
					int result=dao.remove(delPID);
					if(result>0) {
						System.out.println("삭제 성공");
					}
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("같은 오류가 반복되면 관리자에게 문의하세요");
				}
			}
			//		            Connection con = DriverManager.getConnection(url,id,pw);
			//		            //Statement stat = con.createStatement();
			//		            String sql = "delete from cafe_menu where pid = ?";
			//		            PreparedStatement pstat=con.prepareStatement(sql);
			//		            pstat.setInt(1, delPID);
			//		            
			//		            int result = pstat.executeUpdate();
			//		            if(result > 0) {
			//		               System.out.println("삭제 성공");
			//		            }
			//		            con.commit();
			//		            con.close();
			else if(menu == 4) {

				System.out.print("변경할 메뉴의 상품 코드 : ");
				int updPID = Integer.parseInt(sc.nextLine());

				System.out.print("메뉴 이름 : ");
				String pname = sc.nextLine();

				System.out.print("메뉴 가격 : ");
				int pprice = Integer.parseInt(sc.nextLine());

				System.out.print("아이스 가능 (Y,N) ? ");
				String iced = sc.nextLine();
				//		            
				try {
					int result=dao.update(new CafeMenuDTO(updPID,pname,pprice,iced));
					if(result > 0) {
						System.out.println("변경 완료");
					}
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("관리자에게 문의 바람");
				}
			}
			//		}else if(menu == 0) {
			//			//		            System.out.println("프로그램을 종료합니다.");
			//			//		            System.exit(0);
			//		}else {
			//			//		            System.out.println("메뉴를 다시 확인해주세요.");
			//		}
		}

	}
}

