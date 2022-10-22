import java.util.Scanner;

public class Up_Down {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		 Scanner sc = new Scanner(System.in);
		 int min=999;
		 int score=0;
		A : while(true) {
			System.out.println("== Up & Down Game ==");
			System.out.println();
			System.out.println("1. Game Start");
			System.out.println("2. Game Score");
			System.out.println("3. End Game");
			System.out.print("> ");
			int menu = Integer.parseInt(sc.nextLine()); //메뉴입력
			int rand = (int)(Math.random()*99)+1;
			
			
			switch(menu) {
				 case 1:
					System.out.println("<< Game Start >>");
					score=1;
					while(true) {
						System.out.print("Input Number : ");
						int input = Integer.parseInt(sc.nextLine()); //임의의 수 입력
						if(input>rand) {
							System.out.println("<< D O W N >>");
							score++;
							continue;
						}else if(input<rand) {
							System.out.println("<< U P >>");
							score++;
							continue;
						}else {
							System.out.println("<< 정 답 >>");
								System.out.println("현재 기록은 "+score+"번 입니다.");
						}
						break; 
						}
					break;
					
				case 2:
					System.out.println("<< S C O R E >>");
					if(score<min) {
						min=score;
					}else if(score<min) {
						min=score;
					}else {
						min=min;
					}
					System.out.println("현재 까지 최단 기록은 "+min+"번입니다.");
					break;
				case 3:
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
		
			}
			
		}
		
	}

}
