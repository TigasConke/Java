package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import Control.CategoriaController;
import Model.CategoriaModel;

import java.awt.Color;
import java.awt.Font;

public class TelaPrincipal {

	private JFrame frame;
	JLabel infoLabel = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
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
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 346, 220);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Cadastrar cliente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CategoriaController categoriaController = new CategoriaController();
				ArrayList<CategoriaModel> categorias = categoriaController.buscarCategorias();
				
				if(categorias.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Cadastruma categoria antes de cadastrar um cliente.", "Mensagem", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				TelaCadastroCliente telaCadastroCliente = new TelaCadastroCliente();
				telaCadastroCliente.show();
				frame.dispose();
			}
		});
		btnNewButton.setBounds(10, 36, 150, 50);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setForeground(new Color(123, 0, 0));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnSair.setBounds(89, 95, 150, 50);
		frame.getContentPane().add(btnSair);
		
		infoLabel = new JLabel("");
		infoLabel.setForeground(new Color(0, 0, 255));
		infoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		infoLabel.setBounds(10, 156, 310, 14);
		frame.getContentPane().add(infoLabel);
		
		JLabel lblPrincipal = new JLabel("Home");
		lblPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrincipal.setBounds(10, 11, 284, 14);
		frame.getContentPane().add(lblPrincipal);
		
		JButton btnCadastrarCategoria = new JButton("Categorias");
		btnCadastrarCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				TelaConsultaCategoria telaConsultaCategoria = new TelaConsultaCategoria();
				telaConsultaCategoria.show();
			}
		});
		btnCadastrarCategoria.setBounds(170, 36, 150, 50);
		frame.getContentPane().add(btnCadastrarCategoria);
	}
	
	public void show() {
		frame.setVisible(true);
	}
	
	public void show(String message) {
		show();
		infoLabel.setText(message);
	}
}
