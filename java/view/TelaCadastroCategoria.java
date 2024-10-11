package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

import Control.CategoriaController;
import Model.CategoriaModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroCategoria {

	private JFrame frame;
	private JTextField nomeField;
	private JTextField descricaoField;
	private JCheckBox ativoCheckbox;
	private int categoriaId;
	private JButton btnRemover;


	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				try {
					
					TelaCadastroCategoria window = new TelaCadastroCategoria();
					window.frame.setVisible(true);
				} catch (Exception e) {
					
					e.printStackTrace();
					
				}
			}
		});
	}

	
	 
	public TelaCadastroCategoria() {
		
		initialize();
		
	}

	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 313, 199);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCadastroDeCategoria = new JLabel("Cadastro de categoria");
		lblCadastroDeCategoria.setHorizontalAlignment(SwingConstants.LEFT);
		lblCadastroDeCategoria.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCadastroDeCategoria.setBounds(11, 12, 179, 21);
		frame.getContentPane().add(lblCadastroDeCategoria);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(10, 45, 65, 14);
		frame.getContentPane().add(lblNewLabel);
		
		nomeField = new JTextField();
		nomeField.setBounds(76, 45, 150, 20);
		frame.getContentPane().add(nomeField);
		nomeField.setColumns(10);
		
		JLabel lblDescricao = new JLabel("Descricao");
		lblDescricao.setBounds(10, 76, 65, 14);
		frame.getContentPane().add(lblDescricao);
		
		descricaoField = new JTextField();
		descricaoField.setColumns(10);
		descricaoField.setBounds(76, 73, 150, 20);
		frame.getContentPane().add(descricaoField);
		
		ativoCheckbox = new JCheckBox("Ativo");
		ativoCheckbox.setHorizontalAlignment(SwingConstants.LEFT);
		ativoCheckbox.setBounds(72, 97, 97, 23);
		frame.getContentPane().add(ativoCheckbox);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String resultadoDao;
				
				CategoriaController categoriaController = new CategoriaController();
				CategoriaModel categoria = categoriaController.procurarCategoriaId(categoriaId);
				
				if(categoria != null) {
					
					categoria.setNome(nomeField.getText());
					categoria.setDescricao(descricaoField.getText());
					categoria.setAtivo(ativoCheckbox.isSelected());
					
					
					resultadoDao = categoriaController.atualizarCategoria(categoria);
				} else {
					
					CategoriaModel novaCategoria = new CategoriaModel();
					novaCategoria.setNome(nomeField.getText());
					novaCategoria.setDescricao(descricaoField.getText());
					novaCategoria.setAtivo(ativoCheckbox.isSelected());
					
					
					resultadoDao = categoriaController.cadastrarCategoria(novaCategoria);
				}
				
				if(resultadoDao.contains("sucesso")) {
					
					frame.dispose();
					TelaConsultaCategoria telaConsultaCategoria = new TelaConsultaCategoria();
					telaConsultaCategoria.show(resultadoDao);
					
				} else {
					
					JOptionPane.showMessageDialog(frame, resultadoDao, "Mensagem", JOptionPane.ERROR_MESSAGE);
					
				}
			}
		});
		
		btnNewButton.setBounds(198, 131, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		btnRemover = new JButton("Deletar");
		btnRemover.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				int remover = JOptionPane.showConfirmDialog(null, "Você tem certeza?", "Mensagem", JOptionPane.YES_NO_OPTION);
				if(remover == JOptionPane.NO_OPTION) return;
				
				CategoriaController categoriaController = new CategoriaController();
				String resultado = categoriaController.removerCategoria(categoriaId);
				
				if(resultado.contains("Sucesso!")) {
					
					frame.dispose();
					TelaConsultaCategoria telaConsultaCategoria = new TelaConsultaCategoria();
					telaConsultaCategoria.show(resultado);
					
				} else {
					
					JOptionPane.showMessageDialog(frame, resultado, "Mensagem", JOptionPane.ERROR_MESSAGE);
					
				}
			}
		});
		btnRemover.setForeground(new Color(255, 0, 0));
		btnRemover.setBounds(105, 131, 89, 23);
		frame.getContentPane().add(btnRemover);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				TelaConsultaCategoria telaConsultaCategoria = new TelaConsultaCategoria();
				telaConsultaCategoria.show();
				
			}
			
		});
		
		btnNewButton_1.setBounds(10, 131, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		btnRemover.setVisible(false);
		
	}
	
	public void show() {
		
		frame.setVisible(true);
		
	}
	
	public void show(CategoriaModel categoria) {
		categoriaId = categoria.getId();
		nomeField.setText(categoria.getNome());
		descricaoField.setText(categoria.getDescricao());
		ativoCheckbox.setSelected(categoria.getAtivo());
		btnRemover.setVisible(true);
		
		show();
		
	}
	
}
