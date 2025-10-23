package Views.TelasAppsJpanel.telas;

import Views.InterfaceViews.InterfaceCadPedidos;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class TelaSolicitarPedido extends JPanel implements InterfaceCadPedidos {
    private JTextField campoCliente, campoProduto, campoQuantidade, campoFuncionario;
    private ArrayList<String> pedidos;
    private JButton btnEnviar;
    private JButton btnLimpar;

    public TelaSolicitarPedido() {
        setLayout(new BorderLayout(10, 10));
        setBackground(Color.WHITE);
        pedidos = new ArrayList<>();

        JLabel titulo = new JLabel("Solicitar Novo Pedido", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(titulo, BorderLayout.NORTH);

        // Painel de formulário
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100));
        formPanel.setBackground(Color.WHITE);

        campoCliente = new JTextField();
        campoProduto = new JTextField();
        campoQuantidade = new JTextField();
        campoFuncionario = new JTextField();

        formPanel.add(new JLabel("Codigo do Produto:"));
        formPanel.add(campoProduto);

        formPanel.add(new JLabel("Codido do Funcionario:"));
        formPanel.add(campoFuncionario);

        formPanel.add(new JLabel("Codigo do Cliente:"));
        formPanel.add(campoCliente);

        formPanel.add(new JLabel("Quantidade:"));
        formPanel.add(campoQuantidade);

        add(formPanel, BorderLayout.CENTER);

        // Botões
        JPanel botoes = new JPanel();
        botoes.setBackground(Color.WHITE);
        btnEnviar = new JButton("Enviar Pedido");
        JButton btnLimpar = new JButton("Limpar");
        botoes.add(btnEnviar);
        botoes.add(btnLimpar);

        add(botoes, BorderLayout.SOUTH);

        
        btnLimpar.addActionListener(e -> limparCampos());
    }


    @Override
    public int codCliente() {
        return Integer.parseInt(campoCliente.getText());
    }

    @Override
    public int codFunc() {
        return Integer.parseInt(campoFuncionario.getText());
    }

    @Override
    public String codProd() {
        return campoProduto.getText();
    }

    @Override
    public int quant() {
        return Integer.parseInt(campoQuantidade.getText());
    }

    
    @Override
    public void AddenviarPedido(ActionListener ln) {
        btnEnviar.addActionListener(ln);  
        limparCampos();
    }



    /* 
    private void enviarPedido() {
        String cliente = campoCliente.getText().trim();
        String produto = campoProduto.getText().trim();
        String quantidade = campoQuantidade.getText().trim();
        String observacao = areaObservacao.getText().trim();

        if (cliente.isEmpty() || produto.isEmpty() || quantidade.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String pedido = String.format("Cliente: %s | Produto: %s | Qtd: %s | Obs: %s", cliente, produto, quantidade, observacao);
        pedidos.add(pedido);

        JOptionPane.showMessageDialog(this, "Pedido solicitado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        limparCampos();
    }
    */

    private void limparCampos() {
        campoCliente.setText("");
        campoProduto.setText("");
        campoQuantidade.setText("");
        campoFuncionario.setText("");
    }
}
