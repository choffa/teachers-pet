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
		System.out.println("Service started, wt:" + wt.toString());
		while(true){
			try {
				ClientSocket = socket.accept();

				System.out.println("Accepted:" + ClientSocket.toString());

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
		wt.init();
		wt.run();

		System.out.println("wt:" + wt.toString());

		startService();
	}
	
	public static void main(String[] args) {
		MainListenerThread mlt = new MainListenerThread();
		System.out.println("Created mlt");
		mlt.run();
	}
}
