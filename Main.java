import java.io.FileNotFoundException;
import java.io.IOException;
//import java.util.Enumeration;

public class Main {
    public static void main(String[] args) throws IOException {
        int count=1;
        Lexer lex;
        Env amb;
        Id iden = null;
        Token tok=null;
        try {
            lex = new Lexer("C:\\Users\\Henrique\\Documents\\Faculdade\\0-ERE - 7o - Compiladores\\trabalho\\lexico\\teste1.txt");
            amb = new Env(null); // Criando tabela de variaveis do ambiente
            while (tok == null || tok.tag!=65535){ //Verificando se foi lido 'vazio' para finalizar o programa    
                tok = lex.scan(); //Pega novo token
                //if(tok.tag<=255){

                //}
//                else{
                    switch(tok.tag){
                        case 256:
                            iden = new Id("", "Comeca");
                            //amb.put(tok, iden);
                            break;
                        case 257:
                            iden = new Id("", "Termina");
                            //amb.put(tok, iden);
                            break;
                        case 258:
                            iden = new Id("", "int");
                            //amb.put(tok, iden);
                            break;
                        case 259:
                            iden = new Id("", "float");
                            //amb.put(tok, iden);
                            break;
                        case 260:
                            iden = new Id("", "string");
                            //amb.put(tok, iden);
                            break;
                        case 261:
                            iden = new Id("", "if");
                            //amb.put(tok, iden);
                            break;
                        case 262:
                            iden = new Id("", "then");
                            //amb.put(tok, iden);
                            break;
                        case 263:
                            iden = new Id("", "else");
                            //amb.put(tok, iden);
                            break;
                        case 264:
                            iden = new Id("", "do");
                            //amb.put(tok, iden);
                            break;
                        case 265:
                            iden = new Id("", "while");
                            //amb.put(tok, iden);
                            break;
                        case 266:
                            iden = new Id("", "end");
                            //amb.put(tok, iden);
                            break;
                        case 267:
                            iden = new Id("", "scan");
                            //amb.put(tok, iden);
                            break;
                        case 268:
                            iden = new Id("", "print");
                            //amb.put(tok, iden);
                            break;
                        case 269:
                            iden = new Id("", "not");
                            //amb.put(tok, iden);
                            break;
                        case 270:
                            iden = new Id("", "igual");
                            //amb.put(tok, iden);
                            break;
                        case 271:
                            iden = new Id("", "maior");
                            //amb.put(tok, iden);
                            break;
                        case 272:
                            iden = new Id("", "maior=");
                            //amb.put(tok, iden);
                            break;
                        case 273:
                            iden = new Id("", "menor");
                            //amb.put(tok, iden);
                            break;
                        case 274:
                            iden = new Id("", "menor=");
                            //amb.put(tok, iden);
                            break;
                        case 275:
                            iden = new Id("", "soma");
                            //amb.put(tok, iden);
                            break;
                        case 276:
                            iden = new Id("", "diferenca");
                            //amb.put(tok, iden);
                            break;
                        case 277:
                            iden = new Id("", "ou");
                            //amb.put(tok, iden);
                            break;
                        case 278:
                            iden = new Id("", "multiplicacao");
                            //amb.put(tok, iden);
                            break;
                        case 279:
                            iden = new Id("", "divisao");
                            //amb.put(tok, iden);
                            break;
                        case 280:
                            iden = new Id("", "and");
                            //amb.put(tok, iden);
                            break;
                        case 286:
                            iden = new Id("", "identificador");
                            if(amb.get(tok) == null){
                                iden.setContador(count);
                                amb.put(tok, iden);
                                count++;
                            }
                            break;
                        case 287:
                            iden = new Id("", "aberto");
                            amb.put(tok, iden);
                            break;
                        case 288:
                            iden = new Id("", "fechado");
                            amb.put(tok, iden);
                            break;
    //                }
                }         
            }
            amb.exibirTS();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}