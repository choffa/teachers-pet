package backend.threadsnshit;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import backend.database.InputDatabase;
import backend.sockets.ConnectionHandeler;
import backend.sockets.CustomServerSocket;

public class MainListenerThread implements Runnable {

	ServerSocket socket = CustomServerSocket.getSocket();
	Socket ClientSocket;
	WriterThread wt;

	//Hander connections til handler.
	public void startService(){
		while(true){
			try {
				ClientSocket = socket.accept();
				new Thread(new ConnectionHandeler(ClientSocket, wt)).start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
			ClientSocket = null;
			}
		}
	}
	
	
	
	
	
	
	
	
	@Override
	public void run() {
		wt = new WriterThread();
		wt.init(new InputDatabase());
		wt.run();
		startService();
	}
}
