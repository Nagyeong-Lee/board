import java.net.ServerSocket;
import java.net.Socket;

public class Quiz2_server {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		ServerSocket server = new ServerSocket(23000);
		while(true) {
			Socket client = server.accept();
			System.out.println(client.getInetAddress());
			
		}
	}

}
