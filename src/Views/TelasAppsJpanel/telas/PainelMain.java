package Views.TelasAppsJpanel.telas;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;

// Import das telas

public class PainelMain extends JFrame {
    private final JPanel conteudoPainel;
    private boolean MaximizarTela = false;
    private Point ClickPrincipal;

    public PainelMain() {

        // Remover tela windows - não mexer
        setUndecorated(true);
        setSize(1100, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Topo diferenciado 
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(40, 40, 40));
        topPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));

        // Menu da parte superior TopBar
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(40, 40, 40));
        menuBar.setForeground(Color.WHITE);

        // Solicitações
        JMenu pedidosMenu = new JMenu("Pedidos");
        pedidosMenu.setForeground(Color.WHITE);
        JMenuItem solicitarPedido = new JMenuItem("Solicitar Pedido");
        JMenuItem historicoPedido = new JMenuItem("Histórico de Pedidos");
        pedidosMenu.add(solicitarPedido);
        pedidosMenu.add(historicoPedido);

        //Cadastros
        JMenu cadastrarMenu = new JMenu("Cadastrar");
        cadastrarMenu.setForeground(Color.WHITE);
        JMenuItem cadCliente = new JMenuItem("Cadastrar Cliente");
        JMenuItem cadFuncionario = new JMenuItem("Cadastrar Funcionário");
        JMenuItem cadProduto = new JMenuItem("Cadastrar Produto");
        cadastrarMenu.add(cadCliente);
        cadastrarMenu.add(cadFuncionario);
        cadastrarMenu.add(cadProduto);

        //Visualização
        JMenu visualizarMenu = new JMenu("Visualizar");
        visualizarMenu.setForeground(Color.WHITE);
        JMenuItem verCliente = new JMenuItem("Ver Clientes");
        JMenuItem verFuncionario = new JMenuItem("Ver Funcionários");
        JMenuItem verProduto = new JMenuItem("Ver Produtos");
        visualizarMenu.add(verCliente);
        visualizarMenu.add(verFuncionario);
        visualizarMenu.add(verProduto);

        //Delete telas
        JMenu deletarMenu = new JMenu("Deletar");
        deletarMenu.setForeground(Color.WHITE);
        JMenuItem delPedido = new JMenuItem("Deletar Pedido");
        deletarMenu.add(delPedido);

        //Adicionar o menu na ordem correta
        menuBar.add(pedidosMenu);
        menuBar.add(cadastrarMenu);
        menuBar.add(visualizarMenu);
        menuBar.add(deletarMenu);

        //Botões de Estilização de windows - não mexer
        JPanel windowButtons = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 3));
        windowButtons.setOpaque(false);

        JButton minimizeButton = criarBotaoIcone("—", "Views/TelasAppsJpanel/Img/minimize.png", new Color(80, 80, 80), new Color(120, 120, 120));
        JButton maximizeButton = criarBotaoIcone("▢", "Views/TelasAppsJpanel/Img/maximize.png", new Color(80, 80, 80), new Color(120, 120, 120));
        JButton closeButton = criarBotaoIcone("✕", "Views/TelasAppsJpanel/Img/close.png", new Color(120, 40, 40), new Color(180, 40, 40));

        minimizeButton.addActionListener((ActionEvent e) -> {
            setState(JFrame.ICONIFIED);
        });

        maximizeButton.addActionListener((ActionEvent e) -> {
            alternarMaximizacao();
        });

        closeButton.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        windowButtons.add(minimizeButton);
        windowButtons.add(maximizeButton);
        windowButtons.add(closeButton);

        //Permite mexer a tela - não mexer
        topPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                ClickPrincipal = e.getPoint();
            }
        });

        topPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (!MaximizarTela) {
                    int thisX = getLocation().x;
                    int thisY = getLocation().y;
                    int xMoved = e.getX() - ClickPrincipal.x;
                    int yMoved = e.getY() - ClickPrincipal.y;
                    setLocation(thisX + xMoved, thisY + yMoved);
                }
            }
        });

        //Liga o topo - não mexer
        topPanel.add(menuBar, BorderLayout.WEST);
        topPanel.add(windowButtons, BorderLayout.EAST);
        add(topPanel, BorderLayout.NORTH);

        //Centro de conteudos 
        conteudoPainel = new JPanel(new BorderLayout());
        JLabel welcome = new JLabel("Bem-vindo ao sistema!", SwingConstants.CENTER);
        welcome.setFont(new Font("Arial", Font.BOLD, 24));
        conteudoPainel.add(welcome, BorderLayout.CENTER);
        add(conteudoPainel, BorderLayout.CENTER);

        // Ações do menu usando classes anônimas em vez de lambdas
        cadCliente.addActionListener((ActionEvent e) -> {
            trocarTela(new TelaCadastrarCliente());
        });

        cadFuncionario.addActionListener((ActionEvent e) -> {
            trocarTela(new TelaCadastrarFuncionario());
        });

        cadProduto.addActionListener((ActionEvent e) -> {
            trocarTela(new TelaCadastrarProduto());
        });

        verCliente.addActionListener((ActionEvent e) -> {
            trocarTela(new TelaVerClientes());
        });

        verFuncionario.addActionListener((ActionEvent e) -> {
            trocarTela(new TelaVerFuncionarios());
        });

        verProduto.addActionListener((ActionEvent e) -> {
            trocarTela(new TelaVerProdutos());
        });

        delPedido.addActionListener((ActionEvent e) -> {
            trocarTela(new TelaDeletarPedido());
        });

        solicitarPedido.addActionListener((ActionEvent e) -> {
            trocarTela(new TelaSolicitarPedido());
        });

        historicoPedido.addActionListener((ActionEvent e) -> {
            trocarTela(new TelaHistoricoPedidos());
        });

        setVisible(true);
    }

    // Botões personalizados não alterar 
    private JButton criarBotaoIcone(String simbolo, String caminhoIcone, Color bgColor, Color hoverColor) {
        JButton button = new JButton(simbolo);
        button.setFont(new Font("Dialog", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setPreferredSize(new Dimension(40, 30));

        try {
            URL iconURL = getClass().getClassLoader().getResource(caminhoIcone);
            if (iconURL != null) {
                ImageIcon icon = new ImageIcon(iconURL);
                Image scaled = icon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
                button.setIcon(new ImageIcon(scaled));
                button.setText(""); // remove texto se o ícone for encontrado
            } else {
                System.out.println("Ícone não encontrado: " + caminhoIcone);
            }
        } catch (Exception e) {
            System.out.println("Erro ao carregar ícone: " + caminhoIcone);
        }

        // Hoverzinho 
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(bgColor);
            }
        });

        return button;
    }

    // Maximo e restaurar tela
    private void alternarMaximizacao() {
        if (MaximizarTela) {
            setExtendedState(JFrame.NORMAL);
            setSize(1100, 700);
            setLocationRelativeTo(null);
        } else {
            setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
        MaximizarTela = !MaximizarTela;
    }

    // Troca de telas basico
    private void trocarTela(JPanel novaTela) {
        conteudoPainel.removeAll();
        conteudoPainel.add(novaTela, BorderLayout.CENTER);
        conteudoPainel.revalidate();
        conteudoPainel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        });
    }
}
