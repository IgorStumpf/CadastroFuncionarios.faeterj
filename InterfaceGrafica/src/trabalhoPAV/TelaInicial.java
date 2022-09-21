package trabalhoPAV;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import trabalhoPAV.FuncionarioService;
import trabalhoPAV.Funcionario;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class TelaInicial extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private FuncionarioService funcionario;
	private JTable tabelaFuncionarios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	/**
	 * Create the frame.
	 */
	public TelaInicial() {
		setBackground(new Color(0, 145, 0));
		
        funcionario = new FuncionarioService();
        ArrayList<Funcionario> f1 = funcionario.listFuncionario;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(25, 28, 35, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(66, 26, 338, 17);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CPF");
		lblNewLabel_1.setBounds(25, 53, 26, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(66, 51, 338, 17);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Data de nascimento");
		lblNewLabel_2.setBounds(25, 74, 100, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Endereço");
		lblNewLabel_3.setBounds(25, 94, 55, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(137, 72, 267, 17);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(86, 92, 318, 17);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Cadastro de Funcionários");
		lblNewLabel_4.setForeground(new Color(179, 0, 0));
		lblNewLabel_4.setBackground(new Color(0, 140, 0));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(25, 3, 254, 14);
		contentPane.add(lblNewLabel_4);
		
		tabelaFuncionarios = new JTable();
		tabelaFuncionarios.setForeground(new Color(0, 140, 0));
		tabelaFuncionarios.setFont(new Font("Tahoma", Font.BOLD, 12));
		tabelaFuncionarios.setModel(new DefaultTableModel(
			new Object[][] {
				{"Nome", "CPF", "Data de Nascimento", "Endere\u00E7o"},
			},
			new String[] {
				"Nome", "CPF", "Data de Nascimento", "Endere\u00E7o"
			}
		));
		tabelaFuncionarios.setColumnSelectionAllowed(true);
		tabelaFuncionarios.setCellSelectionEnabled(true);
		tabelaFuncionarios.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabelaFuncionarios.setBounds(25, 153, 379, 122);
		contentPane.add(tabelaFuncionarios);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Informações salvas! (Mentira)");
				System.exit(0);
			}
		});
		btnOk.setBounds(216, 277, 89, 23);
		contentPane.add(btnOk);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog(null, "");
				System.exit(0);
			}
		});
		btnCancelar.setBounds(315, 277, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				funcionario.adicionarFuncionario(textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText());
				String nome = textField.getText();
		        textField.setText("");
		        textField_1.setText("");
		        textField_2.setText("");
		        textField_3.setText("");
		        JOptionPane.showMessageDialog(null, "O funcionário "+nome+" foi adicionado com sucesso");
			
				DefaultTableModel modelo = (DefaultTableModel) tabelaFuncionarios.getModel();
		        modelo.setNumRows(1);
		        
		        for(Funcionario fr : f1) {
		        modelo.addRow(new Object[] {
		        	fr.getNome(),
		        	fr.getCpf(),
		        	fr.getDataNascimento(),
		        	fr.getEndereço()
		        });
			}
			}			
			
		});
		btnAdicionar.setBounds(25, 119, 77, 23);
		contentPane.add(btnAdicionar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				funcionario.removerFuncionario(textField_1.getText());
				String cpf = textField_1.getText();
				textField.setText("");
		        textField_1.setText("");
		        textField_2.setText("");
		        textField_3.setText("");
		        JOptionPane.showMessageDialog(null, "O funcionário com CPF: "+cpf+" foi removido com sucesso");
				
				DefaultTableModel modelo = (DefaultTableModel) tabelaFuncionarios.getModel();
		        modelo.setNumRows(1);
		        
		        for(Funcionario fr : f1) {
		        modelo.addRow(new Object[] {
		        	fr.getNome(),
		        	fr.getCpf(),
		        	fr.getDataNascimento(),
		        	fr.getEndereço()
		        });
			}
			}
		});
		btnRemover.setBounds(115, 120, 83, 23);
		contentPane.add(btnRemover);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				Funcionario funcionario1 = new Funcionario();
				
				funcionario1.setNome(textField.getText());
				funcionario1.setCpf(textField_1.getText());
				funcionario1.setDataNascimento(textField_2.getText());
				funcionario1.setEndereço(textField_3.getText());
				
				funcionario.atualizarFuncionario(funcionario1);
				
				String nome = textField.getText();
				String cpf = textField_1.getText();
				String dataNascimento = textField_2.getText();
				String endereco = textField_3.getText();
				
		        textField.setText("");
		        textField_1.setText("");
		        textField_2.setText("");
		        textField_3.setText("");
				
				JOptionPane.showMessageDialog(null, "Informações atualizadas:\n"+nome+"\n"+cpf+"\n" +dataNascimento+"\n"+endereco+"\n");
				
		        DefaultTableModel modelo = (DefaultTableModel) tabelaFuncionarios.getModel();
		        modelo.setNumRows(1);
		        
		        for(Funcionario fr : f1) {
		        modelo.addRow(new Object[] {
		        	fr.getNome(),
		        	fr.getCpf(),
		        	fr.getDataNascimento(),
		        	fr.getEndereço()
		        	});
		        }
			}
		});
		btnAtualizar.setBounds(214, 120, 91, 23);
		contentPane.add(btnAtualizar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Tentativa frustrada de gerar uma nova janela para a consulta do funcionario kkkkkkkk
				//ConsultaFrame frame = new ConsultaFrame();
				//frame.setVisible(true);

				funcionario.consultarFuncionario(textField_1.getText());
				
			}
		
		});
		btnConsultar.setBounds(315, 120, 89, 23);
		contentPane.add(btnConsultar);
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		
	}
}
