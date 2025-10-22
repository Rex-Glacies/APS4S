
import dao.InterfaceDao;
import dao.MySqlDao;

public class Teste {
    public static void main(String[] args) {
        InterfaceDao dao = new MySqlDao();




        System.out.println(dao.getAllClientes());
    }
}
