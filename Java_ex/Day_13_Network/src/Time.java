import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

//		System.out.println(System.currentTimeMillis());
//		//TimeStamp란 epoch time으로 부터 현재까지 흐른 시간을 초값으로 표현한 값
//		//epoch time 1970/01/01/0시
//		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		String date = sdf.format(System.currentTimeMillis());
//		System.out.println(date);
//		
//
//		Date result=sdf.parse("1990/12/25 14:00:00");
//		System.out.println(result.getTime());
		
//		System.out.println(System.currentTimeMillis());
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH:mm:ss");
//		String date=sdf.format(System.currentTimeMillis());
//		System.out.println(date);
//		
//		Date dt = sdf.parse("2000.12.16.24:3:1");
//		System.out.println(dt.getTime());

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd : HH : mm : ss");
		System.out.println(sdf.format(System.currentTimeMillis()));
		
		Date d = sdf.parse("2000.11.01 : 6 : 5 : 5");
		System.out.println(d.getTime());
	}

}
