package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import Control.CategoriaController;
import Control.ClienteController;
import Model.CategoriaModel;
import Model.ClienteModel;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class TelaConsultaCliente {

    private JFrame frame;
    private JTable table;
    private JTextField textField;
    private JComboBox<String> comboBox;
    private JLabel lblCategoria;
    private JButton btnVoltar;
    private ClienteController clienteController;
    private SimpleDateFormat dateFormat;  // Variável global para o formato de data

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaConsultaCliente window = new TelaConsultaCliente();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public TelaConsultaCliente() {
        clienteController = new ClienteController();
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");  // Inicializando a variável global
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 333);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // Busca clientes e preenche a tabela
        ArrayList<ClienteModel> clientes = clienteController.buscarClientes();
        if (clientes == null || clientes.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Nenhum cliente encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Object[][] dadosClientes = new Object[clientes.size()][7];

        for (int i = 0; i < clientes.size(); i++) {
            ClienteModel cliente = clientes.get(i);
            dadosClientes[i][0] = cliente.getCodigo();
            dadosClientes[i][1] = cliente.getNome();
            dadosClientes[i][2] = cliente.getCpf();
            dadosClientes[i][3] = cliente.getEmail();
            dadosClientes[i][4] = cliente.getEndereco();

            // Correção do processamento de data
            try {
                dadosClientes[i][5] = cliente.getDtNascimento() != null ? dateFormat.format(cliente.getDtNascimento()) : "Sem Data";
            } catch (Exception e) {
                dadosClientes[i][5] = "Data Inválida";
            }

            CategoriaController categoriaController = new CategoriaController();
            CategoriaModel categoria = categoriaController.procurarCategoriaId(cliente.getCategoria());

            dadosClientes[i][6] = categoria != null ? categoria.getNome() : "Sem Categoria";
        }

        table = new JTable();
        table.setModel(new DefaultTableModel(dadosClientes, new String[]{"Codigo", "Nome", "CPF", "Email", "Endereco", "Data de Nascimento", "Categoria"}));
        table.getColumnModel().getColumn(6).setPreferredWidth(112);
        table.setBounds(10, 63, 414, 187);
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                if (row != -1) {
                    int codigo = (int) table.getValueAt(row, 0);
                    ClienteModel cliente = clienteController.procurarClienteCodigo(codigo);

                    TelaCadastroCliente telaCadastroCliente = new TelaCadastroCliente();
                    telaCadastroCliente.show(cliente);
                    frame.dispose();
                }
            }
        });
        frame.getContentPane().add(table);

        JLabel lblConsultaDeCliente = new JLabel("Consulta de cliente");
        lblConsultaDeCliente.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblConsultaDeCliente.setBounds(10, 11, 284, 14);
        frame.getContentPane().add(lblConsultaDeCliente);

        textField = new JTextField();
        textField.setBounds(54, 39, 181, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel = new JLabel("Nome");
        lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel.setBounds(10, 42, 46, 14);
        frame.getContentPane().add(lblNewLabel);

        JButton btnNewButton = new JButton("Pesquisar");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = textField.getText();
                ArrayList<ClienteModel> retorno = clienteController.procurarCliente(nome);

                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0); // Limpa a tabela
                comboBox.setSelectedIndex(0);
                textField.setText(null);

                if (retorno.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Nenhum cliente encontrado com esse nome!", "Mensagem", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                for (ClienteModel cliente : retorno) {
                    CategoriaController categoriaController = new CategoriaController();
                    CategoriaModel categoria = categoriaController.procurarCategoriaId(cliente.getCategoria());

                    Object[] dados = {
                            cliente.getCodigo(),
                            cliente.getNome(),
                            cliente.getCpf(),
                            cliente.getEmail(),
                            cliente.getEndereco(),
                            dateFormat.format(cliente.getDtNascimento()),
                            categoria != null ? categoria.getNome() : "Sem Categoria"
                    };

                    model.addRow(dados);
                }
            }
        });
        btnNewButton.setBounds(335, 38, 89, 23);
        frame.getContentPane().add(btnNewButton);

        CategoriaController categoriaController = new CategoriaController();
        ArrayList<CategoriaModel> categorias = categoriaController.buscarCategorias();

        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        comboBoxModel.addElement("Todas");
        for (CategoriaModel categoria : categorias) {
            comboBoxModel.addElement(categoria.getNome());
        }

        comboBox = new JComboBox<>();
        comboBox.setModel(comboBoxModel);
        comboBox.setBounds(245, 39, 80, 20);
        frame.getContentPane().add(comboBox);
        comboBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED && textField.getText().isEmpty()) {
                ArrayList<ClienteModel> retorno;
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0); // Limpa a tabela

                if (comboBox.getSelectedIndex() == 0) {
                    retorno = clienteController.buscarClientes();
                } else {
                    CategoriaModel categoria = categoriaController.procurarCategoriaNome((String) comboBox.getSelectedItem());
                    retorno = clienteController.procurarClienteCategoria(categoria.getId());
                }

                if (retorno.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Nenhum cliente pertencente a essa categoria!", "Mensagem", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                for (ClienteModel cliente : retorno) {
                    CategoriaModel categoria = categoriaController.procurarCategoriaId(cliente.getCategoria());

                    Object[] dados = {
                            cliente.getCodigo(),
                            cliente.getNome(),
                            cliente.getCpf(),
                            cliente.getEmail(),
                            cliente.getEndereco(),
                            dateFormat.format(cliente.getDtNascimento()),
                            categoria != null ? categoria.getNome() : "Sem Categoria"
                    };

                    model.addRow(dados);
                }
            }
        });

        lblCategoria = new JLabel("Categoria");
        lblCategoria.setHorizontalAlignment(SwingConstants.CENTER);
        lblCategoria.setBounds(245, 23, 80, 14);
        frame.getContentPane().add(lblCategoria);

        btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                TelaCadastroCliente telaCadastroCliente = new TelaCadastroCliente();
                telaCadastroCliente.show();
            }
        });
        btnVoltar.setBounds(10, 260, 89, 23);
        frame.getContentPane().add(btnVoltar);
    }

    public void show() {
        frame.setVisible(true);
    }

    public void show(String message) {
        show();
        JOptionPane.showMessageDialog(frame, message, "Mensagem", JOptionPane.INFORMATION_MESSAGE);
    }
}
