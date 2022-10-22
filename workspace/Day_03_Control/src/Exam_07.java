import java.util.Scanner;

public class Exam_07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("당신이 좋아하는 과목 선택해라");
		System.out.print("1.java / 2.음악 / 3.주짓수 >> ");
		int num = sc.nextInt();
		
		switch(num) {
			case 1 : 
				System.out.println("JAVA는 공학임");
				break;
			case 2 :
				System.out.println("음악은 예술임");
				break;
			case 3 :
				System.out.println("주짓수는 체육임");
				break;
			default :
				System.out.println("다시 선택해라");
				
		}
		
	}

}
