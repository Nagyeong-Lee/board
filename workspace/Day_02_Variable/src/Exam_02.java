
public class Exam_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(10 / 3); // 정수끼리 연산결과는 정수.
		System.out.println(10.0 / 3); // TypePromotion
		//System.out.println(10.0 / 3.0);
		
		int sum = 98;
		System.out.println("당신의 총점은 "+sum+"점입니다.");
		//System.out.println("당신의 총점은 "+"98"+"점입니다."); TypePromotion 문자열이 더크니까
														  //문자열끼리 덧셈=연결됨.
		
		//TypePromotion은 작은타입을 큰타입으로 자동 형변환
		//TypeCastiong은 큰타입을 작은타입으로 강제 형변환
		//char=byte TypeCasting필요함, char는 byte보다 크지않다.
		
		byte t = 0;
		short s = 5000;
		t=(byte)s;
		System.out.println(t);
		
		
	}

}
