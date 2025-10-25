package Views.InterfaceViews;

import java.util.List;

import entidades.Produtos;
import java.awt.event.ActionListener;

public interface InterfaceSelectProduto {
    //Get usuario
	public String getBusca();
	
	//Mostrar para usuario
	public void mostrarTodos(List<Produtos> lista);
	public void preencherTabela(List<Produtos> a);
	
	//lister das acoes
	public void addListenerBusca(ActionListener al);
	public void addListarTodos(ActionListener al);
    public void addFiltrarOrdemASC(ActionListener al);
}
