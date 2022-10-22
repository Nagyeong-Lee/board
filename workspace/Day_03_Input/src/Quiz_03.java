import java.util.Scanner;

public class Quiz_03 {  //학생 성적 입력 후 합계,평균 구하기

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("=============");
//		System.out.print("이름 : ");
//		String name = sc.nextLine();
//		System.out.println("=============");
//		System.out.print("국어 : ");
//		int kor = sc.nextInt();
//		System.out.print("수학 : ");
//		int math = sc.nextInt();
//		System.out.print("영어 : ");
//		int eng = sc.nextInt();
//		System.out.println("=============");
//		System.out.println("합계 : "+(kor+math+eng));
//		System.out.println("평균 : "+(kor+math+eng)/3.0);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("=============");
		System.out.print("이 름 : ");
		String name = sc.nextLine();
		System.out.println("=============");
		System.out.print("국 어 : ");
		int kor = Integer.parseInt(sc.nextLine());
		System.out.print("수 학 : ");
		int math = Integer.parseInt(sc.nextLine());
		System.out.print("영 어 : ");
		int eng = Integer.parseInt(sc.nextLine());
		System.out.println("=============");
		System.out.println("합 계 : "+(kor+math+eng));
		System.out.printf("평 균 : "+"%.2f\n",(kor+math+eng)/3.0);
//	    System.out.println("평 균 : "+String.format("%.2f",(kor+math+eng)/3.0));
		System.out.println("=============");
		
		
	}

}
