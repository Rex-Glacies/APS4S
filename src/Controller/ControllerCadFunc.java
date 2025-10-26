package Controller;

import Views.InterfaceViews.InterfaceCadFuncEClient;
import dao.InterfaceDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ControllerCadFunc {

    InterfaceCadFuncEClient view;
    InterfaceDao model;

    public ControllerCadFunc(InterfaceDao m, InterfaceCadFuncEClient v) {
        this.model = m;
        this.view = v;

        view.addCadastro(new AcaoCadFunc());
    }

    public JPanel getView() {
        return (JPanel) view;
    }

    class AcaoCadFunc implements  ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String nomeFunc = view.getNome();
            if (nomeFunc == null || nomeFunc.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campos vazios!","Erro",JOptionPane.ERROR_MESSAGE );
            } else {
                model.addFuncionario(nomeFunc.trim());
                JOptionPane.showMessageDialog(null,"Funcionario cadastrado com sucesso!","Sucesso", JOptionPane.INFORMATION_MESSAGE);
                view.limparCampos();
            }
            
        }
        
    }

}
