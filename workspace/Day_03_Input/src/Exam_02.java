import java.util.Scanner; 

public class Exam_02{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // 문자열/숫자를 입력받을때 사용.
		System.out.print("입력 : ");
		String str = sc.nextLine(); //엔터까지 받음
		System.out.println(str);
		
		System.out.print("입력 : ");
		String str2 = sc.nextLine(); //엔터까지 받음
		System.out.println(str2);
	}
	
}