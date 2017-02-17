package backend.sockets;

import java.io.IOException;
import java.net.ServerSocket;

public interface CustomServerSocket {
	private int port = 21;
	private ServerSocket ss = new ServerSocket(port);
	public static ServerSocket getSocket() {
		return ss;
	}
}
