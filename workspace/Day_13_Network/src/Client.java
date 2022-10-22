import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Client {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		/*Server : 서비스를 제공하는 장비/사람
		 *Client : 제공되는 서비스를 이용하는 고객
		 *IP주소  : 네트워크 상에서 컴퓨터 한대 한대를 각각 특정지을 수 있는 고유 주소값
		 *Port번호: 컴퓨터 내에서 서비스를 구분짓는 고유 번호 
		 *		   0~65535번까지 사용가능
		 *         0~1024번 - Well Known Port (잘 알려진게 많아서 저걸로 안씀) 
		 *TCP/UDP: Transmission Control Protocol -신뢰성중시, 성능 경시
		 *		   User Datagram Protocol - 성능 중시, 신뢰성 경시
		 *Socket : 네트워크 프로그램이 통신을 수행하기 위해 필요한 논리적 단말기
		 *		   네트워크 프로그램 간의 연결까지만 담당
		 *Stream : 데이터 전송에 사용되는 다리(통로) 
		 *         Ram으로 데이터가 들어오면 InputStream ex)FileInputStream
		 *		   Ram에서 데이터가 나가면 outputStream
		 *Socket연결이 확인되면 데이터 전송이 되는게 아니라 Stream이 필요
		 */
         //readUTF
		 //DataOutputStream 쓰는 이유: 기본 OutputStream은 데이터를 출력하는 부분이 별로라서
		 //							 DataOutputStream으로 업그레이드
		Socket client = new Socket("localhost",25000);
		//ip주소 : 192.168.50.51
		InputStream is = client.getInputStream();
		DataInputStream dis = new DataInputStream(is); //InputStream 업그레이드
		
		OutputStream os= client.getOutputStream();
		DataOutputStream dos=new DataOutputStream(os);
		while(true) {
		String msg=dis.readUTF();
			System.out.println("서버로부터 전송된 메세지 : "+msg);	
			
			dos.writeUTF(JOptionPane.showInputDialog("메시지 입력 : "));
			dos.flush();
		}	
	}
}
