package backend;

import java.net.Socket;
//Hjelpeinterface. spesifiserer hva serversiden m� kunne gj�re.
public interface ServerListener{
    public void addInfo(StudentInfo info);
}