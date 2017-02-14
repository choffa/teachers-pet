package backend;

public class StudentInfo{
    byte rank;
    byte oldRank;
    String fag;

    public StudentInfo(String fag, byte rank, byte oldRank){
        this.fag = fag;
        this.rank = rank;
        this.oldRank = oldRank;
    }

    public byte getRank() {
        return rank;
    }

    public String getFag() {
        return fag;
    }

    public void setRank(byte rank) {
        this.rank = rank;
    }

    public void setFag(String fag) {
        this.fag = fag;
    }

    public byte getOldRank() {
        return oldRank;
    }

    public void setOldRank(byte oldRank) {
        this.oldRank = oldRank;
    }
}