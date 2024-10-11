package view;

import javax.swing.*;

import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Control.CategoriaController;
import Control.ClienteController;
import Model.CategoriaModel;
import Model.ClienteModel;

public class TelaCadastroCliente {

    private JFrame frame;
    private JTextField textFieldNome;
    private JFormattedTextField textFieldCpf;
    private JFormattedTextField textFieldDataNascimento;
    private JTextField textFieldEmail;
    private JTextField textFieldEndereco;
    private JComboBox<String> comboBoxCategoria;
    private ClienteModel cliente;
    private ClienteController clienteController;
    private JButton btnConsultar;

    public TelaCadastroCliente() {
        this.clienteController = new ClienteController(); // Instanciando o clienteController
        initialize();
    }

    public void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(new Color(240, 240, 240));

        JLabel lblCadastroCliente = new JLabel("Cadastro de Cliente");
        lblCadastroCliente.setFont(new Font("Arial", Font.BOLD, 16));
        lblCadastroCliente.setForeground(new Color(0, 51, 153));
        lblCadastroCliente.setBounds(10, 10, 200, 30);
        frame.getContentPane().add(lblCadastroCliente);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(10, 50, 100, 30);
        frame.getContentPane().add(lblNome);

        textFieldNome = new JTextField();
        textFieldNome.setBounds(120, 50, 350, 30);
        frame.getContentPane().add(textFieldNome);

        JLabel lblCpf = new JLabel("CPF:");
        lblCpf.setBounds(10, 90, 100, 30);
        frame.getContentPane().add(lblCpf);

        try {
            textFieldCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
            textFieldCpf.setBounds(120, 90, 150, 30);
            frame.getContentPane().add(textFieldCpf);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JLabel lblDataNascimento = new JLabel("Data de Nascimento:");
        lblDataNascimento.setBounds(10, 130, 150, 30);
        frame.getContentPane().add(lblDataNascimento);

        try {
            textFieldDataNascimento = new JFormattedTextField(new MaskFormatter("##/##/####"));
            textFieldDataNascimento.setBounds(160, 130, 100, 30);
            frame.getContentPane().add(textFieldDataNascimento);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(10, 170, 100, 30);
        frame.getContentPane().add(lblEmail);

        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(120, 170, 350, 30);
        frame.getContentPane().add(textFieldEmail);

        JLabel lblEndereco = new JLabel("Endereco:");
        lblEndereco.setBounds(10, 210, 100, 30);
        frame.getContentPane().add(lblEndereco);

        textFieldEndereco = new JTextField();
        textFieldEndereco.setBounds(120, 210, 350, 30);
        frame.getContentPane().add(textFieldEndereco);

        JLabel lblCategoria = new JLabel("Categoria:");
        lblCategoria.setBounds(10, 250, 100, 30);
        frame.getContentPane().add(lblCategoria);

        comboBoxCategoria = new JComboBox<>();
        CategoriaController categoriaController = new CategoriaController();
        ArrayList<CategoriaModel> categorias = categoriaController.buscarCategorias();
        for (CategoriaModel categoria : categorias) {
            comboBoxCategoria.addItem(categoria.getNome());
        }
        comboBoxCategoria.setBounds(120, 250, 350, 30);
        frame.getContentPane().add(comboBoxCategoria);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(120, 300, 100, 30);
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salvarCliente(); // Chama a função para salvar o cliente
            }
        });
        frame.getContentPane().add(btnSalvar);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(240, 300, 100, 30);
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                TelaPrincipal telaPrincipal = new TelaPrincipal();
                telaPrincipal.show();
            }
        });
        frame.getContentPane().add(btnVoltar);

        // Adicionando o botão "Consulta" para abrir a tela de consulta de clientes
        btnConsultar = new JButton("Consulta");
        btnConsultar.setBounds(360, 300, 100, 30);
        btnConsultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                TelaConsultaCliente consultaCliente = new TelaConsultaCliente();
                consultaCliente.show(); // Abre a tela de consulta de clientes
            }
        });
        frame.getContentPane().add(btnConsultar);
    }

    private void salvarCliente() {
        try {
            String nome = textFieldNome.getText();
            String cpf = textFieldCpf.getText();
            String email = textFieldEmail.getText();
            String endereco = textFieldEndereco.getText();
            String dataNascimentoStr = textFieldDataNascimento.getText();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date dataNascimento = dateFormat.parse(dataNascimentoStr);
            String categoriaNome = (String) comboBoxCategoria.getSelectedItem();
            CategoriaController categoriaController = new CategoriaController();
            CategoriaModel categoria = categoriaController.procurarCategoriaNome(categoriaNome);

            // Validação básica
            if (nome.isEmpty() || cpf.isEmpty() || email.isEmpty() || endereco.isEmpty() || dataNascimento == null || categoria == null) {
                JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos.");
                return;
            }

            // Cria um novo cliente
            ClienteModel novoCliente = new ClienteModel();
            novoCliente.setNome(nome);
            novoCliente.setCpf(cpf);
            novoCliente.setEmail(email);
            novoCliente.setEndereco(endereco);
            novoCliente.setDtNascimento(new java.sql.Date(dataNascimento.getTime()));
            novoCliente.setCategoria(categoria.getId()); // Armazena o ID da categoria

            // Salva o cliente usando o controlador
            String resultado = clienteController.cadastrarCliente(novoCliente);

            if (resultado.equals("Cliente cadastrado com sucesso!")) {
                JOptionPane.showMessageDialog(frame, resultado);
                
            } else {
                JOptionPane.showMessageDialog(frame, resultado, "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Erro ao salvar cliente: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void show() {
        frame.setVisible(true);
    }

    public void show(ClienteModel cliente) {
        this.cliente = cliente;
        textFieldNome.setText(cliente.getNome());
        textFieldCpf.setText(cliente.getCpf());
        textFieldDataNascimento.setText(new SimpleDateFormat("dd/MM/yyyy").format(cliente.getDtNascimento()));
        textFieldEmail.setText(cliente.getEmail());
        textFieldEndereco.setText(cliente.getEndereco());
        comboBoxCategoria.setSelectedItem(cliente.getCategoria());
        frame.setVisible(true);
    }
}
