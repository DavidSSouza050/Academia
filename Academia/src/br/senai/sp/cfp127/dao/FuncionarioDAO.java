package br.senai.sp.cfp127.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.senai.sp.cfp127.modelo.Funcionario;
import br.senai.sp.cfp127.dbutils.Conexao;

public class FuncionarioDAO {
	
	private Funcionario funcionario;
	
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public FuncionarioDAO(Funcionario funcionario) {
		this.funcionario = funcionario;	
	}
	public FuncionarioDAO(){}
	
	public Funcionario getFuncionario(int id) {

		try {
			
			String consulta ="SELECT * FROM funcionario WHERE id = ?";
		
			PreparedStatement stm =  Conexao.getConexao().prepareStatement(consulta);
			stm.setInt(1, id);
			ResultSet rs ;
			
			rs = stm.executeQuery();
			
		if	(rs.next()) {
			funcionario = new Funcionario();
			this.funcionario.setNome(rs.getString("nome"));
			this.funcionario.setEmail(rs.getString("email"));
			this.funcionario.setCidade(rs.getString("cidade"));
			this.funcionario.setUf(rs.getString("uf"));
			this.funcionario.setId(rs.getInt("id"));
			
		} else {

			JOptionPane.showMessageDialog(null,"Registro não encontrado");
		}
			
		} catch(Exception erro) {
				erro.printStackTrace();
		}
		return funcionario;
	}
	
	public ArrayList<Funcionario> getFuncionarios() {
		
		ArrayList<Funcionario> funcionarios = new ArrayList<>();

		try {
			
			String consulta ="SELECT * FROM funcionario ORDER BY id";
		
			PreparedStatement stm =  Conexao.getConexao().prepareStatement(consulta);
			
			ResultSet rs ;
			
			rs = stm.executeQuery();
			
			while	(rs.next()) {
				funcionario = new Funcionario();
				this.funcionario.setNome(rs.getString("nome"));
				this.funcionario.setEmail(rs.getString("email"));
				this.funcionario.setCidade(rs.getString("cidade"));
				this.funcionario.setUf(rs.getString("uf"));
				this.funcionario.setId(rs.getInt("id"));
				
				funcionarios.add(funcionario);
			
			}
			
		} catch(Exception erro) {
				erro.printStackTrace();
		}
		return funcionarios;
	}
	
	public void salvar(){
		try {
			
			String sql ="INSERT INTO funcionario (nome, email, cidade, uf) "
					+ "VALUES (?, ?, ?, ?)";
		
			PreparedStatement stm =   Conexao.getConexao().prepareStatement(sql);
			stm.setString(1, this.funcionario.getNome());
			stm.setString(2,  this.funcionario.getEmail());
			stm.setString(3,  this.funcionario.getCidade());
			stm.setString(4,  this.funcionario.getUf());
			
			if (!stm.execute()) {
				JOptionPane.showMessageDialog(null, "Registro Gravado com Sucesso! ");
			}else {
				JOptionPane.showMessageDialog(null, "Ocorreu um erro na Gravação!");
			}
			
		} catch(Exception erro) {
				erro.getMessage();
		}
	}
	
	public void atualizar() {
		try {
			
			
			String sql ="UPDATE funcionario SET nome=?, email=?, cidade=?,uf=? 	WHERE id=? ";
		
			PreparedStatement stm =   Conexao.getConexao().prepareStatement(sql);
			stm.setString(1, this.funcionario.getNome());
			stm.setString(2, this.funcionario.getEmail());
			stm.setString(3, this.funcionario.getCidade());
			stm.setString(4, this.funcionario.getUf());
			stm.setInt(5, this.funcionario.getId());
			
			if (!stm.execute()) {
				JOptionPane.showMessageDialog(null, "Registro Atualizado com Sucesso! ");
			}else {
				JOptionPane.showMessageDialog(null, "Ocorreu um erro na Atualização!");
			}
			
		} catch(Exception erro) {
				erro.getMessage();
		}
		
	}

	public void excluir() {
		try {
			
			String sql ="DELETE FROM funcionario WHERE id=?";
			PreparedStatement stm = Conexao.getConexao().prepareStatement(sql);
			stm.setInt(1, this.funcionario.getId());
			
			if (!stm.execute()) {
				JOptionPane.showMessageDialog(null, "Registro Excluido com Sucesso! ");
			}else {
				JOptionPane.showMessageDialog(null, "Ocorreu um erro na Exclusão!");
			}
			
		} catch(Exception erro) {
				erro.getMessage();
		}
		
	}
			
}
