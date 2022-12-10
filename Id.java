public class Id implements Comparable<Id>{
    String tipo, valorString;
    int contador;
    

    public Id(String tipo){
        this.tipo = tipo;
        contador = 0;
    }

    public Id(String tipo, String val){
        this.tipo = tipo;
        this.valorString = val;
        contador = 0;
        if (this.tipo.matches("int")){
            int valor = Integer.parseInt(val);
            //System.out.println(valor);
        }
        else{
            String valor = val;
            //System.out.println(valor);
        }
    }

    public String getTipo(){
        return tipo;
    }
    
    public String getValor(){
        return valorString;
    }

    public int getContador(){
        return contador;
    }

    public void setContador(int count){
        this.contador = count;
    }

    @Override
    public int compareTo(Id o) {
        // TODO Auto-generated method stub
        return 0;
    }
}