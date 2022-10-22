import java.util.Scanner;

public class Quiz_05 {    //사용자가 선택한 구구단 출력,2~9단만 출력
						  //무한반복해보기 (0누르면 종료)

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Scanner sc = new Scanner(System.in);
//		System.out.println("===구구단 출력 프로그램===");
//		System.out.print("2~9단 중 선택 : ");
//		int dan = sc.nextInt();
//		
//		if(2<=dan&&dan<=9) {
//			int i = 1;
//			while(i<=9) {
//			System.out.println(dan+" * "+ i + " = "+(dan*i));
//			i++;
//			}
//		}else {
//			System.out.println("범위를 벗어남");
//		}
		
		
		//사용자가 선택한 구구단 출력,2~9단만 출력
		//무한반복해보기 (0누르면 종료)
		
		Scanner sc = new Scanner(System.in);
		while(true) {
		System.out.print("단 입력 (0누르면 종료): ");
		int dan = Integer.parseInt(sc.nextLine());
		if(dan==0) break;
		else if(2<=dan&&dan<=9) {
			for(int i=1; i<=9; i++) {
				System.out.println(dan+"x"+i+"="+(dan*i));
			}
		  }else {
			  System.out.println("다시 입력");
		  }
		}
	}
}

