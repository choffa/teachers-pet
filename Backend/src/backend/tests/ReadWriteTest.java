package backend.tests;

import backend.StudentInfo;
import backend.database.InputDatabase;
import backend.threadsnshit.ReaderThread;
import backend.threadsnshit.WriterThread;

public class ReadWriteTest {
	static StudentInfo s;
	public volatile static InputDatabase  db;
	public static void main(String[] args) {
		db = new InputDatabase();
		WriterThread wt = new WriterThread();
		ReaderThread rt = new ReaderThread();
		wt.init(db);
		rt.init(db);
		new Thread(rt).start();
		new Thread(wt).start();
		while(true){
			try{
			Thread.sleep((long) (Math.random()*200));
			//s = new StudentInfo("ikkerelevant", (byte) Math.floor(Math.random()*6), (byte) 0);
			wt.addInfo(new StudentInfo("ikkerelevant", (byte) Math.floor(Math.random()*6), (byte) (Math.round(Math.random())*Math.floor(Math.random()*6))));
			//System.out.println("test kjører");
			}catch(Exception e){e.printStackTrace();}
		}
	}

}
