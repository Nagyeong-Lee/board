import java.util.Arrays;

public class Exam_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//int[]arr; // 배열 참조변수 선언 (배열생성이 아님)
		//new : heap메모리를 쓰겠다는 문법
		//new int[4]; -->heap메모리에 int형 공간 4개생성(배열생성)
		
		
//		int[]arr=new int[4];
//		arr[0]=1;
//		arr[1]=10;
//		arr[2]=100;
//		arr[3]=1000;
//		
//		System.out.println(Arrays.toString(arr));
		
//		int[]arr=new int[100];
//		for(int i=0;i<arr.length; i++) {
//			System.out.println(arr[i]);
//		}
//		int[]arr2= new int[]{1,10,100,1000};
//		
//		char[]arr= {'A','F','Z'};
//		String[]arr2= {"Hello","Array"};
//		
		//int형 배열 arr3 100칸으로 만들고 100~1까지 역순으로 담아라
		int[]arr3=new int[100]; 
		for(int i=0; i<arr3.length; i++) {
			arr3[i]=arr3.length-i;
		}
		for(int i=0; i<arr3.length; i++) {
			System.out.println(arr3[i]);
		}
	
	//char형 배열 arr4를 26칸짜리로 만들고 Z-A까지 담아라

		char x=90;
		char[]arr4=new char[26];
		for(int i=0; i<arr4.length; i++) {
			arr4[i]=x--;
		}
		System.out.println(Arrays.toString(arr4));
		
	//char형 배열 arr5를 26칸짜리로 만들고 A-Z까지 담아라
		char[]arr5=new char[26];
		for(int i=0; i<arr5.length; i++) {
			arr5[i]=(char)('A'+i);
		}
		System.out.println(Arrays.toString(arr5));
	}

}
