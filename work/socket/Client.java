import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;
 
public class Client {
 
    public static void main(String[] args) throws Exception {
         
        // 연길시에 소켓이 생성된다. 연결이 안될경우에는 예외발생한다.
        Socket sk = new Socket("127.0.0.1" , 5050);
        System.out.println("서버와 접속이 되었습니다.");
         
        InputStream ins = sk.getInputStream(); //inputstream 과 연결되었음
         
        DataInputStream dins = new DataInputStream(ins);
         
        String str= dins.readUTF();
        int number = dins.readInt(); // 정수형형태로 데이터를 읽어오기 위한 메소드
        System.out.println("서버에서 전송된 값 : " + number);
        System.out.println("서버에서 전송된 문자 : " + str);
         
        dins.close();
		ins.close();
		sk.close();
	}
}