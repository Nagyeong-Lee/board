import java.util.Scanner;

public class Lotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Scanner sc = new Scanner(System.in);
//		int count=0;
//		while(true) {
//			System.out.println("1.로또 번호 추첨");
//			System.out.println("2.로또 수동 구매");
//			System.out.println("0.시뮬레이터 종료");
//			System.out.print(">> ");
//			int menu=sc.nextInt();
//
//			int[]lotto=new int[45];
//			for(int i=0; i<lotto.length; i++) {
//				lotto[i]=i+1;     //초기화
//			}
//
//			for(int i=0; i<lotto.length*10; i++) {
//				int x=(int)(Math.random()*45);			
//				int y=(int)(Math.random()*45);	
//
//				int tmp=lotto[x];
//				lotto[x]=lotto[y];              //섞기
//				lotto[y]=tmp;                
//			}
//
//			if(menu==1) {
//				System.out.println("추첨 번호는 ");
//
//				for(int i=0; i<7; i++) {
//					while(i<=5) {
//						System.out.print(lotto[i++]+" ");
//					}
//					System.out.println("번 입니다.");
//					System.out.println("보너스 번호 추첨 : "+lotto[6]);
//				}
//
//			}else if(menu==2) {
//
//				for(int i=0; i<7; i++){
//					System.out.print((lotto[i]+" "));
//				}
//				System.out.println();
//
//				for(int i=1; i<=6; i++) { //번호 맞는지 확인
//					System.out.print((i)+"번째 번호 선택 (1~45) : ");
//					int number=sc.nextInt();
//
//					if(lotto[i-1]==number || number==lotto[6]) 
//						count++;
//				}
//				switch(count) {
//				case 3:
//					System.out.println("5등");
//					break;
//				case 4:
//					System.out.println("4등");
//					break;
//				case 5:
//					System.out.println("3등");
//					break;
//				case 6:
//					System.out.println("2등");
//					break;
//				case 7:
//					System.out.println("1등");
//					break;
//				default:
//					System.out.println("꽝");
//				}
//
//			}else if(menu==0) {
//				System.out.println("프로그램 종료");
//				System.exit(0);
//			}
//		}
		//보너스 맞추고, 정답 5개맞추면 2등
		
		
		
	}
}
