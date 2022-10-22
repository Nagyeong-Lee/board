import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;

public class Quiz_server {

	public static void main(String[] args) throws Exception{  //throws 하면안됨 try-catch로 잡아야함
		// TODO Auto-generated method stub


		//		try(
		//				){}catch() {}
		ServerSocket server= new ServerSocket(25000);
		Socket socket=server.accept();
		System.out.println("연결");

		InputStream is = socket.getInputStream();
		DataInputStream dis = new DataInputStream(is);

		OutputStream os = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd HH mm ss");
		String date = sdf.format(System.currentTimeMillis());

		String[]wiseWord = {"a","b","c"};
		while(true){

			String str=dis.readUTF();
			if(str.equals("date")) {
				dos.writeUTF(date);
				dos.flush();
				if(!(str.equals("date"))) {
					dos.writeUTF("다시");
					dos.flush();
				}
			}else if(str.equals("lotto")) {
				int[]arr=new int[45];

				for(int i=0; i<arr.length; i++) {
					arr[i]=i+1;
				}
				for(int i=0; i<arr.length*10; i++) {
					int x=(int)(Math.random()*45);
					int y=(int)(Math.random()*45);
					int temp=arr[x];
					arr[x]=arr[y];
					arr[y]=temp;
				}
				dos.writeUTF(arr[0]+" "+arr[1]+" "+arr[2]+" "+arr[3]+" "+arr[4]+" "+arr[5]);
				dos.flush();
			}else if(str.equals("wiseword")) {
				dos.writeUTF(String.valueOf(wiseWord[(int)Math.random()*3]));
				dos.flush();
			}else {
				dos.writeUTF("다시");
				dos.flush();
			}
		}

	}

}
