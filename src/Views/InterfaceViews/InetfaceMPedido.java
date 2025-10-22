package Views.InterfaceViews;

import java.awt.event.ActionListener;
import java.util.List;

import entidades.Pedidos;
import entidades.Produtos;



public interface InetfaceMPedido {
    
    //Get do Pedido
    public int getCodPedido();

    //Mostrar usuario
    public void MostrarTodosProdutos(List<Produtos> produtos);
    public void MostrarPedidos(Pedidos p);

    //// configura o listener das acoes
    public void addlistenerAtualizar(ActionListener e);
}
