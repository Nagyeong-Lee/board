import java.util.Scanner;

public class Quiz_02 {//두 정수를 입력받아 덧셈결과 출력

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Scanner sc = new Scanner(System.in);
//		System.out.print("정수 입력 : ");
//		int num1 = sc.nextInt();
//		System.out.print("정수 입력 : ");
//		int num2 = sc.nextInt();
//		System.out.println("덧셈한 결과 : "+(num1+num2));
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		long num1 = Long.parseLong(sc.nextLine()); //nextLine()으로 입력받으면 자동으로 줄바꿈됨
		System.out.print("정수 입력 : ");
		int num2 = Integer.parseInt(sc.nextLine()); 
		System.out.println("덧셈한 결과 : "+(num1+num2));
		
		
	}

}
