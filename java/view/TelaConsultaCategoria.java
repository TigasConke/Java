package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Control.CategoriaController;
import Model.CategoriaModel;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class TelaConsultaCategoria {

	private JFrame frame;
	private JTable table;
	private JLabel lblNewLabel;
	private JLabel lblNome;
	private JLabel lblDescricao;
	private JLabel lblAtivo;
	private JButton btnNewButton;
	private JButton btnVoltar;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultaCategoria window = new TelaConsultaCategoria();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public TelaConsultaCategoria() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 334);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblConsultaDeCategoria = new JLabel("Consulta de categorias");
		lblConsultaDeCategoria.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConsultaDeCategoria.setBounds(10, 11, 220, 20);
		frame.getContentPane().add(lblConsultaDeCategoria);
		
		CategoriaController categoriaController = new CategoriaController();
		ArrayList<CategoriaModel> categorias = categoriaController.buscarCategorias();
		
		Object[][] dadosIniciaisTable = new Object[categorias.size()][4];
		for (int i = 0; i < categorias.size(); i++) {
            CategoriaModel categoria = categorias.get(i);
            dadosIniciaisTable[i][0] = categoria.getId();
            dadosIniciaisTable[i][1] = categoria.getNome();
            dadosIniciaisTable[i][2] = categoria.getDescricao();
            dadosIniciaisTable[i][3] = categoria.getAtivo();
        }
        
		table = new JTable();
		table.setModel(new DefaultTableModel(dadosIniciaisTable, new String[] { "ID", "Nome", "Descri\u00E7\u00E3o", "Ativo" }));
		table.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		        int row = table.getSelectedRow();
		        if (row != -1) {
		            int categoriaId = (int) table.getValueAt(row, 0);

		            CategoriaController categoriaController = new CategoriaController();
                    CategoriaModel categoria = categoriaController.procurarCategoriaId(categoriaId);
                    
                    TelaCadastroCategoria telaCadastroCategoria = new TelaCadastroCategoria();
                    telaCadastroCategoria.show(categoria);
                    frame.dispose();
		        }
		    }
		});
		table.setBounds(10, 63, 414, 187);
		frame.getContentPane().add(table);
		
		lblNewLabel = new JLabel("ID");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(30, 47, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setBounds(140, 47, 46, 14);
		frame.getContentPane().add(lblNome);
		
		lblDescricao = new JLabel("Descricao");
		lblDescricao.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescricao.setBounds(214, 47, 105, 14);
		frame.getContentPane().add(lblDescricao);
		
		lblAtivo = new JLabel("Ativo");
		lblAtivo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtivo.setBounds(318, 47, 105, 14);
		frame.getContentPane().add(lblAtivo);
		
		btnNewButton = new JButton("Cadastrar categoria");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				TelaCadastroCategoria telaCadastroCategoria = new TelaCadastroCategoria();
				telaCadastroCategoria.show();
			}
		});
		btnNewButton.setBounds(268, 261, 156, 23);
		frame.getContentPane().add(btnNewButton);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				TelaPrincipal telaPrincipal = new TelaPrincipal();
				telaPrincipal.show();
			}
		});
		btnVoltar.setBounds(10, 261, 89, 23);
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
