package Views.TelasAppsJpanel.telas;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class TelaSolicitarPedido extends JPanel {
    private JTextField campoCliente, campoProduto, campoQuantidade;
    private JTextArea areaObservacao;
    private ArrayList<String> pedidos;

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
        areaObservacao = new JTextArea(3, 20);
        JScrollPane scrollObs = new JScrollPane(areaObservacao);

        formPanel.add(new JLabel("Nome do Cliente:"));
        formPanel.add(campoCliente);

        formPanel.add(new JLabel("Produto:"));
        formPanel.add(campoProduto);

        formPanel.add(new JLabel("Quantidade:"));
        formPanel.add(campoQuantidade);

        formPanel.add(new JLabel("Observações:"));
        formPanel.add(scrollObs);

        add(formPanel, BorderLayout.CENTER);

        // Botões
        JPanel botoes = new JPanel();
        botoes.setBackground(Color.WHITE);
        JButton btnEnviar = new JButton("Enviar Pedido");
        JButton btnLimpar = new JButton("Limpar");
        botoes.add(btnEnviar);
        botoes.add(btnLimpar);

        add(botoes, BorderLayout.SOUTH);

        // Ações
        btnEnviar.addActionListener(e -> enviarPedido());
        btnLimpar.addActionListener(e -> limparCampos());
    }

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

    private void limparCampos() {
        campoCliente.setText("");
        campoProduto.setText("");
        campoQuantidade.setText("");
        areaObservacao.setText("");
    }
}
