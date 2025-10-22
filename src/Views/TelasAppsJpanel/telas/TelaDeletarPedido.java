package Views.TelasAppsJpanel.telas;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TelaDeletarPedido extends JPanel {
    private JTable tabela;
    private DefaultTableModel modelo;
    private JPanel areaDeBusca;
    private JLabel label;
    private JTextField campoBusca;
    JButton botaoBuscar;

    public TelaDeletarPedido() {
        setLayout(new BorderLayout(10, 10));
        setBackground(Color.WHITE);

        JLabel titulo = new JLabel("Deletar Pedido", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(titulo, BorderLayout.NORTH);

        areaDeBusca = new JPanel(new FlowLayout());
        areaDeBusca.setBackground(Color.WHITE);

        label = new JLabel("Buscar:");
        campoBusca = new JTextField(15);
        botaoBuscar = new JButton("Buscar");

        // Adiciona os componentes ao painel de busca
        areaDeBusca.add(label);
        areaDeBusca.add(campoBusca);
        areaDeBusca.add(botaoBuscar);


        add(areaDeBusca, BorderLayout.BEFORE_FIRST_LINE); 

        JPanel painelSuperior = new JPanel(new BorderLayout());
        painelSuperior.setBackground(Color.WHITE);
        painelSuperior.add(titulo, BorderLayout.NORTH);
        painelSuperior.add(areaDeBusca, BorderLayout.SOUTH);


        add(painelSuperior, BorderLayout.NORTH);
        

        // Colunas
        String[] colunas = {"ID", "Cliente", "Produto", "Quantidade"};
        modelo = new DefaultTableModel(colunas, 0);
        tabela = new JTable(modelo) {
            @Override public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Rolagem
        JScrollPane scroll = new JScrollPane(tabela);
        add(scroll, BorderLayout.CENTER);

        // Botões
        JPanel botoes = new JPanel();
        botoes.setBackground(Color.WHITE);
        JButton deletar = new JButton("Deletar Pedido");
        deletar.setBackground(Color.RED);
        deletar.setForeground(Color.WHITE);
        botoes.add(deletar);
        add(botoes, BorderLayout.SOUTH);

    }
    
}
