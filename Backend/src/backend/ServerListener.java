package backend;

import java.net.Socket;
//Hjelpeinterface. spesifiserer hva serversiden må kunne gjøre.
public interface ServerListener{
    public void addInfo(StudentInfo info);
}