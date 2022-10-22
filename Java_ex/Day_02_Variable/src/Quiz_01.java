
public class Quiz_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		byte b = 10;
		short s = 20;
		char c = 'A';
		int i;
		float f;
		long l = 100L;
		
		s = b;
		c = (char)b; //byte는 음수를 담을수있지만,char은 음수를 담을수없어서 promotion못함 Casting필요
		s = (short)c;//short는 음수를 담을수있지만,char은 음수를 담을수없어서 promotion못함 Casting필요
		c = (char)s;
		i= (int)100L;
		l = 500;
		f = l;
		f =(float)5.11;
		
		byte b2 = 10;
		char ch2 = 'A';
		int i2 = 100;
		long l2 = 1000L;
		
		b2 = (byte)i2;
		ch2 = (char)b2;
		short s2 = (short)ch2;
		float f2 = l2;
		i2 = ch2; //굳이 Casting? 필요없지;;
		System.out.println(ch2);
		System.out.println(i2);
		
		int i3 = 10;
		int i4 = 20;
		float f3 = 3.14f;
		char c3 = 'A';
		char c4 = 'B';
		
		System.out.println("결과 : "+i3+i4);
		System.out.println("결과 : "+(i3+i4));
		System.out.println("결과 : "+i3+f3);
		System.out.println("결과 : "+(i3+f3));
		System.out.println("결과 : "+f3+c3);
		System.out.println("결과 : "+(f3+c3));
		System.out.println("결과 : "+c3+c4);
		System.out.println("결과 : "+(c3+c4));
		
	}

}
