package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JPanel;

import Views.InterfaceViews.InterfaceSelect;
import dao.InterfaceDao;
import entidades.Pedidos;

public class ControllerSelectPedido {
	
	InterfaceSelect<Pedidos> view;
	InterfaceDao model;
	
	public ControllerSelectPedido(InterfaceDao m, InterfaceSelect<Pedidos> v) {
		this.model = m;
		this.view = v;
		
		view.addListenerBusca(new AcaoBusca());
		view.addListarTodos(new AcaoTodos());
	}
	
    public JPanel getView() {
        return (JPanel) view;
    }
	
	class AcaoBusca implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int key = Integer.parseInt(view.getBusca());
			List<Pedidos> pedido = model.getPedido(key);
			view.mostrarTodos(pedido);
			
		}
		
	}
	
	public class AcaoTodos implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			List<Pedidos> tpedidos = model.getAllPedidos();
			view.mostrarTodos(tpedidos);
			
		}
		
	}
	
}
