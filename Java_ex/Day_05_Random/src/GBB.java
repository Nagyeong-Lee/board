import java.util.Scanner;

public class GBB {
	
	public static int myRand(int min, int max){
		return (int)(Math.random()*(max-min+1))+min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//가위바위보 승패결정 중첩if금지
		Scanner sc = new Scanner(System.in);
		while(true) {
			int rand=myRand(1,3);
			System.out.println("===가위 바위 보 게임===");
			System.out.print("숫자를 선택하세요(1.가위/2.바위/3.보) : ");
			int select = sc.nextInt();
			
			if(rand==1) {
				System.out.println("컴퓨터는 가위를 냈습니다.");
			}else if(rand==2) {
				System.out.println("컴퓨터는 바위를 냈습니다.");
			}else if(rand==3) {
				System.out.println("컴퓨터는 보를 냈습니다.");
			}
			
			if(select==1) {
				System.out.println("당신은 가위를 냈습니다.");
			}else if(select==2) {
				System.out.println("당신은 바위를 냈습니다.");
			}else if(select==3){
				System.out.println("당신은 보를 냈습니다.");
			}
			
			System.out.println("========결과=========");
			if((rand==1&&select==2)||(rand==2&&select==3)||(rand==3&&select==1)) {
				System.out.println("당신이 이김");
			}else if(rand==select) {
				System.out.println("무승부.");
			}else {
				System.out.println("컴퓨터가 이김");
			}
			
		}
	}
	
}
