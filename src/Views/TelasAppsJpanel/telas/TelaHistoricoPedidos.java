package Views.TelasAppsJpanel.telas;

import Views.InterfaceViews.InterfaceSelect;
import entidades.Pedidos;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TelaHistoricoPedidos extends JPanel implements InterfaceSelect<Pedidos> {
    private JTable tabela;
    private DefaultTableModel modelo;
    private JPanel areaDeBusca;
    private JLabel label;
    private JTextField campoBusca;
    private JButton atualizar;
    

    public TelaHistoricoPedidos() {
        setLayout(new BorderLayout(10, 10));
        setBackground(Color.WHITE);

        JLabel titulo = new JLabel("Histórico de Pedidos", SwingConstants.CENTER);
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
        atualizar = new JButton("Atualizar Lista");
        botoes.add(atualizar);
        add(botoes, BorderLayout.SOUTH);

        // Dados simulados
        //atualizar.addActionListener(e -> carregarPedidos());
    }



	@Override
	public String getBusca() {
		return campoBusca.getText();
	}

	@Override
	public void mostrarTodos(List<Pedidos> lista) {
		preencherTabela(lista);
	}
	
    @Override
	public void preencherTabela(List<Pedidos> pd) {
		modelo.setRowCount(0);
		for(Pedidos p : pd) {
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
	public void addListenerBusca(ActionListener al) {
		campoBusca.addActionListener(al);
	}



	@Override
	public void addListarTodos(ActionListener al) {
		atualizar.addActionListener(al);
		
	}
}
