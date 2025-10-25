
import dao.InterfaceDao;
import dao.MySqlDao;
import entidades.Produtos;

public class Teste {
    public static void main(String[] args) {
        InterfaceDao dao = new MySqlDao();

        //dao.addCliente("Teste1");
        //dao.addFuncionario("Jonas");
        //dao.addProduto(new Produtos("1a34d", "Ervilha", 1.00, 100));
        
        dao.addCliente("Teste2");
        dao.addCliente("Teste3");
        dao.addCliente("Teste4");
        dao.addCliente("Teste5");
        dao.addCliente("Teste6");
    }
}
