public class Word extends Token{
    private String lexeme = ""; 
    public static final Word not = new Word ("!", Tag.NOT);
    public static final Word eq = new Word ("==", Tag.EQ);
    public static final Word greater = new Word (">", Tag.GREATER);
    public static final Word ge = new Word (">=", Tag.GE);
    public static final Word lesser = new Word ("<", Tag.LESSER);
    public static final Word le = new Word ("<=", Tag.LE);
    public static final Word add = new Word ("+", Tag.ADD);
    public static final Word minus = new Word ("-", Tag.MINUS);
    public static final Word or = new Word ("||", Tag.OR);
    public static final Word mult = new Word ("*", Tag.MULT);
    public static final Word div = new Word ("/", Tag.DIV);
    public static final Word and = new Word ("&&", Tag.AND);
    
    public Word (String s, int tag){
        super (tag);
        lexeme = s;
    }
    
    public String toString(){
        return "" + lexeme;
    }

    
    public String getLexeme(){
        return lexeme;
    }
}

