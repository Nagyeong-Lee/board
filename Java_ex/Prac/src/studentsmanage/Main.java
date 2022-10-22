package studentsmanage;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	

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
	
	public static void printStudent(ArrayList<Students>arr) {
		System.out.println("학번\t이름\t국어\t영어\t수학\t합계\t평균");
		for(Students s : arr) {
			System.out.println(s.getId()+"\t"+
					s.getName()+"\t"+
					s.getKor()+"\t"+
					s.getEng()+"\t"+
					s.getMath()+"\t"+
					s.getSum()+"\t"+
					s.getAvg());
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Manager manager = new Manager();
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("<<학생관리시스템>>");
			System.out.println("1.신규 정보 입력");
			System.out.println("2.학생 목록 출력");
			System.out.println("3.학생 정보 검색 (이름으로 검색)");
			System.out.println("4.학생 정보 삭제 (학번으로 검색)");
			System.out.println("5.학생 정보 수정 (이름으로 검색)");
			System.out.println("6.프로그램 종료");
			int menu=getInt(">> ");

			if(menu==1) {
				//				System.out.print("학번: ");
				//				String name=sc.nextLine();
				//				int kor=getInt("국어: ");
				//				int eng=getInt("영어: ");
				//				int math=getInt("수학: ");

				manager.addStudents(new Students(1001,"Tom",20,20,20));
				manager.addStudents(new Students(1002,"Jane",30,30,30));
				manager.addStudents(new Students(1003,"Amy",40,40,40));
				manager.addStudents(new Students(1004,"Jack",50,50,50));

			}else if(menu==2) {
//				System.out.println("학번\t이름\t국어\t영어\t수학\t합계\t평균");
//				ArrayList<Students>arr=manager.getStudents();
//				for(Students s : arr) {
//					System.out.println(s.getId()+"\t"+
//							s.getName()+"\t"+
//							s.getKor()+"\t"+
//							s.getEng()+"\t"+
//							s.getMath()+"\t"+
//							s.getSum()+"\t"+
//							s.getAvg());
//				}

				ArrayList<Students>arr=manager.getStudents();
				Main.printStudent(arr);
			}else if(menu==3) {
				System.out.print("이름 입력 :");
				String name=sc.nextLine();
				
				Students s = manager.searchStudents(name);
				System.out.println(s.getId()+"\t"+
						s.getName()+"\t"+
						s.getKor()+"\t"+
						s.getEng()+"\t"+
						s.getMath()+"\t"+
						s.getSum()+"\t"+
						s.getAvg());
			}else if(menu==4) {
				
//				ArrayList<Students>arr=manager.getStudents();  //목록출력하고 삭제
//				for(Students s : arr) {
//					System.out.println(s.getId()+"\t"+
//							s.getName()+"\t"+
//							s.getKor()+"\t"+
//							s.getEng()+"\t"+
//							s.getMath()+"\t"+
//							s.getSum()+"\t"+
//							s.getAvg());
//				}
				ArrayList<Students>arr=manager.getStudents();
				Main.printStudent(arr);
				int id=getInt("학번 입력 : ");
				manager.removeStudents(id);
			}else if(menu==5) {

//				ArrayList<Students>arr=manager.getStudents();  //목록출력하고 수정
//				for(Students s : arr) {
//					System.out.println(s.getId()+"\t"+
//							s.getName()+"\t"+
//							s.getKor()+"\t"+
//							s.getEng()+"\t"+
//							s.getMath()+"\t"+
//							s.getSum()+"\t"+
//							s.getAvg());
//				}
				ArrayList<Students>arr=manager.getStudents();
				Main.printStudent(arr);
				System.out.print("이름 입력 : ");
				String name=sc.nextLine();
				Students s = manager.updateStudents(name, 2000, 80, 80, 80);
				
				System.out.println("학번\t이름\t국어\t영어\t수학\t합계\t평균");
				System.out.println(s.getId()+"\t"+
						s.getName()+"\t"+
						s.getKor()+"\t"+
						s.getEng()+"\t"+
						s.getMath()+"\t"+
						s.getSum()+"\t"+
						s.getAvg());
				
			}else if(menu==6) {
				System.out.println("프로그램 종료");
				System.exit(0);
			}else {
				System.out.println("메뉴 다시 입력");
			}
		}

	}

}
