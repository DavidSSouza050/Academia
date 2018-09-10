package br.senai.sp.cfp127.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.senai.sp.cfp127.dao.FuncionarioDAO;
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
		txtId.setBounds(10, 37, 32, 29);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(10, 100, 209, 29);
		contentPane.add(txtNome);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(11, 164, 125, 29);
		contentPane.add(txtEmail);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(146, 164, 86, 29);
		contentPane.add(txtCidade);
		
		txtUf = new JTextField();
		txtUf.setColumns(10);
		txtUf.setBounds(242, 164, 39, 29);
		contentPane.add(txtUf);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(10, 24, 15, 14);
		contentPane.add(lblId);
		
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 85, 63, 14);
		contentPane.add(lblNome);
		
		lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(11, 150, 39, 14);
		contentPane.add(lblEmail);
		
		lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(146, 150, 63, 14);
		contentPane.add(lblCidade);
		
		lblUf = new JLabel("UF:");
		lblUf.setBounds(242, 150, 35, 14);
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
		
		JButton btnExcluir = new JButton("Excluir");
	
		btnExcluir.setBounds(213, 226, 89, 43);
		contentPane.add(btnExcluir);
		
		JButton btnBuscar = new JButton("Buscar");
		
		btnBuscar.setBounds(66, 37, 89, 29);
		contentPane.add(btnBuscar);
		
		JButton btnNovo = new JButton("Novo");
	
		btnNovo.setBounds(192, 37, 89, 29);
		
		//**** LISTENERS DOS BOTÕES
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				criarFuncionario("S");
			}
		});
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				FuncionarioDAO dao = new FuncionarioDAO();
				Funcionario funcionario = dao.getFuncionario(Integer.parseInt(txtId.getText()));
				txtNome.setText(funcionario.getNome());
				txtEmail.setText(funcionario.getEmail());
				txtCidade.setText(funcionario.getCidade());
				txtUf.setText(funcionario.getUf());
			}
		});
		
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
				
				if(btnNovo.getText().equals("Cancelar")) {
					btnNovo.setText("Novo");
					btnAtualizar.setEnabled(true);
					btnExcluir.setEnabled(true);
					txtId.setEnabled(true);
					btnBuscar.setEnabled(true);
					btnSalvar.setEnabled(false);
					txtId.requestFocus();
				}else {
					btnNovo.setText("Cancelar");
					btnAtualizar.setEnabled(false);
					btnExcluir.setEnabled(false);
					txtId.setEnabled(false);
					btnBuscar.setEnabled(false);
					btnSalvar.setEnabled(true);
					txtNome.requestFocus();
				}
			}
		});
		
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				criarFuncionario("A");
			}
		});
		
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtId.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Por favor selecione o Usuario?");
				}else {
				
				
				int resposta = JOptionPane.showConfirmDialog(null, "Confirma a exclusão do registro?");
				
				if(resposta == 0) {
					criarFuncionario("E");
				}
					limparCampos();
				}
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

	private void criarFuncionario(String operacao) {
		
		Funcionario funcionario = new Funcionario();
		funcionario.setNome(txtNome.getText());
		funcionario.setCidade(txtCidade.getText());
		funcionario.setUf(txtUf.getText());
		funcionario.setEmail(txtEmail.getText());
		
		
		FuncionarioDAO dao = new FuncionarioDAO(funcionario);
		
		if(operacao.equals("S")) {
			dao.salvar();
		}else if(operacao.equals("A")) {
			funcionario.setId(Integer.parseInt(txtId.getText()));
			dao.atualizar();
		}else {
			funcionario.setId(Integer.parseInt(txtId.getText()));
			dao.excluir();
		}
	}
	
}
