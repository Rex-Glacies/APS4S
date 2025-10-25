package Controller;

import Views.InterfaceViews.InterfaceCadProduto;
import dao.InterfaceDao;
import entidades.Produtos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ControllerCadProduto {
    
    InterfaceCadProduto view;
    InterfaceDao model;

    public ControllerCadProduto(InterfaceDao m, InterfaceCadProduto v) {
        this.model = m;
        this.view = v;

        view.AddEnviarProduto(new cadProd());
    }

    public JPanel getView() {
        return (JPanel) view;
    }

    class cadProd implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String codProd = view.GetCodProd();
                String nomeProd = view.GetNomeProd();
                double valorProd = view.GetValorProd();
                int estoque = view.GetEstoqueProd();

                if (!model.getProduto(codProd).isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Já existe um produto com esse codigo","Erro",JOptionPane.ERROR_MESSAGE );    
                } else {
                    model.addProduto(new Produtos(codProd, nomeProd, valorProd, estoque));
                    JOptionPane.showMessageDialog(null,"Produto cadastrado com sucesso!","Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Campos invalido ou vazios!","Erro",JOptionPane.ERROR_MESSAGE );
            }
        }
        
    }

    
}
