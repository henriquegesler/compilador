import java.io.*;
import java.util.*;
import java.lang.Math;

public class Lexer {
    public static int line = 1; //contador de linhas
    private char ch = ' '; //caractere lido do arquivo
    private FileReader file;
    private HashMap<String, Word> words = new HashMap<>();
    private boolean comment = false, bigComment = false;
    
    /* Método para inserir palavras reservadas na HashTable */
    private void reserve(Word w){
        words.put(w.getLexeme(), w); // lexema é a chave para entrada na HashTable
    }
    
    /* Método construtor */
    public Lexer(String fileName) throws FileNotFoundException{
        try{
        file = new FileReader (fileName);
        }
        catch(FileNotFoundException e){
        System.out.println("Arquivo não encontrado");
        throw e;
        }
        //Insere palavras reservadas na HashTable
        reserve(new Word ("start", Tag.START));
        reserve(new Word ("exit", Tag.EXIT));
        reserve(new Word ("int", Tag.INT));
        reserve(new Word ("float", Tag.FLOAT));
        reserve(new Word ("string", Tag.STRING));
        reserve(new Word ("if", Tag.IF));
        reserve(new Word ("then", Tag.THEN));
        reserve(new Word ("else", Tag.ELSE));
        reserve(new Word ("do", Tag.DO));
        reserve(new Word ("while", Tag.WHILE));
        reserve(new Word ("end", Tag.END));
        reserve(new Word ("scan", Tag.SCAN));
        reserve(new Word ("print", Tag.PRINT));
        reserve(new Word ("{", Tag.OPEN));
        reserve(new Word ("}", Tag.CLOSE));
        }
    /*Lê o próximo caractere do arquivo*/
    private void readch() throws IOException{
        ch = (char) file.read();
    }
    
    /* Lê o próximo caractere do arquivo e verifica se é igual a c*/
    private boolean readch(char c) throws IOException{
        readch();
        if (ch != c) return false;
        ch = ' ';
        return true;
    }
   
    public Token scan() throws IOException{
        //Desconsidera delimitadores na entrada
        for (;; readch()) {
            if (ch == ' ' || ch == '\t' || ch == '\r' || ch == '\b') continue;
            else if (ch == '\n'){
                line++; //conta linhas
                comment = false;
            }
            else break;
        }
        if((bigComment && ch == '*')|| ch==65535){
            readch();
            if(ch == '/'){
                bigComment = false;
            }
            if(ch == 65535){
                return new Token(ch);
            }
        }
        if(!comment && !bigComment){
            //Operadores
            if(ch == '!'){
                readch();
                return Word.not;
            }
            else if(ch == '='){
                if (readch('=')) return Word.eq;
                else return new Token('=');
            }
            else if(ch == '>'){
                if (readch('=')) return Word.ge;
                else return Word.greater;
            }
            else if(ch == '<'){
                if (readch('=')) return Word.le;
                else return Word.lesser;
            }
            else if(ch == '+'){
                readch();
                return Word.add;
            }
            else if(ch == '-'){
                readch();
                return Word.minus;
            }
            else if(ch == '|'){
                if (readch('|')) return Word.or;
                else return new Token('|');
            }
            else if(ch == '*'){
                readch();
                return Word.mult;
            }
            else if(ch == '/'){
                if (readch('/')){
                    comment = true;
                }
                else if(ch=='*'){
                    bigComment = true;
                }
                else{
                    return Word.div;
                }
            }
            else if(ch == '&'){
                if (readch('&')) return Word.and;
                else return new Token('&');
            }

            //Números
            if (Character.isDigit(ch)){
                int value=0;
                do{
                    value = 10*value + Character.digit(ch,10);
                    readch();
                }while(Character.isDigit(ch));
                if(ch=='.'){
                    readch();
                    float v=value;
                    double c=1;
                    do{
                        double number = Character.digit(ch,10);
                        number = number/Math.pow(10.0, c);
                        v = (float) (v + number);
                        c = c+1;
                        readch();
                    }while(Character.isDigit(ch));
                    return new Float(v);
                }
                else{
                    return new Int(value);
                }
            }
            //Identificadores
            if (Character.isLetter(ch) || ch=='_'){
                StringBuffer sb = new StringBuffer();
                do{
                    sb.append(ch);
                    readch();
                }while(Character.isLetterOrDigit(ch));
                String s = sb.toString();
                if (words.containsKey(s)) return words.get(s); //palavra já existe na HashTable
                Word w = new Word (s, Tag.ID);
                words.put(s, w);
                return w;
            }
            //Caracteres não especificados
            Token t = new Token(ch);
            ch = ' ';
            return t;
        }
        else{
            readch();
            return new Token(285);
        } 
    }
}
   