
//정보은닉
//public / private/ protected/package (접근제한자) 

public class Tv {          //class 생성시 멤버필드 멤버메서드 생성자 getter.setter필요.

	private int volume;
	private int channel;  //private은 클래스 내부에서만 접근가능
						  //멤버 필드에 무조건 private
	//private final Tv this; /this는 tv타입
	
	public Tv getThis() {
		return this;
	}
	public int getVolume()
	{
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public int getChannel() {
		return channel;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
	public Tv() {}

	//	public void channelDown(int channel) { //channel은 private이라 밖에서 못건드려서 메서드로 채널다운 통제
	//		if(channel > 0) {
	//			channel--;
	//		}
	//		System.out.println(channel);
	//	}
	
	//getter setter 단축키 alt shift s r alt a alt r
}


