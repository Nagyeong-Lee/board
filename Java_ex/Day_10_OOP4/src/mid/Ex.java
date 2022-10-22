package mid;

public class Ex {    //다형성

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		A a2 = new B();  //upCasting
		
//		((B)a2).funcB(); //참조변수를 형변환해서 자식객체에 접근
		                 //dowCasting
		
		((B)a2).callSuper();
		
	}
}

class A{
	public void funcA() {
		System.out.println("func A");
	}
}

class B extends A{
	public void funcB() {
		System.out.println("func B");
	}
	public void funcA() {
		System.out.println("func B");   //메소드 오버라이딩하면 다형성에서 호출시 B클래스 메소드부터 실행
	}
	
	public void callSuper() {
		super.funcA();
	}
}                     
	// 다형성	  
	// 상속관계일때만 OK
	// 상속관계에 놓여있는 두 클래스 사이에서
	// 상위클래스(부모)참조 변수는 자신을 상속받는 하위클래스 인스턴스의
	// 주소를 저장할 수 있다.
