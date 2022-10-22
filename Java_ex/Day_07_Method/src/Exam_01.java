
public class Exam_01 {

	public static int plus(int n, int m) { //-->parameter
		return n+m;
	}
	
	public static void main(String[] args) {
//		//System.out.println(plus(10,5));
//		//plus(10,5) -->int형 반환되니까 int형임 / argument 인자값
//		int r1=minus(10,5);
//		int r2=mply(10,5);
//		double r3=divide(10,5);
////		System.out.println(r1);
////		System.out.println(r2);
////		System.out.println(r3);
////		System.out.println(bigger(5,7));
////		System.out.println(translate("d"));
//		int n=minus(10,5)+5;
//		System.out.println(n);
		String str="Hello,World";
//		for(int i=0; i<str.length(); i++) {
//			System.out.println(str.charAt(i));
//		}
		
		System.out.println(str.startsWith("Hel"));
		System.out.println(str.endsWith(" W"));
		System.out.println(str.charAt(0));
		System.out.println(str.contains("orld"));
		System.out.println(str.equals("hello World"));
		System.out.println();
		System.out.println(str.contains("W"));
		System.out.println(str.indexOf("W"));
		
		//split 
		String[]arr= str.split(",");
		for(String s:arr) {
			System.out.println(s);
		}
	}
	
	//2개의 정수를 인자값으로 받아 뺄셈한 결과를 반환하는 minus메서드
	//2개의 정수를 인자값으로 받아 곱셈한 결과를 반환하는 multiple메서드
	//2개의 정수를 인자값으로 받아 나눈 결과를 반환하는 divide메서드
	//2개의 정수를 인자값으로 받아 더 큰수를 반환하는 bigger메서드
	public static int minus(int a, int b) {
		return a-b;
	}
	
	public static int mply(int a, int b) {
		return a*b;
	}
	public static double divide(int a, int b) {
		return a/(double)b;
	}
	public static int bigger(int a, int b) {
		return a>b? a: (a<b? b: 0);
	}
	
	//사과라고 전달하면 apple반환 포도전달 grape반환 translate 메소드 작성
	//기타다른단어 전달 None리턴
	
	public static String translate(String str) {
		if(str.equals("사과")) {
			return "apple";
		}else if(str.equals("포도")) {
			return "grape";
		}else {
			return "None";
		}
	}

}

