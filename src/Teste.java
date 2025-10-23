
import dao.InterfaceDao;
import dao.MySqlDao;
import entidades.Produtos;

public class Teste {
    public static void main(String[] args) {
        InterfaceDao dao = new MySqlDao();

        dao.addCliente("Teste1");
        dao.addFuncionario("Jonas");
        dao.addProduto(new Produtos("1a34d", "Ervilha", 1.00, 100));
    }
}
