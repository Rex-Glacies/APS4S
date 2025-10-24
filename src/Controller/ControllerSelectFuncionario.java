package Controller;

import Views.InterfaceViews.InterfaceSelect;
import dao.InterfaceDao;
import entidades.Funcionarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JPanel;

public class ControllerSelectFuncionario {
    
    InterfaceSelect<Funcionarios> view;
    InterfaceDao model;

    public ControllerSelectFuncionario(InterfaceDao m, InterfaceSelect<Funcionarios> v) {
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
            List<Funcionarios> func = model.getFuncionario(key);
            view.mostrarTodos(func);
        }

    }

    class AcaoTodos implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            List<Funcionarios> tfunc = model.getAllFuncionarios();
            view.mostrarTodos(tfunc);
        }

    }
}
