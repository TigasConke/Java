package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Control.UsuarioController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class LoginView {

	private JFrame frame;
	private JTextField usuarioField;
	private JLabel lblInfo;
	private JPasswordField senhaField;


	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				try {
					
					LoginView window = new LoginView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		});
	}

	public LoginView() {
		
		initialize();
		
	}

	
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 175);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblUsuario);
		
		usuarioField = new JTextField();
		usuarioField.setBounds(64, 8, 210, 20);
		frame.getContentPane().add(usuarioField);
		usuarioField.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 36, 46, 14);
		frame.getContentPane().add(lblSenha);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String usuario = usuarioField.getText();
				String senha = new String(senhaField.getPassword());
				
				UsuarioController usuarioController = new UsuarioController();
				String controllerReturn = usuarioController.realizarLogin(usuario, senha);
				
				if(controllerReturn.contains("sucesso")) {
					
					frame.dispose();
					TelaPrincipal telaPrincipal = new TelaPrincipal();
					telaPrincipal.show(controllerReturn);
					
				} else {
					
					lblInfo.setForeground(Color.RED);
					lblInfo.setText(controllerReturn);
					
				}
			}
		});
		btnNewButton.setBounds(185, 102, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		lblInfo = new JLabel("");
		lblInfo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInfo.setForeground(new Color(255, 0, 0));
		lblInfo.setBounds(10, 64, 264, 14);
		frame.getContentPane().add(lblInfo);
		
		senhaField = new JPasswordField();
		senhaField.setBounds(64, 33, 210, 20);
		frame.getContentPane().add(senhaField);
	}
}
