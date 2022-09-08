package Assessment_First;

public class Cloths {
       public String Cloth_Name;
       public int S,M,L,XL;

    public Cloths(String Cloth_Name, int  S, int M, int L, int XL) {
        this.Cloth_Name = Cloth_Name;
        this.S =  S;
        this.M = M;
        this.L = L;
        this.XL = XL;
    }
    public String toString() {
        return Cloth_Name+" "+S+" "+M+" "+L+" "+XL+" ";
    }
    public String hasCode() {
        return Cloth_Name+" "+S+" "+M+" "+L+" "+XL+" ";
    }
}
