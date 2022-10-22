import java.util.Scanner;

public class Quiz_06 { 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1~n까지 합구하기 1+2+3=6
//		int sum=0;
//		Scanner sc = new Scanner(System.in);
//		System.out.print("정수 입력 : ");
//		int n = sc.nextInt();
//		
//		for(int i=1; i<=n; i++) {
//			sum+=i;
//		}
//		System.out.println(sum);
		
		//n,m입력받고 n~m까지 합
		int sum=0;
		Scanner sc = new Scanner(System.in);
		System.out.print("n 입력 : ");
		int n = sc.nextInt();
		System.out.print("m 입력 : ");
		int m = sc.nextInt();
		
		int i=n;
		while(i<=m) {
			sum+=i;
			i++;
		}
		System.out.println(sum);
		
		
	}
}

	
