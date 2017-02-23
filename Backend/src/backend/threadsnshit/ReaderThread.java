package backend.threadsnshit;

import java.util.ArrayList;

import backend.TeacherInfo;
import backend.database.InputDatabase;
import backend.sockets.ConnectionHandeler;


/**
 * @author Mathias, aka the best Author. He got better Authoring then everyone. Cause he's the best author.
 *
 */
public class ReaderThread implements Runnable{

	InputDatabase idb;
	ArrayList<ConnectionHandeler> teachers = new ArrayList<ConnectionHandeler>();
	
	public void listen(ConnectionHandeler h){
		teachers.add(h);
	}
	
	public void init(InputDatabase db){
		idb = db;
	}
	
	@Override
	public void run() {
		TeacherInfo t;
		while(true){

			
			try{
				Thread.sleep(10000);
			} catch(Exception e){}
			t = new TeacherInfo(idb.getGjennomsnitt(), idb.getAntall());
			for (ConnectionHandeler teacher:teachers){
				if(teacher!=null){
				teacher.push(t);
				}
			Runtime.getRuntime().gc();
			}
		}
	}
	
	public static void main(String[] args){
		ReaderThread r = new ReaderThread();
		r.run();
	}
}
