package backend;

public class StudentInfo{
    int rank;
    int oldRank;
    String fag;

    public StudentInfo(String fag, int rank, int oldRank){
        this.fag = fag;
        this.rank = rank;
        this.oldRank = oldRank;
    }

    public int getRank() {
        return rank;
    }

    public String getFag() {
        return fag;
    }

    public void setRank(int rank) {
        this.oldRank=this.rank;
        this.rank = rank;
    }

    public void setFag(String fag) {
        this.fag = fag;
    }

    public int getOldRank() {
        return oldRank;
    }
}