package stdmanage;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);	

	public static int getInt(String str) {
		while(true) {
			try {
				System.out.print(str);
				return Integer.parseInt(sc.nextLine());
			}catch(Exception e) {
				System.out.println("메뉴 번호를 입력해주세요.");
			}
		}
	}

	public static double getDouble(String str) {
		while(true) {
			try {
				System.out.print(str);
				return Double.parseDouble(sc.nextLine());
			}catch(Exception e) {
				System.out.println("메뉴 번호를 입력해주세요.");
			}
		}
	}

	public static String getString(String str) {
		while(true) {
			try {
				System.out.print(str);
				return sc.nextLine();
			}catch(Exception e) {
				System.out.println("다시 입력해주세요.");
			}
		}
	}

	public static void print(ArrayList<Student> arr) {
		for(Student std : arr) {
			System.out.println(
					std.getId()+"\t"+std.getName()+"\t"+std.getKor()+"\t"+std.getEng()+"\t"
							+std.getMath()+"\t"+std.getSoc()+"\t"
							+std.getSci()+"\t"+std.getSum()+"\t"+std.getAvg());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Manager manager=new Manager();

		while(true) {

			System.out.println("<<학생 관리 시스템>>");
			System.out.println("1.신규 정보 등록"); //학번,이름,국영수사과 합계 평균
			System.out.println("2.학생 목록 출력"); 
			System.out.println("3.학생 정보 검색"); // 모든걸로 검색가능하게
			System.out.println("4.학생 정보 삭제"); 
			System.out.println("5.학생 정보 수정");
			System.out.println("6.시스템 종료");
			int menu=getInt(">> ");

			if(menu==1) {
				manager.addStudent(new Student(1001,"Amy",10,10,10,10,10));
				manager.addStudent(new Student(1002,"Tom",20,20,20,20,20));
				manager.addStudent(new Student(1003,"Jack",100,100,100,100,100));
				manager.addStudent(new Student(1004,"Kevin",50,50,50,50,50));
				manager.addStudent(new Student(1005,"V",70,70,70,70,70));
			}else if(menu==2) {

				ArrayList<Student>arr = manager.getStudent();
				System.out.println("학번\t이름\t국어\t영어\t수학\t사회\t과학\t합계\t평균");
				print(arr);

			}else if(menu==3) {

				String name=getString("검색할 학생의 이름 : ");
				ArrayList<Student>arr = manager.searchStudent(name);
				if(arr.size()==0) {
					System.out.println("출력할 정보가 없습니다.");
				}else {
					System.out.println("학번\t이름\t국어\t영어\t수학\t사회\t과학\t합계\t평균");
					print(arr);
				}

			}else if(menu==4) {
				int id=getInt("삭제할 학생의 학번 : ");
				ArrayList<Student>arr=manager.removeStudent(id);
				if(arr.size()==0) {
					System.out.println("삭제할 학생이 없습니다.");
				}else {
					System.out.println(id+"번의 정보 삭제 완료.");
				}
			}else if(menu==5) {
				int id=getInt("수정할 학생의 학번 : ");
				String name=getString("이름 : ");
				int new_id=getInt("학번 : ");
				double kor=getDouble("국어 : ");
				double eng=getDouble("영어 : ");
				double math=getDouble("수학 : ");
				double soc=getDouble("사회 : ");
				double sci=getDouble("과학 : ");
				manager.updateStudent(id, name, new_id, kor, eng, math, soc, sci);
				System.out.println("학생 정보 수정 완료.");
			}else if(menu==6) {
				System.out.println("학생 관리 프로그램을 종료합니다.");
				System.exit(0);
			}else {
				System.out.println("메뉴를 다시 선택해주세요.");
			}
		}



	}

}
