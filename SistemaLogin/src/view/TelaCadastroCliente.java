package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaCadastroCliente extends JFrame {
    private JTextField campoNome;
    private JTextField campoCpf;
    private JTextField campoEmail;
    private JTextField campoEndereco;
    private JTextField campoDataNascimento;
    private JPasswordField campoSenha; // Campo de Senha
    private JButton botaoSalvar;
    private JButton botaoCancelar;

    public TelaCadastroCliente() {
        setTitle("Cadastro de Cliente");
        setSize(400, 350); // Aumentado para acomodar o novo campo
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initCadastroClienteComponents();
    }

    private void initCadastroClienteComponents() {
        JPanel painelCadastro = new JPanel();
        painelCadastro.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Espaço entre os componentes

        // Configuração da GridBagLayout
        gbc.anchor = GridBagConstraints.WEST;

        // Nome
        gbc.gridx = 0;
        gbc.gridy = 0;
        painelCadastro.add(new JLabel("Nome:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        campoNome = new JTextField(20);
        painelCadastro.add(campoNome, gbc);

        // CPF
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        painelCadastro.add(new JLabel("CPF:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        campoCpf = new JTextField(20);
        painelCadastro.add(campoCpf, gbc);

        // Email
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        painelCadastro.add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        campoEmail = new JTextField(20);
        painelCadastro.add(campoEmail, gbc);

        // Endereço
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        painelCadastro.add(new JLabel("Endereço:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        campoEndereco = new JTextField(20);
        painelCadastro.add(campoEndereco, gbc);

        // Data de Nascimento
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.NONE;
        painelCadastro.add(new JLabel("Data de Nascimento:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        campoDataNascimento = new JTextField(20);
        painelCadastro.add(campoDataNascimento, gbc);

        // Senha
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.NONE;
        painelCadastro.add(new JLabel("Senha:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        campoSenha = new JPasswordField(20);
        painelCadastro.add(campoSenha, gbc);

        // Botões
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;

        JPanel painelBotoes = new JPanel();
        botaoSalvar = new JButton("Salvar");
        botaoSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Implementar a lógica de salvar cliente
                JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!");
                dispose(); // Fecha a janela de cadastro após salvar
            }
        });
        painelBotoes.add(botaoSalvar);

        botaoCancelar = new JButton("Cancelar");
        botaoCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a janela de cadastro
            }
        });
        painelBotoes.add(botaoCancelar);

        painelCadastro.add(painelBotoes, gbc);

        add(painelCadastro);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroCliente().setVisible(true);
            }
        });
    }
}