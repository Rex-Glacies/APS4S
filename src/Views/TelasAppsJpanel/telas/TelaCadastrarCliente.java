package Views.TelasAppsJpanel.telas;

import Views.InterfaceViews.InterfaceCadFuncEClient;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TelaCadastrarCliente extends JPanel implements InterfaceCadFuncEClient {
    private JTextField campoNome;
    private JButton btnEnviar;
    private JButton btnLimpar;
    public TelaCadastrarCliente() {
        setLayout(new BorderLayout(10, 10));
        setBackground(Color.WHITE);

        JLabel titulo = new JLabel("Cadastrar Novo Cliente", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(titulo, BorderLayout.NORTH);

        // Painel de formulário
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
        btnEnviar = new JButton("Cadastrar Cliente");
        btnLimpar = new JButton("Limpar");
        botoes.add(btnEnviar);
        botoes.add(btnLimpar);

        add(botoes, BorderLayout.SOUTH);

        
        btnLimpar.addActionListener(e -> limparCampos());
    }

    @Override
    public String getNome() {
        return campoNome.getText();
    }

    @Override
    public void addCadastro(ActionListener al) {
        btnEnviar.addActionListener(al);
    }

    public void limparCampos() {
        campoNome.setText("");
    }


}
