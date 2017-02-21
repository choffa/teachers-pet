package backend.sockets;

import java.io.*;
import java.net.Socket;
import backend.threadsnshit.WriterThread;
import backend.StudentInfo;

public class ConnectionHandeler implements Runnable {
	
	Socket socket;
	WriterThread wt;
	
	public ConnectionHandeler(Socket socket, WriterThread wt){
		this.socket = socket;
		this.wt = wt;
	}
	@Override
	public void run() {
		ObjectInputStream in;
		try {
			in = new ObjectInputStream(socket.getInputStream());
			StudentInfo input = (StudentInfo) in.readObject();
			wt.addInfo(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
