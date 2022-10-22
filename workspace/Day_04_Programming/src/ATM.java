import java.util.Scanner;

public class ATM{
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int money=1200; int menu=0;
		while(true) {
			System.out.println("*** ATM 시뮬레이터 ***");
			System.out.println("1. 잔액조회");
			System.out.println("2. 입금하기");
			System.out.println("3. 출금하기");
			System.out.println("4. 종료하기");
			while(true) {
				System.out.print(">> ");
				try {
				menu = Integer.parseInt(sc.nextLine());
				break;
				}catch(Exception e) {
					System.out.println("숫자를 입력해주세요.");
					continue;
				}
			}
			
			if(menu==1) {
				System.out.println("현재 보유 잔액은 "+money+"원입니다.");
			}else if(menu==2) {
				System.out.println("얼마를 입금하시겠습니까?");
				int input = Integer.parseInt(sc.nextLine());
				System.out.println(input+"원이 입금되었습니다.");
				money+=input;
			}else if(menu==3) {
				System.out.println("얼마를 출금하시겠습니까?");
				int output = Integer.parseInt(sc.nextLine());
					if(money >= output) {
						System.out.println(output+"원이 출금되었습니다.");
						money-=output;
					}else {
						System.out.println("잔액이 부족합니다.");
					}
			}else if(menu==4) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}else {
				System.out.println("다시 입력해주세요");
			}
		}
	}
}