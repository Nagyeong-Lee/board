
public class Quiz_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//3-1
		int num1 = 1325;
		int num2 = 9327;
		int multiple = num1*num2;
		System.out.println(num1+" x "+num2+" = "+multiple);
		
		//3-2
		long lNum = 10000000000L+5000;
		System.out.println(lNum);
		
		//3-3
		char ch1 = 'A';
		char ch2 = 'B';
		System.out.println(ch1);
		System.out.println(ch2);
		
		//변수와 상수
		int a = 5; a = 20;
		final int A = 10;
		final int ON = 1;
		final int OFF = 0;
		final int EMER = -1; 
		int power = OFF;
		
		//증감연산자 ++ --
		int plus = 10;
		plus++; //단독사용
		System.out.println(plus);
		
		int plus2 = 20;
		System.out.println(plus2++); 
		System.out.println(++plus2);
		
	}

}
