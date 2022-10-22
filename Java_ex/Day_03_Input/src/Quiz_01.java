import java.util.Scanner;

public class Quiz_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println(" << 방문록 >> ");
		System.out.println("이름과 연락처를 작성해주세요.");
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("연락처 : ");
		String number = sc.nextLine();
		System.out.println("========================");
		System.out.println("저는 "+name+"입니다.");
		System.out.println(number+"로 전화주세요.");
		
		int num = Integer.parseInt(sc.nextLine()); //숫자로 분석할 수 없다면 에러남
		System.out.println(num+10);
	}
}
