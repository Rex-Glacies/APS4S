package entidades;

public class Produtos {
    
    private String p_codigo;
    private String p_nome;
    private double p_preco;
    private int p_estoque;
    
    public Produtos(String cod, String n, double p, int e){
        this.p_codigo = cod;
        this.p_nome = n;
        this.p_preco = p;
        this.p_estoque = e;
    }

    public String toString() {
        return "Código: " + p_codigo + ", Nome: " + p_nome + ", Preço: " + p_preco + ", Valor: " + p_estoque;
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

    public int getP_estoque() {
        return p_estoque;
    }
}
