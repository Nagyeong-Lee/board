import java.util.Scanner;


public class Race {



	public static void main(String[] args) {

		// TODO Auto-generated method stub



		Scanner sc = new Scanner(System.in);

		int money=0;  //잔액

		while(true) {

			int rand = (int)(Math.random()*3)+1;

			System.out.println("---------------------------------------------------");

			System.out.println("<<< 경마게임에 오신 것을 환영합니다. >>>");

			System.out.println("1. 게임시작");

			System.out.println("2. 잔액충전");

			System.out.println("3. 잔액조회");

			System.out.println("4. 게임종료");

			System.out.println("메뉴를 선택해주세요.");

			System.out.print(">>");

			int menu=Integer.parseInt(sc.nextLine()); //메뉴선택

			if(!(menu==1)&&!(menu==2)&&!(menu==3)&&!(menu==4)) {

				System.out.println("메뉴를 다시 선택해주세요.");

				continue;

			}

			

			

			if(menu==1) {

				System.out.println("게임을 시작합니다.");

				

				System.out.println("1.우승 경력이 많지만 은퇴를 앞둔 말");

				System.out.println("2.이번달 성적이 제일 좋은 말");

				System.out.println("3.최근 떠오르는 신예인 말");

				System.out.print("배팅하고 싶은 말을 선택해주세요.>>");

				int horse = Integer.parseInt(sc.nextLine());//말 선택

				while(true) {

				System.out.print("얼마를 배팅하시겠습니까?:");

				int batMoney = Integer.parseInt(sc.nextLine());//배팅머니

				if(batMoney>money) {

					System.out.println("잔액이 부족합니다.");

					continue;

				}else {

				if(rand==1) {

					System.out.println("1번 말이 우승하였습니다.");

				}else if(rand==2) {

					System.out.println("2번 말이 우승하였습니다.");

				}else {

					System.out.println("3번 말이 우승하였습니다.");

				}

				if(rand==horse) {

					System.out.println("배팅에 성공하였습니다.");

					System.out.println("배팅한 금액의 2배인 "+(batMoney*2)+"를 획득하였습니다.");

					money=money-batMoney+(batMoney*2);

				}else if(rand!=horse){

					System.out.println("배팅에 실패하였습니다...^^");

					System.out.println("배팅한 금액인 "+batMoney+"를 모두 잃으셨습니다.");

					money-=batMoney;

				}

			}

				break;

		}

			}

			else if(menu==3) {

				System.out.println("현재 잔액은 : "+money+"원입니다.");

			}else if(menu==2) {

				System.out.print("얼마를 충전하시겠습니까 ?");

				int input = Integer.parseInt(sc.nextLine());//잔액 추가

				System.out.println(input+"원이 충전되었습니다.");

				money+=input;

			}else if(menu==4) {

				System.exit(0); //즉시 종료

			}

		}

	}



}