package dao;

import entidades.Clientes;
import entidades.Funcionarios;
import entidades.Pedidos;
import entidades.Produtos;
import java.util.List;

public interface  InterfaceDao {

    //Clientes
    public void addCliente(String cl);
    public List<Clientes> getAllClientes();
    public List<Clientes> getClientes(String key);


    //Funcionarios
    public void addFuncionario(String f);
    public List<Funcionarios> getAllFuncionarios();
    public List<Funcionarios> getFuncionario(String key);
   

    //Produtos
    public void addProduto(Produtos p);
    public List<Produtos> getAllProdutos();
    public List<Produtos> getProduto(String key);
    public List<Produtos> getOrdenadosProduto();
    

    //Pedidos
    public void addPedido(String codProd, int codFun, int codClient, int quant);
    public List<Pedidos> getAllPedidos();
    public List<Pedidos> getPedido(int key);
    public void deletPedido(int cod);
}
