package doa;

import entidades.Clientes;
import entidades.Funcionarios;
import entidades.Pedidos;
import entidades.Produtos;
import java.util.List;

public interface  InterfaceDoa {

    //Clientes
    public void addCliente(Clientes c);
    public List<Clientes> getAllClientes();
    public List<Clientes> getClientes(String key);
    public void deletCliente(int cod);

    //Funcionarios
    public void addFuncionario(Funcionarios f);
    public List<Funcionarios> getAllFuncionarios();
    public List<Funcionarios> getFuncionario(String key);
    public void deletFuncionario(int cod);

    //Produtos
    public void addProduto(Produtos p);
    public List<Produtos> getAllProdutos();
    public List<Produtos> getProduto(String key);
    public void deletProduto(String cod);

    //Pedidos
    public void addPedido(Pedidos ped);
    public List<Pedidos> getAllPedidos();
    public List<Pedidos> getPedido(int key);
    public void deletPedido(int cod);
}
