public class Token implements Comparable<Token>{
    public final int tag; //constante que representa o token
    
    public Token (int t){
        tag = t;
    }
    
    public String toString(){
        return "" + tag;
    }

    @Override
    public int compareTo(Token o) {
        // TODO Auto-generated method stub
        return 0;
    }
}
   