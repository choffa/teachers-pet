package backend.threadsnshit;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import backend.sockets.ConnectionHandeler;
import backend.sockets.CustomServerSocket;

public class MainListenerThread implements Runnable {

	ServerSocket socket = CustomServerSocket.getSocket();
	Socket ClientSocket;
	@Override
	public void run() {
		startService();
	}
	
	public void startService(){
		while(true){
			try {
				ClientSocket = socket.accept();
				new Thread(new ConnectionHandeler(ClientSocket)).start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
			ClientSocket = null;
			}
		}
	}
}
