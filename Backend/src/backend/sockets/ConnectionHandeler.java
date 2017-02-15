package backend.sockets;

import java.io.BufferedReader;
import java.net.Socket;

public class ConnectionHandeler implements Runnable {
	
	Socket socket;
	
	public ConnectionHandeler(Socket socket){
		this.socket = socket;
	}
	@Override
	public void run() {
		while (true) {
			BufferedReader in = new BufferedReader(socket.getInputStream());
			String s = in.readLine();
			if (s != null){
				parseString(s);
			} else {
				//s is null and connection is broken
				break;
			}
		}
	}
	
	private void parseString(String inputString) throws Exception{
		/*
		 * Suggested String format:
		 * FagkodeDato#gammelRating#NyRating
		 */
		String[] inputs = inputString.split('#');
		String fag = inputs[0];
		byte oldValue = Byte.parseByte(inputs[1]);
		byte newValue = Byte.parseByte(inputs[2]);
		
		//Check the if the input is valid
		if (inputs.length > 3 || oldValue<0 || newValue<0 || oldValue>5 || newValue[2]>5){
			throw new Exception("Illegal String given!");
		}
		
		//Set the student info
		StudentInfo SI = new StudentInfo();
		SI.setfag(fag);
		SI.setRank(newValue);
		SI.setOldRank(oldValue);
	}

}
