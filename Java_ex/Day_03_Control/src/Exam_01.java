import java.util.Scanner;

public class Exam_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("당신이 좋아하는 과일을 선택하세요. ");
		System.out.println("1. 사과 2. 망고 3. 포도");
		System.out.print(">> ");
		int menu = Integer.parseInt(sc.nextLine());
		if(menu==1) {
			System.out.println("사과는 apple입니다.");
		}else if(menu==2){
			System.out.println("망고는 mango입니다.");
		}else if(menu==3) {
			System.out.println("포도는 grape입니다.");
		}else {
			System.out.println("메뉴를 다시 확인해주세요");
		}
		//else if 와 else는 선택사항
	}

}
