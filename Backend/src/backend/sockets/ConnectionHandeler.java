package backend.sockets;

import java.io.BufferedReader;
import java.io.ObjectInputStream;
import java.net.Socket;
import backend.threadsnshit.WriterThread;

public class ConnectionHandeler implements Runnable {
	
	Socket socket;
	WriterThread wt;
	
	public ConnectionHandeler(Socket socket, WriterThread wt){
		this.socket = socket;
		this.wt = wt;
	}
	@Override
	public void run() {
		ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
		StudentInfo input = (StudentInfo) in.readObject();
		wt.addInfo(input);
	}
}
