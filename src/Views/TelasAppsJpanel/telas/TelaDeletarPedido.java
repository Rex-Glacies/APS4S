package Views.TelasAppsJpanel.telas;

import Views.InterfaceViews.InterfaceDeletarPedido;
import entidades.Pedidos;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TelaDeletarPedido extends JPanel implements InterfaceDeletarPedido {
    private JTable tabela;
    private DefaultTableModel modelo;
    private JPanel areaDeBusca;
    private JLabel label;
    private JTextField campoBusca;
    JButton botaoBuscar;
    JButton deletar;

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
        String[] colunas = {"Num.Pedido", "Cod.Fun", "Cod.Cliente", "Cod.Produto", "Quantidade"};
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
        deletar = new JButton("Deletar Pedido");
        deletar.setBackground(Color.RED);
        deletar.setForeground(Color.WHITE);
        botoes.add(deletar);
        add(botoes, BorderLayout.SOUTH);

    }

    @Override
    public int getNumPedido() {
        return Integer.parseInt(campoBusca.getText());
    }

    @Override
    public void mostrarTodos(List<Pedidos> lista) {
        preencherTabela(lista);
    }

    @Override
    public void preencherTabela(List<Pedidos> a) {
        modelo.setRowCount(0);
		for(Pedidos p : a) {
			Object [] row = new Object[5];
			row[0] = p.getNum_pedido();
			row[1] = p.getCod_fun();
			row[2] = p.getCod_clien();
			row[3] = p.getCod_prod();
			row[4] = p.getQuantidade_prod();
			
			modelo.addRow(row);
		}
    }

    @Override
    public void AddBuscapedido(ActionListener ax) {
        botaoBuscar.addActionListener(ax);
        campoBusca.addActionListener(ax);
    }

    @Override
    public void addDeletar(ActionListener al) {
        deletar.addActionListener(al);
    }



    @Override
    public void LimparTabela() {
        modelo.setRowCount(0);
        campoBusca.setText("");
    }
    
}
