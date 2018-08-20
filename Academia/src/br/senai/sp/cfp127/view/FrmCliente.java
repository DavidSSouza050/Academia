package br.senai.sp.cfp127.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.TitledBorder;

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
				   lblSexo,
				   lblPeso, 
				   lblAltura, 
				   lblIdade,
				   lblQuilos,
				   lblCm,
				   lblAnos;
	
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
	
	public FrmCliente() {
		
		setTitle("Cadastro de Cliente");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 600);
		setResizable(false);
		setLayout(null);
		

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
		painelDados.setLayout(null); 
		painelDados.setBounds(10, 60, 285, 500);
		bordaDados = new TitledBorder("Dados do Cliente:");
		bordaDados.setTitleColor(preto);
		painelDados.setBorder(bordaDados);
		
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 30, 100, 20);
		
		txtNome = new JTextField();
		txtNome.setBounds(60, 30, 200, 30);

		lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(10 , 60, 200 , 30);
		
		//** grupoRadio
		ButtonGroup grupoRadio = new ButtonGroup();
		
		rdFeminino = new JRadioButton("Feminino");
		rdFeminino.setBounds(60 , 60, 90 ,30);
		
		rdMasculino = new JRadioButton("Masculino");
		rdMasculino.setBounds(150, 60, 100 ,30);
		grupoRadio.add(rdFeminino);
		grupoRadio.add(rdMasculino);
		
		//** Peso 
		lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(10, 90, 80, 30);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(60, 95, 60, 28);
		
		lblQuilos = new JLabel("Quilos");
		lblQuilos.setBounds(130, 95, 60, 28);
		
		//Nivel de Atividade
	
		//** Altura
		lblAltura = new JLabel("Alutura:");
		lblAltura.setBounds(10, 125, 80, 30);
		
		txtAltura = new JTextField();
		txtAltura.setBounds(60, 130, 60, 25);
		
		lblCm = new JLabel("Cm");
		lblCm.setBounds(130, 130, 60, 25);

		
		//Nivel de atividade
		String[] nivelAtividade = {"Sedentário","Levemente Ativo"," Moderadamente ativo", "Bastante ativo", "Muito ativo" };
		System.out.println(nivelAtividade[4]);
		
		cdAtividade = new JComboBox(nivelAtividade);
		cdAtividade.setBounds(10, 300, 180, 30);
		
		btCalcular = new JButton("Calcular");
		btCalcular.setBounds(25, 350, 140, 40);
		iconeCalc = new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/cfp127/imagens/calc24.png"));
		btCalcular.setIcon(iconeCalc);



		
		painelDados.add(lblNome);
		painelDados.add(txtNome);
		painelDados.add(lblSexo);
		painelDados.add(rdFeminino);
		painelDados.add(rdMasculino);
		painelDados.add(lblPeso);
		painelDados.add(txtPeso);
		painelDados.add(lblQuilos);
		painelDados.add(lblAltura);
		painelDados.add(txtAltura);
		painelDados.add(lblCm);
		painelDados.add(cdAtividade);
		painelDados.add(btCalcular);

		
		//** Painel de resultado
		painelResultado = new JPanel();
		painelResultado.setLayout(null); 
		painelResultado.setBounds(300, 60, 285, 500);
		bordaResultado = new TitledBorder("Resultados do Cliente:");
		bordaResultado.setTitleColor(preto);
		painelResultado.setBorder(bordaResultado);
	
		
		
		
		
		getContentPane().add(painelTitulo);
		getContentPane().add(painelDados);
		getContentPane().add(painelResultado);
		setVisible(true);

	}
	
}
