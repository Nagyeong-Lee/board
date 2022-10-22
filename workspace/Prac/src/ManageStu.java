import java.util.ArrayList;
import java.util.Scanner;

public class ManageStu {

	public static int getInt(String str) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			try {
				System.out.print(str);
				return Integer.parseInt(sc.nextLine());
			}catch(Exception e) {
				System.out.println("정수 입력");
			}
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		StudentArr sa = new StudentArr();  //ArrayList에 객체 저장

		while(true) {
			System.out.println("<< 학생 관리 시스템 >>");
			System.out.println("1. 신규 정보 등록");
			System.out.println("2. 학생 목록 출력");
			System.out.println("3. 프로그램 종료");
			int menu= getInt(">> ");

			if(menu==1) {

				System.out.print("이름 : ");
				String name = sc.nextLine();

				int kor=ManageStu.getInt("국어 : ");
				int eng=ManageStu.getInt("영어 : ");

				StudentInfo si = new StudentInfo(name,kor,eng);

				sa.addStudent(si);

			}else if(menu==2) {

				ArrayList arr = sa.getStudent(); //주소 받아서 출력
				System.out.println("이름\t국어\t영어\t합계\t평균");
				for(int i=0; i<arr.size(); i++) {
					System.out.println(((StudentInfo)arr.get(i)).getName()+"\t"+
							((StudentInfo)arr.get(i)).getKor()+"\t"
							+((StudentInfo)arr.get(i)).getEng()+"\t"
							+((StudentInfo)arr.get(i)).getSum()+"\t"
							+((StudentInfo)arr.get(i)).getAvg()+"\t"
							);
				}

			}else if(menu==3) {
				System.out.println("프로그램 종료");
				System.exit(0);
			}else {
				System.out.println("메뉴 다시 선택");
			}
		}
	}

}
//mvc 