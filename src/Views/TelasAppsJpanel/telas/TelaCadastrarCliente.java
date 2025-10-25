package Views.TelasAppsJpanel.telas;

import java.awt.*;
import javax.swing.*;

public class TelaCadastrarCliente extends JPanel {
	
	private JTextField campoNome;
	private JButton btnEnviar;
	
    public TelaCadastrarCliente() {
        setLayout(new BorderLayout());
        add(new JLabel("Tela Cadastrar Cliente", SwingConstants.CENTER), BorderLayout.CENTER);
        
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100));
        formPanel.setBackground(Color.WHITE);

        campoNome = new JTextField();

        formPanel.add(new JLabel("Nome do Cliente:"));
        formPanel.add(campoNome);

        add(formPanel, BorderLayout.CENTER);

        // Botões
        JPanel botoes = new JPanel();
        botoes.setBackground(Color.WHITE);
        btnEnviar = new JButton("Enviar Cadastro");
        JButton btnLimpar = new JButton("Limpar");
        botoes.add(btnEnviar);
        botoes.add(btnLimpar);

        add(botoes, BorderLayout.SOUTH);

        
        btnLimpar.addActionListener(e -> limparCampos());
    }
    
    public void limparCampos() {
        campoNome.setText("");
    }
}
