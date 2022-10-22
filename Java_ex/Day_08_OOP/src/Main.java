
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Monitor m = new Monitor(); //Monitor은 참조자료형
//		Monitor.powerOn();
//		m.powerOff();
//		
//		Tv tv = new Tv();
//		tv.volume=20;
//		tv.setVolume(0);
//		System.out.println(tv.getVolume());
//		System.out.println(tv.getChannel());
//		System.out.println(tv.getThis().getThis());
//
//		ClassRoom cl = new ClassRoom();
		Monitor m1 = new Monitor(); //기본 생성자 객체 생성시 딱 한 번만 콜됨, setter대신 객체 생성시 변수 초기화
		Monitor m2 = new Monitor(50,"blue",100.0);
		System.out.println(m2.getPrice());
		System.out.println(m2.getBrand());
		System.out.println(m2.getWeight());
//		System.out.println(m.getPrice());
//		System.out.println(m.getBrand()); //0을 String으로 null로 표현
//		System.out.println(m.getPrice());
//		System.out.println(m.getWeight());
	}

}
