import java.util.ArrayList;

public class Ex_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList <String> arr = new ArrayList<>();  //배열길이 자동설정해줌
		                                  //ArrayList 다형성때문에 다른 자료형 담기OK
		                                  //ArrayList 배열이 object형 배열이라서
		                                  //string,int등 다 담을 수 있음
		
		//ArrayList <String> arr = new ArrayList<>(); //<제네릭> object형 ArrayList를 String형으로 변경
		arr.add("Hello");
		arr.add("World");
		arr.add("Collection");
//		arr.add(100); 					  //arr.add(new Integer(100));으로 autoBoxing
										  //Object 0; 최고조상 extends Object
		System.out.println("ArrayList예제");
		System.out.println(arr.get(0));   //string이 아니라 object형임
		System.out.println(arr.get(1));
		System.out.println();
		System.out.println(arr);
		System.out.println(arr.remove(0)); //0번 인덱스 삭제
		System.out.println(arr);


		arr.add(1, "Hello");
		System.out.println(arr);
		System.out.println(arr.size());   //들어있는 요소의 개수
		
		System.out.println(((String)arr.get(0)).length()); //arr.get(0)이 object형이라서 String으로 형변환해서
		                                                   //length메서드 사용
		
		System.out.println(arr.get(0).length());
		
	}

}
