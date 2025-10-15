package entidades;

public class Clientes {
    
    private int c_codigo;
    private String c_nome;
    
    public Clientes(int cod, String n) {
        this.c_codigo = cod;
        this.c_nome = n;
    }

    public String toString() {
        return "Código: " + c_codigo +", Nome: " + c_nome;
    }

    public int getC_codigo() {
        return c_codigo;
    }

    public String getNome() {
        return c_nome;
    }
}
