package backend;

public class StudentInfo{
    byte rank;
    byte oldRank;
    String fag;
    int ID;

    public StudentInfo(String fag, byte rank, byte oldRank){
        this.fag = fag;
        this.rank = rank;
        this.oldRank = oldRank;
        this.ID=0;
    }

    public byte getRank() {
        return rank;
    }

    public String getFag() {
        return fag;
    }

    public void setRank(byte rank) {
        this.oldRank=this.rank;
        this.rank = rank;
    }

    public void setFag(String fag) {
        this.fag = fag;
    }

    public byte getOldRank() {
        return oldRank;
    }

    public int getID(){return ID;}

    public void setID(int ID){
        this.ID=ID;
    }
}