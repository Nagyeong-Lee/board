package dto;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class DTO {

	private int text_num;
	private String writer;
	private String text;
	private Timestamp write_time;

	public DTO() {}
	public DTO(int text_num, String writer, String text, Timestamp write_time) {
		super();
		this.text_num = text_num;
		this.writer = writer;
		this.text = text;
		this.write_time = write_time;
	}

	public int getText_num() {
		return text_num;
	}
	public void setText_num(int text_num) {
		this.text_num = text_num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Timestamp getWrite_time() {
		return write_time;
	}
	public void setWrite_time(Timestamp write_time) {
		this.write_time = write_time;
	}

	public String getFormedWrite_time() {   //format형식으로 출력
		SimpleDateFormat sdf = new SimpleDateFormat("MM월dd일 hh시mm분");
		return sdf.format(write_time.getTime());
	}
	
	public String getFormedWrite_timeByString() {  //시간차 몇분전
		
		long curTime=System.currentTimeMillis();
		long writeTime=this.write_time.getTime();
		long gapTime=(curTime-writeTime) / 1000;
		String result="";
		if(gapTime < 60) {
			result= "1분이내";
		}else if(gapTime < 600) {
			result= "10분이내";
		}else if(gapTime < 3600) {
			result= "1시간이내";
		}else if(gapTime < 43200) {
			result= "12시간이내";
		}else if(gapTime <86400) {
			result= "24시간이내";
		}
		return result;
	}

}
