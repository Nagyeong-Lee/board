
//ASCII코드 반환 프로그램
public class Exam_01{
	
	public static void main(String[] args) throws Exception {
		System.out.print("한 글자를 입력하세요 : ");
		int a1 = System.in.read(); //System.in.read()는 문자하나를 int형으로 반환
		System.out.println("입력하신 문자는 "+a1+"입니다.");
		
		System.out.print("한 글자를 입력하세요 : ");
		int a2 = System.in.read(); //System.in.read()는 문자하나를 int형으로 반환
		System.out.println("입력하신 문자는 "+a2+"입니다.");
		
		System.out.print("한 글자를 입력하세요 : ");
		int a3 = System.in.read(); //System.in.read()는 문자하나를 int형으로 반환
		System.out.println("입력하신 문자 "+(char)a3+"는 "+a3+"입니다.");
		
		System.out.print("한 글자를 입력하세요 : ");
		int a4 = System.in.read(); //System.in.read()는 문자하나를 int형으로 반환
		System.out.println("입력하신 문자 "+(char)a4+"는 "+a4+"입니다.");
		
		System.out.print("한 글자를 입력하세요 : ");
		int a5 = System.in.read(); //System.in.read()는 문자하나를 int형으로 반환
		System.out.println("입력하신 문자 "+(char)a5+"는 "+a5+"입니다.");
	}
}
