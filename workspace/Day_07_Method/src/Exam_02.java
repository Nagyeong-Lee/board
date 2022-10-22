
public class Exam_02 {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		func(true);
//	}
//	
//	//Method Overloading 
//	//메서드 이름이 같아도 매개변수 개수,타입이 다르면
//	//서로 다른 메서드로 인식하여 처리
//	public static void func() {
//		System.out.println(1);
//	}
//	
//	public static void func(int x) {
//		System.out.println(2);
//	}
//	
//	public static void func(int x,int y) {
//		System.out.println(4);
//	}
//
//	public static void func(boolean b) {
//		System.out.println(3);
//	}
//	public static int func(int num) {
//		return 10;
//	}
//	public static void main(String[] args) {
//		System.out.println(func(10));
//	}
	
	//리턴값 여러개 받으려면 배열로 받기
	public static void func(int[]arr) {
		arr[0]=1;
		arr[1]=2;
	}
	public static void main(String[] args) {
		int[]arr= {100,200};
		func(arr);
		System.out.println(arr[0]);
		System.out.println(arr[1]);
	}
}
