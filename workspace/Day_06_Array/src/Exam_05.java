import java.util.Arrays;

public class Exam_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//		for(int i=1; i<=3; i++) {
		//			int rand=(int)(Math.random()*5)+1;
		//			System.out.println(rand);
		//		}
		//난수 겹치지 않게 출력 이중루프,swap,체크  ???????
		//카드 섞기 알고리즘 로또
		//		int[]card= {1,2,3,4,5};
		//		
		//		for(int i=0;i<card.length*10; i++) { //너무 적게 섞으면 안되고 어느정도 섞어주기
		//			int x=(int)(Math.random()*5); //0~4
		//			int y=(int)(Math.random()*5); //0~4
		//			
		//			int tmp=card[x]; //x,y에 같은 수가 나온다면 교환을 안하겠다.
		//			card[x]=card[y];
		//			card[y]=tmp;
		//		}
		//		System.out.println(card[0]+"\t"+card[1]+"\t"+card[2]);
			
//			int[]shuffle= {1,2,3,4,5,6};
//			
//			for(int i=0; i<shuffle.length*10; i++) {
//				int x=(int)(Math.random()*6);
//				int y=(int)(Math.random()*6);
//				int temp=shuffle[x];
//				shuffle[x]=shuffle[y];
//				shuffle[y]=temp;
//			}
//			for(int i=0; i<shuffle.length; i++) {
//				System.out.println(shuffle[i]);
//			}
		
//		int[]card= {1,2,3,4,5};
//		for(int i=0; i<card.length*5; i++) {
//			int x=(int)(Math.random()*5);
//			int y=(int)(Math.random()*5);
//		
//			int temp=card[x];
//			card[x]=card[y];
//			card[y]=temp;
//		}for(int i=0; i<card.length; i++) {
//			System.out.println(card[i]);
//		}
		
		int[]arr= {1,2,3,4,5,6};
		for(int i=0; i<arr.length*10; i++) {
			int x=(int)(Math.random()*6);
			int y=(int)(Math.random()*6);
			
			int tmp=arr[x];
			arr[x]=arr[y];
			arr[y]=tmp;
		}
		System.out.println(Arrays.toString(arr));
	}
}
