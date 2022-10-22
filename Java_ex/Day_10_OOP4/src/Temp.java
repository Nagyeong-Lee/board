
public class Temp{
	
	public int a;
	public static int b;
	
	public void funcA() {
		a=10;
		b=20;
	}
	
	public static void funcB() {
		// a=30; 에러 funcB()실행 시점에 a가 없어서
		b=30;
	}

}

// iv는 객체 생성시 생성.
/* cv는 메모리의 heap메모리에 main메서드 실행과 동시에 생성.
 * 인스턴스에는 숨겨진 영역?이 있는데 그곳을 통해서 static멤버에 접근가능.
 *
 * Static --> 프로그램 전체에서 사용하는 변수를 static으로
 * 장점: scope 이슈에서 자유롭다/언제 어디서나 즉각 사용가능
 * 단점: 메모리 효율성이 떨어지고 동시성 이슈 가짐
 *
 */

