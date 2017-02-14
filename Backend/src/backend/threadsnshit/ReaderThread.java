package backend.threadsnshit;

import backend.database.InputDatabase;


public class ReaderThread implements Runnable{

	InputDatabase idb;
	
	public void init(InputDatabase db){
		idb = db;
	}
	
	@Override
	public void run() {
		while(true){
			System.out.println("Current mean: "+idb.getGjennomsnitt());
			System.out.println("Current number of people: "+idb.getAntall());
			try{
				Thread.sleep(10000);
			} catch(Exception e){}
			Runtime.getRuntime().gc();
		}
	}
}
