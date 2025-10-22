
package Views.TelasAppsJpanel.telas;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TelaVerFuncionarios extends JPanel {
    private JTable tabela;
    private DefaultTableModel modelo;
    private JPanel areaDeBusca;
    private JLabel label;
    private JTextField campoBusca;

    public TelaVerFuncionarios() {
        setLayout(new BorderLayout(10, 10));
        setBackground(Color.WHITE);

        JLabel titulo = new JLabel("Vizualizar Funcionarios", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(titulo, BorderLayout.NORTH);

        areaDeBusca = new JPanel(new FlowLayout());
        areaDeBusca.setBackground(Color.WHITE);

        label = new JLabel("Buscar:");
        campoBusca = new JTextField(15);

        // Adiciona os componentes ao painel de busca
        areaDeBusca.add(label);
        areaDeBusca.add(campoBusca);


        add(areaDeBusca, BorderLayout.BEFORE_FIRST_LINE); 

        JPanel painelSuperior = new JPanel(new BorderLayout());
        painelSuperior.setBackground(Color.WHITE);
        painelSuperior.add(titulo, BorderLayout.NORTH);
        painelSuperior.add(areaDeBusca, BorderLayout.SOUTH);


        add(painelSuperior, BorderLayout.NORTH);
        

        // Colunas
        String[] colunas = {"Código", "Nome"};
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
        JButton atualizar = new JButton("Atualizar Lista");
        botoes.add(atualizar);
        add(botoes, BorderLayout.SOUTH);
    }
}

