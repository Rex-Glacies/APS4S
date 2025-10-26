package Controller;

import Views.InterfaceViews.InterfaceCadPedidos;
import dao.InterfaceDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ControllerCriarPedido {
    InterfaceDao model;
    InterfaceCadPedidos view;

    public ControllerCriarPedido (InterfaceDao aModel, InterfaceCadPedidos aView) {
        this.view = aView;
        this.model = aModel;

        view.AddenviarPedido(new AcaoCriarPed());
    }


    public JPanel getView() {
        return (JPanel) view;
    }

    class AcaoCriarPed implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        		
        	try {
                String codProd = view.codProd();
                int codFun = view.codFunc();
                int codClien = view.codCliente();
                int quant = view.quant();
                
                
                if(codProd !="" && codFun > 0 && codClien > 0 && quant > 0 ) {
                	try {
    					model.addPedido(codProd, codFun, codClien, quant);
    					JOptionPane.showMessageDialog(null,"Pedido solicitado com sucesso!","Sucesso", JOptionPane.INFORMATION_MESSAGE);
    		            view.limparCampos();
    				} catch (SQLException e1) {
    					JOptionPane.showMessageDialog(null, "Campos numéricos inválidos ou vazios!","Erro",JOptionPane.ERROR_MESSAGE );
    				}
    					
    			} else {
    				JOptionPane.showMessageDialog(null, "Campos numéricos inválidos ou vazios!","Erro",JOptionPane.ERROR_MESSAGE );
                }
        	} catch (NumberFormatException ex) {
        		JOptionPane.showMessageDialog(null, "Campos numéricos inválidos ou vazios!","Erro",JOptionPane.ERROR_MESSAGE );
        	}
                	


        
            }

        
        }
    }

