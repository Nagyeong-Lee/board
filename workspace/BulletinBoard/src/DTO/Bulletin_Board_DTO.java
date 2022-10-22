package DTO;

import java.sql.Timestamp;

public class Bulletin_Board_DTO {

	private int text_num;
	private String writer;
	private String text;
	private Timestamp write_time;

	public Bulletin_Board_DTO() {}

	public Bulletin_Board_DTO(int text_num, String writer, String text, Timestamp write_time) {
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



}
