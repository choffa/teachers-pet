package backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class AppSideSocket implements ServerListener{

	String hostname;
	int port;
	
	public AppSideSocket() throws UnknownHostException, IOException{
		// TODO Make constructor
		Socket echoSocket = new Socket(hostname, port);
		BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
		
	}
	
	@Override
	public void addInfo(StudentInfo info) {
		// TODO Auto-generated method stub
		
	}
	

}
