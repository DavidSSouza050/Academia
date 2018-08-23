package br.senai.sp.cfp127.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import br.senai.sp.cfp127.cliente.Cliente;

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
				   lblImcL,
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
		
		//**Nome
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 30, 100, 20);
		
		txtNome = new JTextField();
		txtNome.setBounds(60, 30, 200, 30);
		
		//** Sexo
		lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(10 , 60, 200 , 30);
		
		//** grupoRadio junto do sexo
		ButtonGroup grupoRadio = new ButtonGroup();
		
		rdFeminino = new JRadioButton("Feminino");
		rdFeminino.setBounds(60 , 60, 90 ,30);
		
		rdMasculino = new JRadioButton("Masculino");
		rdMasculino.setBounds(150, 60, 100 ,30);
		grupoRadio.add(rdFeminino);
		grupoRadio.add(rdMasculino);
		
		//** Peso 
		lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(10, 96, 40, 28);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(61, 98, 60, 25);
		
		lblQuilos = new JLabel("Quilos");
		lblQuilos.setBounds(130, 96, 60, 28);
		

	
		//** Altura
		lblAltura = new JLabel("Altura:");
		lblAltura.setBounds(10, 125, 80, 30);
		
		txtAltura = new JTextField();
		txtAltura.setBounds(61, 130, 60, 25);
		
		lblCm = new JLabel("cm");
		lblCm.setBounds(130, 130, 60, 25);
		
		//** Idade
		lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(10, 160, 40, 20);
		
		txtIdade = new JTextField();
		txtIdade.setBounds(61, 160, 60, 24);
		
		lblAnos = new JLabel("Anos");
		lblAnos.setBounds(130, 160, 60, 24);

		
			

		
		//Nivel de atividade
		
		lblNivelAtiv = new JLabel("Nivel de Atividade:");
		lblNivelAtiv.setBounds(10, 220, 105, 20);
		
		String[] nivelAtividade = {"Sedentário","Levemente Ativo","Moderadamente ativo", "Bastante ativo", "Muito ativo" };
		System.out.println(nivelAtividade[4]);
		
		cdAtividade = new JComboBox(nivelAtividade);
		cdAtividade.setBounds(10, 250, 180, 30);
		
		btCalcular = new JButton("Calcular");
		btCalcular.setBounds(25, 300, 140, 40);
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
		painelDados.add(lblNivelAtiv);
		painelDados.add(cdAtividade);
		painelDados.add(btCalcular);
		painelDados.add(lblIdade);
		painelDados.add(txtIdade);
		painelDados.add(lblAnos);



		//** Painel de resultado
		painelResultado = new JPanel();
		painelResultado.setLayout(null); 
		painelResultado.setBounds(300, 60, 285, 500);
		bordaResultado = new TitledBorder("Resultados do Cliente:");
		bordaResultado.setTitleColor(preto);
		painelResultado.setBorder(bordaResultado);
		
		//Nome
		lblNomeR = new JLabel("Nome:");
		lblNomeR.setBounds(50, 30, 85, 20);
		
		lblNomeRl = new JLabel("Maria");
		lblNomeRl.setBounds(96, 30, 200, 20);

		
		//**	Idade
		lblIdadeR = new JLabel("Idade:");
		lblIdadeR.setBounds(50, 60, 85, 20);
		
		lblIdadeRl = new JLabel("54" + " anos");
		lblIdadeRl.setBounds(96, 60, 100, 20);
		
		//Altura
		
		lblAlturaR = new JLabel ("Altura:");
		lblAlturaR.setBounds(50, 90, 85, 20);
		
		lblAlturaRl = new JLabel ("150" + " cm");
		lblAlturaRl.setBounds(96, 90, 100, 20);
		
		
		// Peso
		
		lblPesoR = new JLabel ("Peso:");
		lblPesoR.setBounds(50, 120, 85, 20);
		
		lblPesoRl = new JLabel ("64" + " Quilos");
		lblPesoRl.setBounds(96, 120, 100, 20);
		
		//Nível de ativida 
		
		lblNivelAtivR = new JLabel("Nível de atividade:", JLabel.RIGHT);
		lblNivelAtivR.setBounds(15, 150, 110, 20);
		
		lblNivelAtivRl = new JLabel("Sedentario", JLabel.LEFT);
		lblNivelAtivRl.setBounds(130, 150, 115, 20);
		
		//* Imc
		lblImc = new JLabel("IMC:", JLabel.RIGHT);
		lblImc.setBounds(15, 180, 65, 20);
		
		lblImcL = new JLabel("29,8" + " Kg/m²", JLabel.LEFT);
		lblImcL.setBounds(99, 180, 85, 20);
		
		
		
		//** TMB
		
		lblTmb = new JLabel("TMB:", JLabel.RIGHT); 
		lblTmb.setBounds(15, 250, 65, 20);
		
		lblTmbL = new JLabel("1555", JLabel.LEFT);
		lblTmbL.setBounds(99, 250, 85, 20);
		
		
		//** FCM
		lblFcm = new JLabel("FCM:", JLabel.RIGHT); 
		lblFcm.setBounds(15, 280, 65, 20);
		
		lblFcmL = new JLabel("25104", JLabel.LEFT);
		lblFcmL.setBounds(99, 280, 85, 20);
		
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
		painelResultado.add(lblImcL);
		painelResultado.add(lblTmb);
		painelResultado.add(lblTmbL);
		painelResultado.add(lblFcm);
		painelResultado.add(lblFcmL);
		
		getContentPane().add(painelTitulo);
		getContentPane().add(painelDados);
		getContentPane().add(painelResultado);
		
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
				lblImcL.setText(cliente.getImc());
				lblTmbL.setText(String.valueOf(cliente.getTmb()));
				lblFcmL.setText(String.valueOf(cliente.getFcm()));
			}
		});
		
		setVisible(true);

	}
	
}
