import java.util.Scanner;

public class Exam_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.print("Apple을 입력하세요 : ");
		String str = sc.nextLine(); //문자열 비교시 ==말고 equals사용
		
		if(str.equalsIgnoreCase("APPLE")) {
			System.out.println("정답");
		}else {
			System.out.println("다시 입력");
		}
	}
}
