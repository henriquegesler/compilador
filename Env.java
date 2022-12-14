import java.util.*;

public class Env {
    private HashMap<Token, Id> table; //tabela de símbolos do ambiente
    protected Env prev; //ambiente imediatamente superior

    public Env(Env ant){
        table = new HashMap<>(); //cria a TS para o ambiente
        prev = ant; //associa o ambiente atual ao anterior
    }

    /*Este método insere uma entrada na TS do ambiente */
    /*A chave da entrada é o Token devolvido pelo analisador léxico */
    /*Id é uma classe que representa os dados a serem armazenados na TS para */
    /*identificadores */
    public void put(Token w, Id i){
        table.put(w,i);
    }

    public void exibirTS(){
        System.out.println("Tabela de símbolos:");
        TreeMap<Integer, Token> sort = new TreeMap<>();
        for(Token chave : table.keySet()){
            sort.putIfAbsent(table.get(chave).contador, chave);
        }
        System.out.println(sort);
    }

    /*Este método retorna as informações (Id) referentes a determinado Token */
    /*O Token é pesquisado do ambiente atual para os anteriores */
    public Id get(Token w){
        for (Env e = this; e!=null; e = e.prev){
        Id found = (Id) e.table.get(w);
        if (found != null) //se Token existir em uma das TS
        return found;
        }
        return null; //caso Token não exista em uma das TS
    }
}
   