import java.util.Scanner;

public class Calc {

	//q입력시 바로 프로그램종료, 연산기호가 아니면 다시 입력해주세요

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("===계산기 프로그램===");
			System.out.print("연산자 입력 (+,-,*,/) : ");
			String oper=sc.nextLine();

			if(oper.equalsIgnoreCase("q")) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}else if(!oper.equals("+")&&!oper.equals("-")&&!oper.equals("*")&&!oper.equals("/")) {
				System.out.println("연산자를 다시 입력해주세요");
				continue;
			}
			int num1 = validNum("첫 번째 수 : ");
			int num2 = validNum("두 번째 수 : ");

			//			while(true) {
			//				try {
			//					System.out.print("첫 번째 숫자 입력 : ");
			//					num1=Integer.parseInt(sc.nextLine());
			//					break;
			//				}catch(Exception e) {
			//					System.out.println("숫자를 입력해주세요");
			//					continue;
			//				}
			//			}
			//			while(true) {
			//				System.out.print("두 번째 숫자 입력 : ");
			//				try {
			//					num2=Integer.parseInt(sc.nextLine());
			//					break;
			//				}catch(Exception e) {
			//					System.out.println("숫자를 입력해주세요");
			//					continue;
			//				}
			//			}
			System.out.println("결과");
			if(oper.equals("+")) {
				System.out.println(num1+"+"+num2+"="+(num1+num2));
			}else if(oper.equals("-")) {
				System.out.println(num1+"-"+num2+"="+(num1-num2));
			}else if(oper.equals("*")) {
				System.out.println(num1+"*"+num2+"="+(num1*num2));
			}else if(oper.equals("/")) {
				System.out.println(num1+"/"+num2+"="+String.format("%.6f", (num1/num2)));
			}

		}
	}

	//	public static int validNum() {
	//		Scanner sc = new Scanner(System.in);
	//		int num1=0,num2=0;
	//		while(true) {
	//			try {
	//				num1=Integer.parseInt(sc.nextLine());
	//				break;
	//			}catch(Exception e) {
	//				System.out.println("숫자를 입력해주세요");
	//				continue;
	//			}
	//		}
	//		
	//		return num1;
	//	}

	public static int validNum(String msg) {
		int n =0;
		Scanner sc = new Scanner(System.in);
		while(true) {
			try {
				System.out.println(msg);
				n=sc.nextInt();
				break;
			}catch(Exception e) {
				System.out.println("다시 입력 : ");
			}
		}
		return n;
	}
}



