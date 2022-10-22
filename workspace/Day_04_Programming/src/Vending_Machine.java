import java.util.Scanner;

public class Vending_Machine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//		Scanner sc = new Scanner(System.in);
		//		int money=5000;
		//		int cok=0,cid=0,mas=0; //콜라,사이다,매실차 개수
		//		while(true) {
		//			System.out.println("=== 자판기 시뮬레이터 ===");
		//			System.out.println("음료수를 선택하세요.");
		//			System.out.println("1. 콜라(1000) 2. 사이다(800) 3. 매실차(1500) [0. 소지품확인] [9. 종료]");
		//			System.out.print(">> ");
		//			int menu = Integer.parseInt(sc.nextLine());
		//			
		//			if(menu==0) {
		//				System.out.println("=====소지품 목록=====");
		//				System.out.println("소지금 : "+money);
		//				System.out.println("콜라  :   "+cok+"개");
		//				System.out.println("사이다  : "+cid+"개");
		//				System.out.println("매실차  : "+mas+"개");
		//				System.out.println("=====================");
		//			}else if(menu==1) {
		//				if(money>=1000) {
		//				System.out.println("콜라를 구매했습니다.");
		//				System.out.println("콜라 +1");
		//				cok++;
		//				money-=1000;
		//				System.out.println("소지금 -"+money);
		//				}else {
		//					System.out.println("잔액 부족");
		//				}
		//			}else if(menu==2) {
		//				if(money>=800) {
		//				System.out.println("사이다를 구매했습니다.");
		//				System.out.println("사이다 +1");
		//				cid++;
		//				money-=800;
		//				System.out.println("소지금 -"+money);
		//				}else {
		//					System.out.println("잔액 부족");
		//				}
		//			}else if(menu==3) {
		//				if(money>=1500) {
		//				System.out.println("매실차를 구매했습니다.");
		//				System.out.println("매실차 +1");
		//				mas++;
		//				money-=1500;
		//				System.out.println("소지금 -"+money);
		//				}else {
		//					System.out.println("잔액 부족");
		//				}
		//			}else if(menu==9) {
		//				System.out.println("프로그램을 종료합니다.");
		//				break;
		//			}else {
		//				System.out.println("다시 입력하세요.");
		//			}
		//		} //while(true)
		//		
		int money=3000;
		int cok=0,cid=0,plum=0,menu=0;
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("=== 자판기 시뮬레이터 ===");
			System.out.println("음료수를 선택하세요.");
			System.out.println("1. 콜라(1000) 2. 사이다(800) 3. 매실차(1500) [0. 소지품확인] [9. 종료]");
			A:while(true){
				try {
					System.out.print(">> ");
					//menu=sc.nextInt();
					menu = Integer.parseInt(sc.nextLine());
					break A; 
				}catch(Exception e) {
					System.out.println("숫자를 입력해주세요");
				}
			}
			if(menu==0) {
				System.out.println("=====소지품 목록=====");
				System.out.println("소지금 : "+money);
				System.out.println("콜라 : "+cok);
				System.out.println("사이다 : "+cid);
				System.out.println("매실 : "+plum);
				System.out.println("=====================");
			}else if(menu==1) {
				if(money>=1000) {
					System.out.println("콜라를 구매했습니다.");
					System.out.println("콜라 +1");
					cok++;
					money-=1000;
					System.out.println("소지금 -"+money);
				}else {
					System.out.println("잔액부족");
				}
			}else if(menu==2) {
				if(money>=800) {
					System.out.println("사이다를 구매했습니다.");
					System.out.println("사이다 +1");
					cid++;
					money-=800;
					System.out.println("소지금 -"+money);
				}else {
					System.out.println("잔액부족");
				}
			}else if(menu==3) {
				if(money>=1500) {
					System.out.println("매실차를 구매했습니다.");
					System.out.println("매실차 +1");
					plum++;
					money-=1500;
					System.out.println("소지금 -"+money);
				}else {
					System.out.println("잔액부족");
				}
			}else if(menu==9) {
				System.out.println("프로그램을 종료합니다.");
				break; //--반복문을 나가는것이지 프로그램을 종료하는것은 아님
				//프로그램을 즉시 종료하려면 System.exit(0);을 사용.
			}else {
				System.out.println("다시선택하세요");	
			}

		}

	}
}
