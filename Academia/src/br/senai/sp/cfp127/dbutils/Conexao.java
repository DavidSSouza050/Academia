package br.senai.sp.cfp127.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class Conexao {

	private static Connection con;
	
	public static Connection getConexao() {

		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			con = DriverManager.getConnection("jdbc:ucanaccess://Z://SegundoTermo//Git/Academia.accdb");
			
		} catch(Exception erro) {
				erro.getMessage();
			}
		return con;
	}
	
}