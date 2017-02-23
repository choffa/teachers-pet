package frontend;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import backend.TeacherInfo;

import backend.StudentInfo;

public class AppReader implements Runnable {

	private Socket socket;
	private StudentInfo si = null;
	private ObjectInputStream in;
	private final String URL = "localhost";
	private final int port = 21;
	
	public void run(){
		while(true){
		try {
			if(socket==null){
			socket = new Socket(URL, port);
			}
			in = new ObjectInputStream(socket.getInputStream());
			System.out.println(in.readObject().toString());
			socket.getKeepAlive();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} continue;
		}
	}


}
