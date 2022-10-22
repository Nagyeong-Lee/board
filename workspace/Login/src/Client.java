import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

   /** NumberformatException 처리 메소드 */
   public static int getValidnum() {

      try (Scanner sc = new Scanner(System.in)) {
         while (true) {
            try {
               int num = Integer.parseInt(sc.nextLine());
               return num;

            } catch (NumberFormatException e) {
               System.out.println("숫자를 입력해주세요.");
            }
         }
      }

   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      try (
            Socket client = new Socket("localhost", 25000);
            DataInputStream dis = new DataInputStream(client.getInputStream());
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());) {

         while (true) {
            login: while (true) {
               System.out.println("접속이 완료되었습니다.");
               System.out.println("1. 로그인");
               System.out.println("2. 회원가입");
               System.out.print(">>> ");
               int menu = Integer.parseInt(sc.nextLine());
                     //getValidnum();
               if (menu == 1) { // login
                  dos.writeBoolean(true);
                  
                  System.out.println("로그인");
                  System.out.print("ID 입력 : ");
                  String uId = sc.nextLine();
                  dos.writeUTF(uId);
                  System.out.print("PW 입력 : ");
                  String uPw = sc.nextLine();
                  dos.writeUTF(uPw);
                  dos.flush();
                  boolean isLogined = dis.readBoolean();
                  if (isLogined == true) {
                     System.out.println("로그인 완료");
                     break login;
                  } else if (isLogined == false) {
                     System.out.println("로그인 실패");
                     continue;
                  }
               } else if (menu == 2) { // regist
                  dos.writeBoolean(false);
               
                  System.out.println("회원가입");
                  System.out.print("생성할 ID 입력 : ");
                  String uId = sc.nextLine();
                  dos.writeUTF(uId);
                  System.out.print("PW 입력 : ");
                  String uPw = sc.nextLine();
                  dos.writeUTF(uPw);
                  dos.flush();
                  boolean isRegisted = dis.readBoolean();
                  if (isRegisted == true) {
                     System.out.println("회원가입 완료");
                     continue;
                  } else if (isRegisted == false) {
                     System.out.println("회원가입 실패");
                     continue;
                  }
               }
            }

         }

      } catch (

      Exception e) {
         e.printStackTrace();
         System.out.println("서버가 종료되었습니다.");
         System.exit(0);
      }
   }
}