package frontend;

import java.net.*;

import backend.StudentInfo;

import java.io.*;

public class AppWriter implements Runnable {

	private Socket socket;
	private StudentInfo si = null;
	private ObjectOutputStream out;
	private final String URL = "localhost";
	private final int port = 21;
	
	public AppWriter(){
		try {
			socket = new Socket(URL, port);
			out = new ObjectOutputStream(socket.getOutputStream());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public AppWriter(StudentInfo si){
		this();
		this.si = si;
	}
	
	@Override
	public void run() {
		try {
			System.out.println(socket.getInetAddress().getHostAddress());
			System.out.println(socket.getInetAddress().getHostName());
			System.out.println(socket.isConnected());
			out.writeObject(si);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setInfo(StudentInfo si){
		this.si = si;
	}
	
	public static void main(String[] args) {
		AppWriter aw = new AppWriter(new StudentInfo("Hello", (byte)1, (byte)2));
		aw.run();
	}

}
