
public class Quiz_01 { //countS 메소드 생성

//	static int count=0;
//	public static void main(String[] args) {
//		String str="SAMSUNGSSsS";
//		int count= countS(str);
//		System.out.println("대문자 S의 개수 : "+count);
//	}
//
//	public static int countS(String str) {
//				String[]arr=str.split("");
//				for(String s:arr) {
//					if(s.equals("S")) {
//						count++;
//					}
//				}
//				return count;
//
//		int count=0;
//		for(int i=0; i<str.length(); i++) {
//			if(str.charAt(i)=='S') {
//				count++;
//			}
//		}
//		return count;
//	}
	
	//문자열에서 원하는 문자 찾는 메소드

	public static void main(String[] args) {
		String str="samsung";
		int count=countChar(str,'m');
		System.out.println(count);
	}
	
	public static int countChar(String str, char ch) {
		int count=0;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)==ch) {
				count++;
			}
		}
		return count;
	}
	
}
