package Controller;

import Views.InterfaceViews.InterfaceDeletarPedido;
import dao.InterfaceDao;
import entidades.Pedidos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ControllerDeletPedido {
    

    InterfaceDeletarPedido view;
    InterfaceDao model;

    int cod =0;

    public ControllerDeletPedido(InterfaceDao m, InterfaceDeletarPedido v) {
        this.model = m;
        this.view = v;

        view.AddBuscapedido(new AcaoBusca());
        view.addDeletar(new AcaoDeletar());
    }

    public JPanel getView() {
        return (JPanel) view;
    }

    class AcaoBusca implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int numped = view.getNumPedido();
                if (model.getPedido(numped).isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Não existe um pedido com esse codigo","Erro",JOptionPane.ERROR_MESSAGE );
                } else {
                    List<Pedidos> pedido = model.getPedido(numped);
                    view.mostrarTodos(pedido);
                    cod = numped;
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Campos de busca vazio!","Erro",JOptionPane.ERROR_MESSAGE );
            }
        }

    }

    class AcaoDeletar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (cod == 0) {
                JOptionPane.showMessageDialog(null, "Por favor preencha o campo de busca","Erro",JOptionPane.ERROR_MESSAGE );
            } else {
                model.deletPedido(cod);
                JOptionPane.showMessageDialog(null,"Pedido deletado com sucesso!","Sucesso", JOptionPane.INFORMATION_MESSAGE);
                view.LimparTabela();
            }
        }

    }


}
