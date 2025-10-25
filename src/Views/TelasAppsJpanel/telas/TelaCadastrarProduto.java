
package Views.TelasAppsJpanel.telas;

import Views.InterfaceViews.InterfaceCadProduto;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TelaCadastrarProduto extends JPanel implements InterfaceCadProduto {
    private JTextField campoNome, campoPreco, campoEstoque, campoCod;
    private JButton btnEnviar;
    private JButton btnLimpar;

    public TelaCadastrarProduto() {
        setLayout(new BorderLayout(10, 10));
        setBackground(Color.WHITE);

        JLabel titulo = new JLabel("Cadastrar Novo Produto", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(titulo, BorderLayout.NORTH);

        // Painel de formulário
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100));
        formPanel.setBackground(Color.WHITE);

        campoCod = new JTextField();
        campoNome = new JTextField();
        campoPreco = new JTextField();
        campoEstoque = new JTextField();

        formPanel.add(new JLabel("Codigo do Produto:"));
        formPanel.add(campoCod);

        formPanel.add(new JLabel("Nome do Produto:"));
        formPanel.add(campoNome);

        formPanel.add(new JLabel("Preço do Produto:"));
        formPanel.add(campoPreco);

        formPanel.add(new JLabel("Estoque:"));
        formPanel.add(campoEstoque);


        add(formPanel, BorderLayout.CENTER);

        // Botões
        JPanel botoes = new JPanel();
        botoes.setBackground(Color.WHITE);
        btnEnviar = new JButton("Cadastrar Produto");
        btnLimpar = new JButton("Limpar");
        botoes.add(btnEnviar);
        botoes.add(btnLimpar);

        add(botoes, BorderLayout.SOUTH);

        
        btnLimpar.addActionListener(e -> limparCampos());
    }

    
    @Override
    public String GetCodProd() {
        return campoCod.getText();
    }

    @Override
    public String GetNomeProd() {
        return campoNome.getText();
    }

    @Override
    public double GetValorProd() {
        return Double.parseDouble(campoPreco.getText());
    }

    @Override
    public int GetEstoqueProd() {
        return Integer.parseInt(campoEstoque.getText());
    }

    @Override
    public void AddEnviarProduto(ActionListener al) {
        btnEnviar.addActionListener(al);
    }

    public void limparCampos() {
        campoCod.setText("");
        campoNome.setText("");
        campoPreco.setText("");
        campoEstoque.setText("");
    }

}
