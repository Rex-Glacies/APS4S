package Controller;

import Views.InterfaceViews.InterfaceSelect;
import dao.InterfaceDao;
import entidades.Produtos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JPanel;

public class ControllerSelectProduto {
    
    InterfaceSelect<Produtos> view;
    InterfaceDao model;

    public ControllerSelectProduto(InterfaceDao m, InterfaceSelect<Produtos> v) {
        this.model =m;
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
            List<Produtos> prod = model.getProduto(key);
            view.mostrarTodos(prod);
        }

    }

    class AcaoTodos implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            List<Produtos> tprod = model.getAllProdutos();
            view.mostrarTodos(tprod);
        }

    }



}
