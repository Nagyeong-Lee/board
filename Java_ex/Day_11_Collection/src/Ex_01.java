
public class Ex_01 {
	public static void main(String[] args) {

		String[]arr=new String[10];
		arr[0]="Hello";
		arr[1]="World";
		arr[2]="Collection";
		
		arr[0]=arr[1];
		arr[1]=arr[2];
		arr[0]=null;
		
		System.out.println("배열예제");
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		
		System.out.println(arr.length); //배열 전체의 크기
	}
}
//Collection
//ArrayList -> LinkedList
//ArrayList는 배열길이 맞춰서 자동으로 배열생성해주는 배열
//LinkedList는 배열아님/배열처럼 연결된 구조/주소를 기억하고 다 떨어져있음
//LinkedList는 검색효율이 떨어져서 Tree알고리즘사용
