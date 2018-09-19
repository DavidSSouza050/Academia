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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

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
	private JPanel panelDetalhes;
	private JPanel panelTabela;
	private JTable tableFuncionario;

	public FrmFuncionario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 471, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		///**** AQUI COMEÇA A TABELA
		
		
		FuncionarioDAO dao = new FuncionarioDAO();
		ArrayList<Funcionario> funcionarios = dao.getFuncionarios();
		
		String[] colunas = {"Codigo", "Nome do funcionario"};
		
		String[][] dados = new String[dao.getFuncionarios().size()][2] ;

		for (int i=0; i < dao.getFuncionarios().size(); i++) {
			dados[i][0] = String.valueOf(dao.getFuncionarios().get(i).getId());
			dados[i][1] = dao.getFuncionarios().get(i).getNome();
			
		}
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 11, 445, 360);
		contentPane.add(tabbedPane);
		
		panelTabela = new JPanel();
		tabbedPane.addTab("New tab", null, panelTabela, null);
		panelTabela.setBorder(new TitledBorder(null, "Lista de Funcionarios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTabela.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 51, 380, 201);
		panelTabela.add(scrollPane);
		
		tableFuncionario = new JTable(dados, colunas);
		scrollPane.setViewportView(tableFuncionario);
		//** A tabela termina aqui
		
		panelDetalhes = new JPanel();
		tabbedPane.addTab("New tab", null, panelDetalhes, null);
		panelDetalhes.setBorder(new TitledBorder(null, "Detalhes do Funcionario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDetalhes.setLayout(null);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(265, 265, 89, 43);
		panelDetalhes.add(btnExcluir);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(161, 265, 89, 43);
		panelDetalhes.add(btnAtualizar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setEnabled(false);
		btnSalvar.setBounds(62, 265, 89, 43);
		panelDetalhes.add(btnSalvar);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(10, 205, 161, 29);
		panelDetalhes.add(txtEmail);
		txtEmail.setColumns(10);
		
		lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(10, 191, 39, 14);
		panelDetalhes.add(lblEmail);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(181, 205, 173, 29);
		panelDetalhes.add(txtCidade);
		txtCidade.setColumns(10);
		
		lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(187, 191, 63, 14);
		panelDetalhes.add(lblCidade);
		
		txtUf = new JTextField();
		txtUf.setBounds(373, 205, 39, 29);
		panelDetalhes.add(txtUf);
		txtUf.setColumns(10);
		
		lblUf = new JLabel("UF:");
		lblUf.setBounds(373, 191, 35, 14);
		panelDetalhes.add(lblUf);
		
		txtNome = new JTextField();
		txtNome.setBounds(11, 131, 335, 29);
		panelDetalhes.add(txtNome);
		txtNome.setColumns(10);
		
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 116, 63, 14);
		panelDetalhes.add(lblNome);
		
		txtId = new JTextField();
		txtId.setBounds(10, 61, 32, 29);
		panelDetalhes.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(10, 48, 15, 14);
		panelDetalhes.add(lblId);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(92, 61, 89, 29);
		panelDetalhes.add(btnBuscar);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setBounds(218, 61, 89, 29);
		panelDetalhes.add(btnNovo);
		
		
		
		
		//*** LISTENERS DOS BOTÕES
		
		
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
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				exibirFuncionario(Integer.parseInt(txtId.getText()));
			}
		});
		
	
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				criarFuncionario("S");
			}
		});
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
					JOptionPane.showMessageDialog(null, "Por favor selecione o Usuario");
				}else {
				
				
				int resposta = JOptionPane.showConfirmDialog(null, "Confirma a exclusão do registro?");
				
				if(resposta == 0) {
					criarFuncionario("E");
				}
					limparCampos();
				}
			}
		});
		
		tableFuncionario.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int linha = tableFuncionario.getSelectedRow();
				String id = tableFuncionario.getValueAt(linha, 0).toString();
				exibirFuncionario(Integer.parseInt(id));
				tabbedPane.setSelectedIndex(1);
				
			}
		});;
		
	}
	
	public void exibirFuncionario(int id) {
		FuncionarioDAO dao = new FuncionarioDAO();
		Funcionario funcionario = dao.getFuncionario(id);
		txtNome.setText(funcionario.getNome());
		txtEmail.setText(funcionario.getEmail());
		txtCidade.setText(funcionario.getCidade());
		txtUf.setText(funcionario.getUf());
		txtId.setText(String.valueOf(funcionario.getId()));
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
