package backend.sockets;

import java.io.IOException;
import java.net.ServerSocket;

public interface CustomServerSocket {
	final int port = 21;
	public static ServerSocket getSocket() {
		try {
			return new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
