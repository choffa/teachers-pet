package frontend;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import backend.TeacherInfo;

import backend.StudentInfo;

public class AppReader {

	private Socket socket;
	private StudentInfo si = null;
	private ObjectInputStream in;
	private final String URL = "localhost";
	private final int port = 21;
	
	public AppReader(){
		try {
			socket = new Socket(URL, port);
			socket.getKeepAlive();
			in = new ObjectInputStream(socket.getInputStream());
			System.out.println(in.readObject().toString());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public AppReader(StudentInfo si){
		this();
		this.si = si;
	}
}
