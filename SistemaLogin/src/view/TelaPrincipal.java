package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaPrincipal extends JFrame {
    private JPanel painelLogin;
    private JTextField campoUsuario;
    private JPasswordField campoSenha;
    private JButton botaoLogin;
    private JButton botaoCadastroCliente; // Botão para abrir TelaCadastroCliente

    public TelaPrincipal() {
        setTitle("Sistema de Cadastro");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initLoginComponents(); // Inicializa os componentes da tela de login
    }

    // Inicializa a tela de login
    private void initLoginComponents() {
        painelLogin = new JPanel();
        painelLogin.setLayout(new GridLayout(4, 2)); // Ajustado para adicionar o botão de cadastro

        painelLogin.add(new JLabel("Usuário:"));
        campoUsuario = new JTextField();
        painelLogin.add(campoUsuario);

        painelLogin.add(new JLabel("Senha:"));
        campoSenha = new JPasswordField();
        painelLogin.add(campoSenha);

        botaoLogin = new JButton("Login");
        botaoLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarLogin();
            }
        });
        painelLogin.add(botaoLogin);

        // Adiciona o botão de cadastro de clientes ao painel de login
        botaoCadastroCliente = new JButton("Cadastrar Cliente");
        botaoCadastroCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Abre a tela de cadastro de clientes
                TelaCadastroCliente telaCadastroCliente = new TelaCadastroCliente();
                telaCadastroCliente.setVisible(true);
            }
        });
        painelLogin.add(botaoCadastroCliente);

        add(painelLogin);
    }

    // Método para realizar o login
    private void realizarLogin() {
        String usuario = campoUsuario.getText();
        String senha = new String(campoSenha.getPassword());

        // Aqui deveria ser implementado o controle de login
        if (usuario.equals("admin") && senha.equals("admin")) {  // Exemplo simplificado
            // Remove o painel de login e inicializa a interface principal
            remove(painelLogin);
            initMainComponents();
            revalidate();
            repaint();
        } else {
            JOptionPane.showMessageDialog(this, "Usuário ou senha incorretos.", "Erro de Login", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Inicializa a tela principal com o botão de cadastro de clientes
    private void initMainComponents() {
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BorderLayout());

        // Adiciona uma mensagem de boas-vindas
        JLabel labelBemVindo = new JLabel("Bem-vindo ao sistema!", SwingConstants.CENTER);
        painelPrincipal.add(labelBemVindo, BorderLayout.NORTH);

        // Cria o botão para cadastrar cliente
        botaoCadastroCliente = new JButton("Cadastrar Cliente");
        botaoCadastroCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Abre a tela de cadastro de clientes
                TelaCadastroCliente telaCadastroCliente = new TelaCadastroCliente();
                telaCadastroCliente.setVisible(true);
            }
        });

        // Adiciona o botão ao painel principal
        painelPrincipal.add(botaoCadastroCliente, BorderLayout.CENTER);

        // Adiciona o painel principal à tela
        add(painelPrincipal, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }
}