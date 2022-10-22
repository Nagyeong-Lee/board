import java.util.Scanner;

public class Quiz_01 { //대소비교

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 숫자 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 숫자 입력 : ");
		int num2 = sc.nextInt();
		System.out.println("====결과====");
		
		if(num1>num2) {
			System.out.println("첫 번째 입력값이 더 크다.");
		}else if(num1<num2) {
			System.out.println("두 번째 입력값이 더 크다.");
		}else {
			System.out.println("첫 번째 값과 두 번째 값은 같다.");
		}
	}

}
