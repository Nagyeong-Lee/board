//import java.util.Scanner;
//
//public class ExceptionHandler {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		Scanner sc = new Scanner(System.in);
//		
//		while(true) {
//			System.out.print("숫자 입력 : ");
//			try {
//			int num=Integer.parseInt(sc.nextLine());
//			System.out.println("정상입력");
//			break;
//			}catch(Exception e) {
//				System.out.println("숫자입력하세요");
//				continue;
//			}
//		}
//		System.out.println("종료");
//	}
//}

//변수의 종류 ([지역변수/매개변수],정적변수,멤버변수)
class ExceptionHandler{
	public static void main(String[] args) {

		{
			int a=10; //지역변수
			System.out.println(a);
		}
		int a=20;
		System.out.println(a);
	}
}

