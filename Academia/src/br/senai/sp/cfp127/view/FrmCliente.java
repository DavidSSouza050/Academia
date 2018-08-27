package br.senai.sp.cfp127.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import br.senai.sp.cfp127.cliente.Cliente;
import java.awt.TextArea;
import java.awt.Toolkit;

public class FrmCliente extends JFrame{
	
	private JPanel painelTitulo;
	private JPanel painelDados;
	private TitledBorder bordaDados;
	private TitledBorder bordaResultado;
	private JPanel painelResultado;
	
	//Declaracoes dos labels da tela
	private JLabel lblTitulo,
				   lblIcone,
				   lblNome, 
				   lblNomeR,
				   lblNomeRl,
				   lblSexo,
				   lblPeso, 
				   lblPesoR,
				   lblPesoRl,
				   lblAltura, 
				   lblAlturaR, 
				   lblAlturaRl,
				   lblIdade,
				   lblIdadeR,
				   lblIdadeRl,
				   lblQuilos,
				   lblCm,
				   lblAnos,
				   lblNivelAtiv,
				   lblNivelAtivR,
				   lblNivelAtivRl,
				   lblImc,
				  // lblImcL,
				   lblTmb,
				   lblTmbL,
				   lblFcm,
				   lblFcmL;
	
	//Declaração dos campos de texto
	private JTextField txtNome,
					   txtPeso,
					   txtAltura,
					   txtIdade;
	
	// Declaração Dos Rádios
	private JRadioButton rdFeminino,
						 rdMasculino;
	
	//Declaração do combo
	private JComboBox cdAtividade;
	
	private Color cinza = new Color(195, 195, 195);
	private Color preto = new Color ( 0, 0, 0);
	private Font minhaFonte = new Font("Arial", 1 , 20);
	private ImageIcon iconeTitulo;
	private ImageIcon iconeCalc;
	
	private JButton btCalcular;
	private JScrollPane scroll;
	private JTextArea txtImcA;
	
	public FrmCliente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmCliente.class.getResource("/br/senai/sp/cfp127/imagens/gym32.png")));
		
		setTitle("Cadastro de Cliente");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 600);
		setResizable(false);
		getContentPane().setLayout(null);
		

		//** LABEL Titulo
		lblTitulo = new JLabel("Academia boa forma");
		lblTitulo.setBounds(50, 10 , 300, 30);
		lblTitulo.setFont(minhaFonte);
		
		//** Label Icone
		lblIcone = new JLabel("");
		lblIcone.setBounds(5, 5 , 40, 40);
		iconeTitulo = new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/cfp127/imagens/gym32.png"));
		lblIcone.setIcon(iconeTitulo);
		
		//** PAINEL TITULO
		painelTitulo = new JPanel();
		painelTitulo.setLayout(null);
		painelTitulo.setBackground(cinza);
		painelTitulo.setBounds(0, 0, 600, 50);
		//** Adicionando os elementos no painel
		painelTitulo.add(lblTitulo);
		painelTitulo.add(lblIcone);
		
		// Painel de dados
		painelDados = new JPanel();
		painelDados.setBackground(Color.WHITE);
		painelDados.setLayout(null); 
		painelDados.setBounds(10, 60, 285, 500);
		bordaDados = new TitledBorder("Dados do Cliente:");
		bordaDados.setTitleColor(preto);
		painelDados.setBorder(bordaDados);
		
		//**Nome
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(15, 40, 100, 20);
		
		txtNome = new JTextField();
		txtNome.setBounds(60, 35, 190, 30);
		
		//** grupoRadio junto do sexo
		ButtonGroup grupoRadio = new ButtonGroup();
		
		rdFeminino = new JRadioButton("Feminino");
		rdFeminino.setBackground(Color.WHITE);
		rdFeminino.setBounds(60 , 80, 90 ,30);
		
		rdMasculino = new JRadioButton("Masculino");
		rdMasculino.setBackground(Color.WHITE);
		rdMasculino.setBounds(150, 80, 100 ,30);
		grupoRadio.add(rdFeminino);
		grupoRadio.add(rdMasculino);
		
		//** Peso 
		lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(10, 120, 40, 28);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(61, 120, 60, 25);
		
		lblQuilos = new JLabel("Quilos");
		lblQuilos.setBounds(130, 120, 60, 28);
		

	
		//** Altura
		lblAltura = new JLabel("Altura:");
		lblAltura.setBounds(10, 155, 80, 30);
		
		txtAltura = new JTextField();
		txtAltura.setBounds(61, 155, 60, 25);
		
		lblCm = new JLabel("cm");
		lblCm.setBounds(130, 155, 60, 25);
		
		//** Idade
		lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(10, 190, 40, 20);
		
		txtIdade = new JTextField();
		txtIdade.setBounds(61, 190, 60, 24);
		
		lblAnos = new JLabel("Anos");
		lblAnos.setBounds(130, 190, 60, 24);

		
			

		
		//Nivel de atividade
		
		lblNivelAtiv = new JLabel("Nivel de Atividade:");
		lblNivelAtiv.setBounds(15, 280, 105, 20);
		
		String[] nivelAtividade = {"Sedentário","Levemente Ativo","Moderadamente ativo", "Bastante ativo", "Muito ativo" };
		System.out.println(nivelAtividade[4]);
		
		cdAtividade = new JComboBox(nivelAtividade);
		cdAtividade.setBounds(30, 311, 200, 30);
		
		btCalcular = new JButton("Calcular");
		btCalcular.setBounds(60, 379, 140, 40);
		iconeCalc = new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/cfp127/imagens/calc24.png"));
		btCalcular.setIcon(iconeCalc);

		

		
		painelDados.add(lblNome);
		painelDados.add(txtNome);
		painelDados.add(rdFeminino);
		painelDados.add(rdMasculino);
		painelDados.add(lblPeso);
		painelDados.add(txtPeso);
		painelDados.add(lblQuilos);
		painelDados.add(lblAltura);
		painelDados.add(txtAltura);
		painelDados.add(lblCm);
		painelDados.add(lblNivelAtiv);
		painelDados.add(cdAtividade);
		painelDados.add(btCalcular);
		painelDados.add(lblIdade);
		painelDados.add(txtIdade);
		painelDados.add(lblAnos);



		//** Painel de resultado
		painelResultado = new JPanel();
		painelResultado.setBackground(Color.WHITE);
		painelResultado.setLayout(null); 
		painelResultado.setBounds(299, 61, 285, 500);
		bordaResultado = new TitledBorder("Resultados do Cliente:");
		bordaResultado.setTitleColor(preto);
		painelResultado.setBorder(bordaResultado);
		
		//Nome
		lblNomeR = new JLabel("Nome:");
		lblNomeR.setBounds(32, 40, 45, 20);
		
		lblNomeRl = new JLabel("");
		lblNomeRl.setBounds(79, 40, 178, 20);

		
		//**	Idade
		lblIdadeR = new JLabel("Idade:");
		lblIdadeR.setBounds(32, 83, 45, 20);
		
		lblIdadeRl = new JLabel("");
		lblIdadeRl.setBounds(79, 83, 91, 20);
		
		//Altura
		
		lblAlturaR = new JLabel ("Altura:");
		lblAlturaR.setBounds(32, 114, 47, 20);
		
		lblAlturaRl = new JLabel ("");
		lblAlturaRl.setBounds(80, 114, 90, 20);
		
		
		// Peso
		
		lblPesoR = new JLabel ("Peso:");
		lblPesoR.setBounds(32, 145, 47, 20);
		
		lblPesoRl = new JLabel ("");
		lblPesoRl.setBounds(66, 145, 91, 20);
		
		//Nível de ativida 
		
		lblNivelAtivR = new JLabel("Nível de atividade:", JLabel.RIGHT);
		lblNivelAtivR.setBounds(10, 190, 110, 20);
		
		lblNivelAtivRl = new JLabel("", JLabel.LEFT);
		lblNivelAtivRl.setBounds(131, 190, 115, 20);
		
		//* Imc
		lblImc = new JLabel("IMC:", JLabel.RIGHT);
		lblImc.setBounds(10, 236, 47, 20);
		
		
		
		//** TMB
		
		lblTmb = new JLabel("TMB:", JLabel.RIGHT); 
		lblTmb.setBounds(30, 340, 47, 20);
		
		lblTmbL = new JLabel("", JLabel.LEFT);
		lblTmbL.setBounds(87, 340, 132, 20);
		
		
		//** FCM
		lblFcm = new JLabel("FCM:", JLabel.RIGHT); 
		lblFcm.setBounds(32, 383, 47, 20);
		
		lblFcmL = new JLabel("", JLabel.LEFT);
		lblFcmL.setBounds(85, 383, 110, 20);
		
		painelResultado.add(lblNomeR);
		painelResultado.add(lblNomeRl);
		painelResultado.add(lblIdadeR);
		painelResultado.add(lblIdadeRl);
		painelResultado.add(lblAlturaR);
		painelResultado.add(lblAlturaRl);
		painelResultado.add(lblPesoR);
		painelResultado.add(lblPesoRl);
		painelResultado.add(lblNivelAtivR);
		painelResultado.add(lblNivelAtivRl);
		painelResultado.add(lblImc);
		painelResultado.add(lblTmb);
		painelResultado.add(lblTmbL);
		painelResultado.add(lblFcm);
		painelResultado.add(lblFcmL);
		
		getContentPane().add(painelTitulo);
		getContentPane().add(painelDados);
		
		//** Sexo
		lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(15, 80, 45, 30);
		painelDados.add(lblSexo);
		getContentPane().add(painelResultado);
		
		scroll = new JScrollPane();
		scroll.setBounds(69, 233, 206, 83);
		painelResultado.add(scroll);
		
		txtImcA = new JTextArea();
		txtImcA.setWrapStyleWord(true);
		txtImcA.setLineWrap(true);
		txtImcA.setEditable(false);
		scroll.setViewportView(txtImcA);
		
		btCalcular.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente();
				cliente.setNome(txtNome.getText());
				cliente.setPeso(Double.parseDouble(txtPeso.getText()));
				cliente.setAltura(Double.parseDouble(txtAltura.getText()));
				cliente.setIdade(Integer.parseInt(txtIdade.getText()));
				cliente.setNivelAtividade(cdAtividade.getSelectedIndex()+1);
				
				if(rdFeminino.isSelected()) {
					cliente.setSexo('F');
				}else if (rdMasculino.isSelected()) {
					cliente.setSexo('M');
					
				}else {
					JOptionPane.showMessageDialog(null, "Para de ser burro");
				}
				
				lblPesoRl.setText(String.valueOf(cliente.getPeso()));
				lblAlturaRl.setText(String.valueOf(cliente.getAltura()));
				lblIdadeRl.setText(String.valueOf(cliente.getIdade()));
				lblNomeRl.setText(cliente.getNome());
				lblNivelAtivRl.setText(String.valueOf(cdAtividade.getSelectedIndex() + 1 ));
				txtImcA.setText(cliente.getImc());
				lblTmbL.setText(String.valueOf(cliente.getTmb()));
				lblFcmL.setText(String.valueOf(cliente.getFcm()));
			}
		});
		
		setVisible(true);

	}
	
}
