package Views.InterfaceViews;

import entidades.Pedidos;
import java.awt.event.ActionListener;
import java.util.List;

import Controller.ControllerSelectPedido.AcaoTodos;

public interface InterfaceDeletarPedido {
    //Get usuario
    public int getNumPedido();

    //Mostra usuario
    public void mostrarTodos(List<Pedidos> lista);
	public void preencherTabela(List<Pedidos> a);

    
    public void AddBuscapedido(ActionListener ax);
    public void addDeletar(ActionListener al);
    public void addListarTodos(ActionListener al);
    public void LimparTabela();

}
