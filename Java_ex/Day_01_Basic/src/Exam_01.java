import java.lang.*; // 안써도 쓴것과 같음.

public class Exam_01 { //클래스의 이름==파일의 이름 
	
	public static void main(String[] args) { //프로그램의 시작은 main부터임. K&R방식
		System.out.println("Hello World");
		System.out.printf("%s","나는 조성태야\n");
		System.out.println(10);
		System.out.println("150"+250);
		System.out.println(150+250);
		System.out.println('A'+10);//자바는 char타입을 숫자로 인식, 더 큰 타입으로 맞춰져서 출력
		System.out.println("A"+10);
		System.out.println(3.14f);
		System.out.println("Apple"+" Orange");
		
	}

}

