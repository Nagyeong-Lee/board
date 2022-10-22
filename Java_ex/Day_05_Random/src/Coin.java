import java.util.Scanner;

public class Coin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("===동전 앞 뒤 맞추기===");
			System.out.print("숫자를 입력해주세요(1.앞면/2.뒷면) : ");
			int num=sc.nextInt();
			int rand=(int)(Math.random()*2)+1;
			if(rand==num) {
				System.out.println("맞췄습니다.");
				System.out.println("-------------->restart");
				continue;
			}else {
				System.out.println("틀렸습니다.");
				break;
			}
		}
	}

}
