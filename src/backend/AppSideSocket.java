package backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class AppSideSocket implements ServerListener{

	String hostname = "localhost";
	Socket clientSocket;
	BufferedReader in;
	int port = 21;
	
	public AppSideSocket() throws UnknownHostException, IOException{
		// TODO Make constructor
		clientSocket = new Socket(hostname, port);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
	}
	
	@Override
	public void addInfo(StudentInfo info) {
		// TODO Auto-generated method stub
		
	}
	
	public void read(){
		try {
			while (true){
				if (in.ready()){
					System.out.println(in.readLine());
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Tried to read");
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		AppSideSocket a = new AppSideSocket();
		a.read();
	}

}
