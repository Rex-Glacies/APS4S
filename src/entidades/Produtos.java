package entidades;

public class Produtos {
    
    private String p_codigo;
    private String p_nome;
    private double p_preco;
    private int p_valor;
    
    public Produtos(String cod, String n, double p, int v){
        this.p_codigo = cod;
        this.p_nome = n;
        this.p_preco = p;
        this.p_valor = v;
    }

    public String toString() {
        return "Código: " + p_codigo + ", Nome: " + p_nome + ", Preço: " + p_preco + ", Valor: " + p_valor;
    }

    public String getP_codigo() {
        return p_codigo;
    }

    public String getP_nome() {
        return p_nome;
    }

    public double getP_preco() {
        return p_preco;
    }

    public int getP_valor() {
        return p_valor;
    }
}
