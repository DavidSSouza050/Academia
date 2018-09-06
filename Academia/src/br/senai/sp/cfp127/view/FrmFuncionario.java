package br.senai.sp.cfp127.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.senai.sp.cfp127.dbutils.Conexao;
import br.senai.sp.cfp127.modelo.Funcionario;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class FrmFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtCidade;
	private JTextField txtUf;
	private JLabel lblNome;
	private JLabel lblEmail;
	private JLabel lblCidade;
	private JLabel lblUf;

	public FrmFuncionario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 333, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtId = new JTextField();
		txtId.setBounds(10, 59, 32, 29);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(10, 105, 209, 29);
		contentPane.add(txtNome);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(10, 171, 125, 29);
		contentPane.add(txtEmail);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(145, 171, 86, 29);
		contentPane.add(txtCidade);
		
		txtUf = new JTextField();
		txtUf.setColumns(10);
		txtUf.setBounds(241, 171, 39, 29);
		contentPane.add(txtUf);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(10, 44, 15, 14);
		contentPane.add(lblId);
		
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 90, 63, 14);
		contentPane.add(lblNome);
		
		lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(10, 157, 39, 14);
		contentPane.add(lblEmail);
		
		lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(145, 157, 63, 14);
		contentPane.add(lblCidade);
		
		lblUf = new JLabel("UF:");
		lblUf.setBounds(241, 157, 35, 14);
		contentPane.add(lblUf);
		
		JButton btnSalvar = new JButton("Salvar");
		
		btnSalvar.setBounds(10, 226, 89, 43);
		contentPane.add(btnSalvar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAtualizar.setBounds(109, 226, 89, 43);
		contentPane.add(btnAtualizar);
		
		JButton btnExibir = new JButton("Exibir");
		btnExibir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExibir.setBounds(213, 226, 89, 43);
		contentPane.add(btnExibir);
		
		JButton btnBuscar = new JButton("Buscar");
		
		btnBuscar.setBounds(59, 55, 89, 29);
		contentPane.add(btnBuscar);
		
		JButton btnNovo = new JButton("Novo");
	
		btnNovo.setBounds(191, 59, 89, 29);
		
		//**** LISTENERS DOS BOTÕES
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Funcionario funcionario = new Funcionario();
				funcionario.setNome(txtNome.getText());
				funcionario.setCidade(txtCidade.getText());
				funcionario.setUf(txtUf.getText());
				funcionario.setEmail(txtEmail.getText());
				
				
				try {
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
					Connection con = DriverManager.getConnection("jdbc:ucanaccess://Z://SegundoTermo//Git/Academia.accdb");
					
					String sql ="INSERT INTO funcionario (nome, email, cidade, uf) "
							+ "VALUES (?, ?, ?, ?)";
				
					PreparedStatement stm =  con.prepareStatement(sql);
					stm.setString(1, txtNome.getText());
					stm.setString(2, txtEmail.getText());
					stm.setString(3, txtCidade.getText());
					stm.setString(4, txtUf.getText());
					
					if (!stm.execute()) {
						JOptionPane.showMessageDialog(null, "Registro Gravado com Sucesso! ");
						limparCampos();
					}else {
						JOptionPane.showMessageDialog(null, "Ocorreu um erro na Gravação!");
					}
					
				} catch(Exception erro) {
						erro.getMessage();
				}

			}
		});
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					String consulta ="SELECT * FROM funcionario WHERE id = ?";
				
					PreparedStatement stm =  Conexao.getConexao().prepareStatement(consulta);
					stm.setInt(1, Integer.parseInt(txtId.getText()));
					
					ResultSet rs ;
					
					rs = stm.executeQuery();
					
				if	(rs.next()) {
					txtNome.setText(rs.getString("nome"));
					txtEmail.setText(rs.getString("email"));
					txtCidade.setText(rs.getString("cidade"));
					txtUf.setText(rs.getString("uf"));
				} else {
					limparCampos();
					JOptionPane.showMessageDialog(null,"Registro não encontrado");
				}
					
				} catch(Exception erro) {
						erro.getMessage();
					}
				
			}
		});
		
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
				txtNome.requestFocus();
			}
		});
		
		
		
		contentPane.add(btnNovo);
	}
	
	private void limparCampos() {
		txtNome.setText("");
		txtEmail.setText("");
		txtCidade.setText("");
		txtUf.setText("");
		txtId.setText("");
	}

	
	
}
