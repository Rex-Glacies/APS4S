package Views.TelasAppsJpanel.telas;

import Views.InterfaceViews.InterfaceSelect;
import entidades.Produtos;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TelaVerProdutos extends JPanel implements InterfaceSelect<Produtos> {
    private JTable tabela;
    private DefaultTableModel modelo;
    private JPanel areaDeBusca;
    private JLabel label;
    private JTextField campoBusca;
    private JButton atualizar;

    public TelaVerProdutos() {
        setLayout(new BorderLayout(10, 10));
        setBackground(Color.WHITE);

        JLabel titulo = new JLabel("Vizualizar Produtos", SwingConstants.CENTER);
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
        String[] colunas = {"Código", "Nome", "Preço", "Estoque"};
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
        atualizar = new JButton("Atualizar Lista");
        botoes.add(atualizar);
        add(botoes, BorderLayout.SOUTH);
    }

    @Override
    public String getBusca() {
        return campoBusca.getText();
    }

    @Override
    public void mostrarTodos(List<Produtos> lista) {
        preencherTabela(lista);
    }

    @Override
    public void preencherTabela(List<Produtos> a) {
        modelo.setRowCount(0);
        for (Produtos p : a) {
            Object[] row = new Object[4];
            row[0] = p.getP_codigo();
            row[1] = p.getP_nome();
            row[2] = p.getP_preco();
            row[3] = p.getP_estoque();

            modelo.addRow(row);
        }
    }

    @Override
    public void addListenerBusca(ActionListener al) {
        campoBusca.addActionListener(al);
    }

    @Override
    public void addListarTodos(ActionListener al) {
        atualizar.addActionListener(al);
    }
}
