package entidades;

public class Funcionarios {

    private int fun_codigo;
    private String fun_nome;

    public Funcionarios(int cod, String n){
        this.fun_codigo = cod;
        this.fun_nome = n;
    }

    public String toString() {
        return "Código: " + fun_codigo +", Nome: " + fun_nome;
    }

    public int getCodigo() {
        return fun_codigo;
    }

    public String getNome() {
        return fun_nome;
    }
}
