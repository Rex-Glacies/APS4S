package Controller;

import Views.InterfaceViews.InterfaceSelect;
import dao.InterfaceDao;
import entidades.Clientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JPanel;

public class ControllerSelectCliente {
    
    InterfaceSelect<Clientes> view;
    InterfaceDao model;

    public ControllerSelectCliente(InterfaceDao m, InterfaceSelect<Clientes> v) {
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
  
        	String key = view.getBusca();
            List<Clientes> client = model.getClientes(key);
            view.mostrarTodos(client);

        }

    }

    class AcaoTodos implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            List<Clientes> tclien = model.getAllClientes();
            view.mostrarTodos(tclien);
        }

    }

    
}
