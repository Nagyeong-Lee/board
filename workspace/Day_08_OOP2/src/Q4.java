import java.util.Scanner;

public class Q4 {

	public static int getInt(String str) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			try {
				System.out.print(str);
				int num=Integer.parseInt(sc.nextLine());
				return num;
			}catch(Exception e) {
				System.out.println("숫자 입력");
			}
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		Students[]arr=new Students[10];
		while(true) {
			System.out.println("<< 학생 관리 시스템 >>");
			System.out.println("1. 신규 정보 등록");
			System.out.println("2. 학생 목록 출력");
			System.out.println("3. 프로그램 종료");
			System.out.print(">> ");
			int menu=Integer.parseInt(sc.nextLine());

			if(menu==1) {
				System.out.print("이름 : ");
				String name=sc.nextLine();

				int kor=getInt("국어 : ");
				int eng=getInt("영어 : ");

			}else if(menu==2) {
				System.out.println("이름\t국어\t영어\t합계\t평균");
			}else if(menu==3) {
				System.out.println("종료");
				System.exit(0);
			}else {
				System.out.println("메뉴 다시 입력");
			}
		}
	}

}
