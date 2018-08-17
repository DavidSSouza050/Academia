package br.senai.sp.cfp127.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class FrmCliente extends JFrame{
	
	private JPanel painelTitulo;
	private JLabel lblTitulo;
	private JLabel lblIcone;
	private Color cinza = new Color(201, 201, 201);
	private Font minhaFonte = new Font("Arial", 1 , 20);
	
	
	public FrmCliente() {
		
		setTitle("Cadastro de Cliente");
		setSize(500, 500);
		setResizable(false);
		setLayout(null);
		
	
		//** LABEL Titulo
		lblTitulo = new JLabel("Academia boa forma");
		lblTitulo.setBounds(50, 10 , 150, 30);
		lblTitulo.setFont(minhaFonte);	
		
		//** PAINEL TITULO
		painelTitulo = new JPanel();
		painelTitulo.setBackground(cinza);
		painelTitulo.add(lblTitulo);
		painelTitulo.setBounds(0, 0, 600, 50);
		painelTitulo.setLayout(null);
		
		
		
		
		getContentPane().add(painelTitulo);
		setVisible(true);

	}
	
}
