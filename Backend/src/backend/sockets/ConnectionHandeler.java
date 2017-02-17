package backend.sockets;

import java.io.BufferedReader;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ConnectionHandeler implements Runnable {
	
	Socket socket;
	
	public ConnectionHandeler(Socket socket){
		this.socket = socket;
	}
	@Override
	public void run() {
		ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
		StudentInfo input = (StudentInfo) in.readObject();
		//What should I do with this input?
	}
}
