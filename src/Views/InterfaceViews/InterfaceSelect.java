package Views.InterfaceViews;

import java.awt.event.ActionListener;
import java.util.List;

public interface InterfaceSelect<T> {
	
	//Get usuario
	public String getBusca();
	
	//Mostrar para usuario
	public void mostrarTodos(List<T> lista);

	//lister das acoes
	public void addListenerBusca(ActionListener al);
	public void addListarTodos(ActionListener al);
	
	
}
