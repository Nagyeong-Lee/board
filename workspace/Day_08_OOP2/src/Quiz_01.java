//import java.util.Scanner;
//
//public class Quiz_01 {
//	public static void main(String[] args) {
//		//배열 10칸으로 시작
//		//<< 학생 관리 프로그램 >>
//		//1. 신규 정보 입력
//		//2. 학생 목록 출력
//		//3. 프로그램 종료
//		//선택 >> 
//		/*  1번 선택시 학생이름.국어.영어 점수 입력받아 student 인스턴스 생성후 student배열에 저장
//		 * 2번 선택시 배열에 저장되어있는 모든 학생 정보 출력
//		 * 한명의 정보도 저장되어있지 않을 시 출력할 내용이 없습니다 출력
//		 */
//		Scanner sc = new Scanner(System.in);
//		Student[]std=new Student[2];
//		A: while(true) {
//			System.out.println("<< 학생 관리 프로그램 >>");
//			System.out.println("1. 신규 정보 입력");
//			System.out.println("2. 학생 목록 출력");
//			System.out.println("3. 프로그램 종료");
//			System.out.print("선택 >> ");
//			int menu=Integer.parseInt(sc.nextLine());
//
//
//			if(menu==1) {
//				for(int i=0; i<std.length; i++) {   // std.length로 하면 배열 길이 안맞을수도 있어서 index값으로 해야됨
//					System.out.println((i+1)+"번째 학생");
//
//					std[i]=new Student();
//
//					try {
//						//std[i]=new Student(Integer.parseInt(sc.nextLine()),Integer.parseInt(sc.nextLine()),sc.nextLine());
//													std[i].setName(sc.nextLine());
//													std[i].setKor(Integer.parseInt(sc.nextLine()));
//													std[i].setEng(Integer.parseInt(sc.nextLine()));
//
//
//					}catch(Exception e) {
//						System.out.println("다시 입력해주세요");
//						continue A;
//					}
//				}
//			}
//
//
//			else if(menu==2){
//				System.out.println("이름\t국어\t영어\t합계\t평균");
//				for(int i=0; i<std.length; i++) {
//					if(std[i]==null) {
//						System.out.println("출력할 내용이 없습니다.");
//						break;
//					}else {
//						System.out.println(std[i].getName()+"\t"+std[i].getKor()+"\t"+std[i].getEng()+"\t"+std[i].getSum()+"\t"+std[i].getAverage());
//					}
//				}
//			}
//			else if(menu==3) {
//				System.out.println("프로그램 종료");
//				System.exit(0);
//			}
//		}
//	}
//}

import java.util.Scanner;

public class Quiz_01 {
  public static int getValidNum(String ui) {
     Scanner sc = new Scanner(System.in);
     while(true) {
        try {
           System.out.print(ui);
           return Integer.parseInt(sc.nextLine());
        }catch(Exception e) {
           System.out.println("숫자를 입력해야 합니다.");
        }
     }
  }
 
  public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     Student[] stds = new Student[10];
     int index = 0;

     while(true) {
        System.out.println("<< 학생 관리 시스템 >>");
        System.out.println("1. 신규 정보 등록"); // 이름 국어 영어
        System.out.println("2. 학생 목록 출력");
        System.out.println("3. 프로그램 종료");
        int menu = getValidNum(">> ");

        if(menu == 1) {
           System.out.print("이 름 : ");
           String name = sc.nextLine();

           int kor = getValidNum("국 어 : ");
           int eng = getValidNum("영 어 : ");

           Student std = new Student(kor, eng, name);
           stds[index++] = std;

        }else if(menu == 2) {
           System.out.println("이름\t국어\t영어\t합계\t평균");

           if(index == 0) {
              System.out.println("출력할 내용이 없습니다.");
           }else {
              for(int i = 0;i < index;i++) {
                 System.out.println(stds[i].getName()+"\t"+
                       stds[i].getKor()+"\t"+
                       stds[i].getEng()+"\t"+
                       stds[i].getSum()+"\t"+
                       stds[i].getAverage());
              }
           }
        }else if(menu == 3) {
           System.out.println("프로그램을 종료합니다.");
           System.exit(0);
        }else {
           System.out.println("메뉴를 다시 확인해주세요.");
        }
     }

  }
}