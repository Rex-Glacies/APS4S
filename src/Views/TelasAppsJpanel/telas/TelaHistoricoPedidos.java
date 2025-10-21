package Views.TelasAppsJpanel.telas;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TelaHistoricoPedidos extends JPanel {
    private JTable tabela;
    private DefaultTableModel modelo;

    public TelaHistoricoPedidos() {
        setLayout(new BorderLayout(10, 10));
        setBackground(Color.WHITE);

        JLabel titulo = new JLabel("Histórico de Pedidos", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(titulo, BorderLayout.NORTH);

        // Colunas
        String[] colunas = {"ID", "Cliente", "Produto", "Quantidade", "Status"};
        modelo = new DefaultTableModel(colunas, 0);
        tabela = new JTable(modelo);

        // Rolagem
        JScrollPane scroll = new JScrollPane(tabela);
        add(scroll, BorderLayout.CENTER);

        // Botões
        JPanel botoes = new JPanel();
        botoes.setBackground(Color.WHITE);
        JButton atualizar = new JButton("Atualizar Lista");
        botoes.add(atualizar);
        add(botoes, BorderLayout.SOUTH);

        // Dados simulados
        atualizar.addActionListener(e -> carregarPedidos());
    }

    private void carregarPedidos() {
        modelo.setRowCount(0); // limpa
        modelo.addRow(new Object[]{"001", "João Vitor", "Mouse Gamer", "2", "Entregue"});
        modelo.addRow(new Object[]{"002", "Maria Silva", "Teclado", "1", "Em preparo"});
        modelo.addRow(new Object[]{"003", "Lucas Alves", "Monitor 24\"", "3", "Aguardando pagamento"});
        modelo.addRow(new Object[]{"004", "Beatriz Lima", "Notebook", "1", "Enviado"});
    }
}
