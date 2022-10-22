package dto;

import java.sql.Timestamp;

import java.text.SimpleDateFormat;


public class DTO {

		private int write_num;
		private String writer;
		private String text;
		private Timestamp write_date;

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

		public int getWrite_num() {
			return write_num;
		}

		public void setwrite_num(int write_num) {
			this.write_num = write_num;
		}



		public Timestamp getWrite_date() {
			return write_date;
		}

		public void setWrite_date(Timestamp write_date) {

			this.write_date=write_date;

		}



		public DTO() {}

		public DTO(int write_num,String writer, String text,Timestamp write_date) {

			super();

			this.writer = writer;

			this.text = text;

			this.write_num = write_num;

			this.write_date=write_date;

		}



		public String getFormedDate() {

			long write_time=write_date.getTime();

			long current_time=System.currentTimeMillis();

			long timeGap=(current_time-write_time);

			if(timeGap <60*1000) {

				return "1분 이내";

			}else if(timeGap <300*1000) {

				return "5분 이내";

			}else if(timeGap <3600*1000) {

				return "1시간 이내";

			}else if(timeGap <86400*1000) {

				return "24시간 이내";

			}else {

				SimpleDateFormat sdf = new SimpleDateFormat("MM월dd일hh시mm분");

				return sdf.format(write_date);

			}

		}

	}
