package Assessment_First;

public class Shoes {
     public String ShoesName;
     public int S=0 , M=0 , L=0;
    
     public Shoes(String ShoesName, int S, int M, int L) {
        this.ShoesName = ShoesName;
        this.S = S;
        this.M = M;
        this.L = L;
    }
    public String toString() {
        return ShoesName+" "+S+" "+M+" "+L+" ";
    }
    public String hasCode() {
        return ShoesName+" "+S+" "+M+" "+L+" ";
    }
}

