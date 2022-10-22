import java.util.Arrays;
import java.util.Scanner;

public class Exam_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//값 입력받아서 배열 출력
//		Scanner sc = new Scanner(System.in);
//		int[]arr=new int[4];
//		for(int i=0; i<arr.length; i++) {
//			System.out.print(i+"번째값 : ");
//			arr[i]=sc.nextInt();
//			System.out.println("arr["+i+"] : "+arr[i]);
//		}
//		System.out.println(Arrays.toString(arr));
//
//	
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 번 입력할거냐? : ");
		int num=sc.nextInt();
		
		int[]arr=new int[num];
		for(int i=0; i<arr.length; i++) {
			arr[i]=sc.nextInt();
		}
		System.out.println(Arrays.toString(arr));
	}

}
