import java.math.BigInteger;
import java.security.MessageDigest;

public class Ex_01 {d


		public static String getSHA256(String input){

			String toReturn = null;
			try {
			    MessageDigest digest = MessageDigest.getInstance("SHA-256");
			    digest.reset();
			    digest.update(input.getBytes("utf8"));
			    toReturn = String.format("%064x", new BigInteger(1, digest.digest()));
			} catch (Exception e) {
			    e.printStackTrace();
			}
			
			return toReturn;
		    }

public static void main(String[] args) throws Exception  {
	String result=getSHA256("연휴까지 10분 남았다.");
	System.out.println(result);
}
}
