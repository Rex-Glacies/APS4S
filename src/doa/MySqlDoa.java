package doa;

import entidades.Clientes;
import entidades.Funcionarios;
import entidades.Pedidos;
import entidades.Produtos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class MySqlDoa implements InterfaceDoa {

    final static private String USER = "root";
    final static private String PASS = "";
    final static private String DATABASE = "aps4";
    final static private String URL = "jdbc:mysql://localhost:3306/" + DATABASE;


    //Parte do Cliente
    @Override
    public void addCliente(Clientes cl) {
        final String query = "INSERT INTO cliente(Cod,Nome) VALUES (?,?);";

        try (Connection c = DriverManager.getConnection(URL, USER, PASS)) {

            PreparedStatement pstm = c.prepareStatement(query);

            pstm.setInt(1, cl.getC_codigo());
            pstm.setString(2, cl.getNome());

            pstm.executeUpdate();

            System.out.println("Cliente adicionado com sucesso!");


        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public List<Clientes> getAllClientes() {
        List<Clientes> clientes = new ArrayList<>();
        final String query = "SELECT * FROM cliente";

        try (Connection c = DriverManager.getConnection(URL, USER, PASS)) {

            Statement smt = c.createStatement();
            ResultSet rs = smt.executeQuery(query);

            while (rs.next()) {
                int cod = rs.getInt("Cod");
                String nome = rs.getString("Nome");
                Clientes cliente = new Clientes(cod, nome);
                clientes.add(cliente);
            }

            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return clientes;
    }

    @Override
    public List<Clientes> getClientes(String key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deletCliente(int cod) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    //Parte do Funcionario
    @Override
    public void addFuncionario(Funcionarios f) {
        final String query = "INSERT INTO funcionario(Cod,Nome) VALUES (?,?);";

        try (Connection c = DriverManager.getConnection(URL, USER,PASS)){
            
            PreparedStatement psmt = c.prepareStatement(query);

            psmt.setInt(1, f.getCodigo());
            psmt.setString(2, f.toString());

            psmt.executeUpdate();

            System.out.println("Funcionario adicionado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Funcionarios> getAllFuncionarios() {
        List<Funcionarios> funcionarios = new ArrayList<>();

        final String query = "SELECT * FROM funcionario";

        try (Connection c = DriverManager.getConnection(URL, USER, PASS)) {

            Statement smt = c.createStatement();
            ResultSet rs = smt.executeQuery(query);

            while (rs.next()) {
                int cod = rs.getInt("Cod");
                String nome = rs.getString("Nome");
                Funcionarios funcionario = new Funcionarios(cod, nome);
                funcionarios.add(funcionario);
            }

            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return funcionarios;
    }

    @Override
    public List<Funcionarios> getFuncionario(String key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deletFuncionario(int cod) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    //Parte do produto
    @Override
    public void addProduto(Produtos p) {
        final String query = "INSERT INTO produto(Cod,Nome,Preco,Estoque) VALUES (?,?,?,?);";

        try (Connection c = DriverManager.getConnection(URL, USER,PASS)){
            
            PreparedStatement psmt = c.prepareStatement(query);

            psmt.setString(1, p.getP_codigo());
            psmt.setString(2, p.getP_nome());
            psmt.setDouble(3, p.getP_preco());
            psmt.setInt(4, p.getP_estoque());

            psmt.executeUpdate();

            System.out.println("Produto adicionado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Produtos> getAllProdutos() {
        List<Produtos> produtos = new ArrayList<>();

        final String query = "SELECT * FROM produto";

        try (Connection c = DriverManager.getConnection(URL, USER, PASS)) {

            Statement smt = c.createStatement();
            ResultSet rs = smt.executeQuery(query);

            while (rs.next()) {
                String cod = rs.getString("Cod");
                String nome = rs.getString("Nome");
                double preco = rs.getDouble("Preco");
                int estoque = rs.getInt("Estoque");
                Produtos produto = new Produtos(cod, nome, preco, estoque);
                produtos.add(produto);
            }

            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return produtos;
    }

    @Override
    public List<Produtos> getProduto(String key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deletProduto(String cod) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    //Parte do pedido
    @Override
    public void addPedido(Pedidos ped) {
        final String query = "INSERT INTO pedido(N_Pedido,Cod_Prod_FK,Cod_Fun_FK,Cod_Clien_FK,Qtd_Prod) VALUES (?,?,?,?,?);";

        try (Connection c = DriverManager.getConnection(URL, USER,PASS)){
            
            PreparedStatement psmt = c.prepareStatement(query);

            psmt.setInt(1, ped.getNum_pedido());
            psmt.setString(2, ped.getCod_prod());
            psmt.setInt(3, ped.getCod_fun());
            psmt.setInt(4, ped.getCod_clien());
            psmt.setInt(5, ped.getQuantidade_prod());

            psmt.executeUpdate();

            System.out.println(" Pedido adicionado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Pedidos> getAllPedidos() {
        List<Pedidos> pedidos = new ArrayList<>();

        final String query = "SELECT * FROM pedido";

        try (Connection c = DriverManager.getConnection(URL, USER, PASS)) {

            Statement smt = c.createStatement();
            ResultSet rs = smt.executeQuery(query);

            while (rs.next()) {
                int n_pedido = rs.getInt("N_Pedido");
                String cod_prod = rs.getString("Cod_Prod_FK");
                int cod_fun = rs.getInt("Cod_Fun_FK");
                int cod_clien = rs.getInt("Cod_Clien_FK");
                int qntd_prod = rs.getInt("Qtd_Prod");
                Pedidos pedido = new Pedidos(n_pedido, cod_prod, cod_fun, cod_clien, qntd_prod);
                pedidos.add(pedido);
            }

            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pedidos;

    }

    @Override
    public List<Pedidos> getPedido(int key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deletPedido(int cod) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    


}
