package entidades;

public class Pedidos {
    
    private int num_pedido;
    private String cod_prod;
    private int cod_fun;
    private int cod_clien;
    private int quantidade_prod;
    
    public Pedidos(int np, String cprod, int cf, int cclient, int qntd) {
        this.num_pedido = np;
        this.cod_prod = cprod;
        this.cod_fun = cf;
        this.cod_clien = cclient;
        this.quantidade_prod = qntd;
    }

    public String toString() {
        return "Num.Pedido: " + num_pedido + ", Cod.Produto: " 
        + cod_prod + ", Cod.Funcionario: " + cod_fun + ", Cod.Cliente: " + cod_clien + ", Quantidade: " + quantidade_prod;
    }

    public int getNum_pedido() {
        return num_pedido;
    }

    public String getCod_prod() {
        return cod_prod;
    }

    public int getCod_fun() {
        return cod_fun;
    }

    public int getCod_clien() {
        return cod_clien;
    }

    public int getQuantidade_prod() {
        return quantidade_prod;
    }

}
