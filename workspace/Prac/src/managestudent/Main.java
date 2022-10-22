package managestudent;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	public static int getInt(String str) {
		while(true) {
			try{
				System.out.print(str);
				return Integer.parseInt(sc.nextLine());
			}catch(Exception e) {
				System.out.println("정수를 입력해주세요");
			}
		}
	}

	public static String getString(String str) {
		while(true) {
			try{
				System.out.print(str);
				return sc.nextLine();
			}catch(Exception e) {
				System.out.println("문자를 입력해주세요");
			}
		}
	}

	public static double getDouble(String str) {
		while(true) {
			try{
				System.out.print(str);
				return Double.parseDouble(sc.nextLine());
			}catch(Exception e) {
				System.out.println("실수를 입력해주세요");
			}
		}
	}


	public static void print(ArrayList<Student> arrayList) {

		for(Student s : arrayList) {
			System.out.println(s.getId()+"\t"+
					s.getName()+"\t"+
					s.getKor()+"\t"+
					s.getEng()+"\t"+
					s.getMath()+"\t"+
					s.getArt()+"\t"+
					s.getSum()+"\t"+
					s.getAvg());
		}

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Manager manager = new Manager();

		while(true) {
			System.out.println("<<학생 관리 시스템>>");
			System.out.println("1.신규 정보 등록");
			System.out.println("2.학생 목록 출력");
			System.out.println("3.학생 정보 검색");
			System.out.println("4.학생 정보 삭제");
			System.out.println("5.학생 정보 수정");
			System.out.println("6.시스템 종료");
			int menu=getInt(">> ");

			if(menu==1) {
				manager.addStudent(new Student(1001,"Jack",50,50,50,60.5));
				manager.addStudent(new Student(1002,"Jay",60.5,60.5,60.5,60.5));
				manager.addStudent(new Student(1003,"Tom",70,70,80,80));
				manager.addStudent(new Student(1004,"Anny",90,90,90,90));

			}else if(menu==2) {
				ArrayList<Student>arrayList=manager.getStudent();
				System.out.println("학번\t이름\t국어\t영어\t수학\t미술\t합계\t평균");
				print(arrayList);

			}else if(menu==3) {
				String name=getString("검색할 학생의 이름 : ");
				ArrayList<Student>arrayList=manager.searchStudent(name);
				if(arrayList.size()==0) {
					System.out.println("학생 정보가 없습니다.");
				}else{
					System.out.println("학번\t이름\t국어\t영어\t수학\t미술\t합계\t평균");
					print(arrayList);
				}
			}else if(menu==4) {
				int id=getInt("삭제할 학생의 학번 : ");
				ArrayList<Student>arrayList=manager.removeStudent(id);
				if(arrayList.size()<1) {
					System.out.println("학생 정보가 없습니다.");
				}else {
					System.out.println("삭제가 완료되었습니다.");	
				}
			}else if(menu==5) {
				int id=getInt("수정할 학생의 학번 : ");
				String name=getString("이름 : ");
				int id2=getInt("학번 : ");
				int kor=getInt("국어 : ");
				int eng=getInt("영어 : ");
				int math=getInt("수학 : ");
				int art=getInt("미술 : ");
				ArrayList<Student>arrayList= manager.updateStudent(id,id2,name,kor,eng,math,art);
				if(arrayList.size()<0) {
					System.out.println("학생 정보가 없습니다.");
				}else {
					System.out.println("수정이 완료되었습니다.");
				}
			}else if(menu==6) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}else {
				System.out.println("메뉴를 다시 입력해주세요.");
			}

		}
	}

}
