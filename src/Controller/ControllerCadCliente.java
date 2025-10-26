package Controller;

import Views.InterfaceViews.InterfaceCadFuncEClient;
import dao.InterfaceDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ControllerCadCliente {
    
    InterfaceCadFuncEClient view;
    InterfaceDao model;

    public ControllerCadCliente(InterfaceDao m, InterfaceCadFuncEClient v) {
        this.model = m;
        this.view = v;

        view.addCadastro(new AcaoCadCliente());
    }

    public JPanel getView() {
        return (JPanel) view;
    }

    class AcaoCadCliente implements  ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String nomeCliente = view.getNome();
            if (nomeCliente == null || nomeCliente.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campos vazios!","Erro",JOptionPane.ERROR_MESSAGE );
            } else {
                model.addCliente(nomeCliente.trim());
                JOptionPane.showMessageDialog(null,"Cliente cadastrado com sucesso!","Sucesso", JOptionPane.INFORMATION_MESSAGE);
                view.limparCampos();
            }
        }
        
    }


}
