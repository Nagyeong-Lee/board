import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
//	public static void printStudent(getStd) {
//		for(Student s : getStd) {
//			//					if(s==null) { //?
//			//						System.out.println("출력할 정보 없음");
//			//						break A;
//			//					}
//			System.out.println(s.getId()+"\t"+
//					s.getName()+"\t"+
//					s.getKor()+"\t"+
//					s.getEng()+"\t"+
//					s.getMath()+"\t"+
//					s.getSum()+"\t"+
//					s.getAvg()+"\t");
//		}
//	}  for문 메소드로 뺌

	public static int getInt(String str) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			try {
				System.out.print(str);
				return Integer.parseInt(sc.nextLine());
			}catch(Exception e) {
				System.out.println("정수로 입력해주세요");
			}	
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//출력은 무조건 main에서 
		//<<학생관리시스템>> MVC1
		/*신규정보입력 (MemberField :학번/이름/국어/영어/수학)
		 *학생목록출력 (학번/이름/국어/영어/수학/합계/평균)
		 *학생정보검색 (이름으로 검색 / 동명이인 다 출력)
		 *학생정보삭제(학번으로 삭제)
         학생정보수정(학번으로 수정 / 이름 빼고 다 수정)        */

		StudentArr studentArr = new StudentArr();
		ArrayList <Student> getStd =studentArr.getStudent();
		//Student형 객체는 지역변수로 생성

		A : while(true) {

			Scanner sc = new Scanner(System.in);
			System.out.println("<<학생관리시스템>>");
			System.out.println("1.신규 정보 입력");
			System.out.println("2.학생 목록 출력");
			System.out.println("3.학생 정보 검색");
			System.out.println("4.학생 정보 삭제");
			System.out.println("5.학생 정보 수정");
			System.out.println("6.프로그램 종료");
			System.out.print(">> ");
			int menu=Integer.parseInt(sc.nextLine());
			if(menu==1) {
				System.out.println("신규 정보 입력");
				int id=Main.getInt("학번 : ");

				System.out.print("이름 : ");
				String name=sc.nextLine();

				int kor=Main.getInt("국어 : ");
				int eng=Main.getInt("영어 : ");
				int math=Main.getInt("수학 : ");

				studentArr.addStudent(new Student(id,name,kor,eng,math));
			}else if(menu==2) {
				System.out.println("학생 목록 출력");
				System.out.println("학번\t이름\t국어\t영어\t수학\t합계\t평균");
				for(Student s : getStd) {
					//					if(s==null) { //?
					//						System.out.println("출력할 정보 없음");
					//						break A;
					//					}
					System.out.println(s.getId()+"\t"+
							s.getName()+"\t"+
							s.getKor()+"\t"+
							s.getEng()+"\t"+
							s.getMath()+"\t"+
							s.getSum()+"\t"+
							s.getAvg()+"\t");
				}
			}else if(menu==3) {
				System.out.println("학생 정보 검색 (이름으로 검색)");
				System.out.print("이름 입력 : ");
				String inputName=sc.nextLine();

				boolean notFound=true;
				for(Student s : getStd) { 
					if(s.getName().equals(inputName)) {  //데이터 관련된거니까 StudentArr에서 검사하는게 좋음, 이름 중복 가능성 ,출력은 main이 담당
						System.out.println("학번\t이름\t국어\t영어\t수학\t합계\t평균");
						System.out.println(s.getId()+"\t"+
								s.getName()+"\t"+
								s.getKor()+"\t"+
								s.getEng()+"\t"+
								s.getMath()+"\t"+
								s.getSum()+"\t"+
								s.getAvg()+"\t");
						notFound=false;
					}
				}if(notFound){
					System.out.println("정보 없음");
				}
			}else if(menu==4) {
				System.out.println("4.학생 정보 삭제 (학번으로 삭제)");  
				int inputId=Main.getInt("학번 입력 : ");
				for(Student s : getStd) { 
					if(s.getId()==inputId) { //ArrayList가 변경이 되어도  if문에서 아예 에러가 남
						studentArr.removeStudent(s);
						break;   //동시성 문제 해결 
					}
				}
			}else if(menu==5) {
				System.out.println("5.학생 정보 수정 (학번으로 수정)");
				int inputId=Main.getInt("학번 입력 : "); //수정x   학번이 존재하는지 확인
				for(Student s : getStd) { 
					if(s.getId()==inputId) {
						System.out.print("이름 : ");
						String name=sc.nextLine();

						int kor=Main.getInt("국어 : ");
						int eng=Main.getInt("영어 : ");
						int math=Main.getInt("수학 : ");


						studentArr.updateStudent(studentArr.getIndex(), name, kor, eng, math);
						//						studentArr.updateStudent(new Student(index,name,kor,eng,math));

					}
				}

				//				System.out.print("이름 : ");
				//				String name=sc.nextLine();
				//				int kor=Main.getInt("국어 : ");
				//				int eng=Main.getInt("영어 : ");
				//				int math=Main.getInt("수학 : ");
				//				
				//				
			}else if(menu==6) {
				System.out.println("프로그램 종료");
				System.exit(0);
			}else {
				System.out.println("메뉴 다시 입력");
			}

		}
	}

}
