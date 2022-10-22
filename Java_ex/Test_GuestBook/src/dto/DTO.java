package dto;

import java.sql.Date;

public class DTO {

	private int text_number;
	private Date write_time;
	private String writer;
	private String title;
	private String text;

	public DTO() {}

	public DTO(int text_number, Date write_time, String writer, String title, String text) {
		super();
		this.text_number = text_number;
		this.write_time = write_time;
		this.writer = writer;
		this.title = title;
		this.text = text;
	}

	public int getText_number() {
		return text_number;
	}
	public void setText_number(int text_number) {
		this.text_number = text_number;
	}
	public Date getWrite_time() {
		return write_time;
	}
	public void setWrite_time(Date write_time) {
		this.write_time = write_time;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}



}
