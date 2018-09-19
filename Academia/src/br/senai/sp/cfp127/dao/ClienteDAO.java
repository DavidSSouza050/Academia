package br.senai.sp.cfp127.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import br.senai.sp.cfp127.cliente.Cliente;
import br.senai.sp.cfp127.dbutils.Conexao;
import br.senai.sp.cfp127.modelo.Funcionario;

public class ClienteDAO {
private Cliente cliente;
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public ClienteDAO(Cliente cliente) {
		this.cliente = cliente;	
	}
	public ClienteDAO(){}
	
	
	
	public Cliente getCliente(int codigoCliente) {
		
		try {
			
			String consulta ="SELECT * FROM cliente WHERE codigoCliente=?";
		
			PreparedStatement stm =  Conexao.getConexao().prepareStatement(consulta);
			stm.setInt(1, codigoCliente);
			
			ResultSet rs ;
			
			rs = stm.executeQuery();
			
		if	(rs.next()) {
			cliente = new Cliente();
			this.cliente.setCodigoCliente(rs.getInt("codigoCliente"));
			this.cliente.setNome(rs.getString("nome"));
			//this.cliente.setIdade(rs.getInt("dataNascimento"));
			this.cliente.setPeso(rs.getDouble("peso"));
			this.cliente.setAltura(rs.getDouble("altura"));
			this.cliente.setSexo(rs.getString("sexo").charAt(0));
			this.cliente.setLogradouro(rs.getString("logradouro"));
			this.cliente.setBairro(rs.getString("bairro"));
			this.cliente.setNivelAtividade(rs.getInt("nivelAtividade"));
			this.cliente.setEmail(rs.getString("email"));
			this.cliente.setCidade(rs.getString("cidade"));
			this.cliente.setTelefone(rs.getString("telefone"));
			
		} else {

			JOptionPane.showMessageDialog(null,"Registro não encontrado");
		}
			
		} catch(Exception erro) {
				erro.printStackTrace();
		}
		return cliente;
	}
	
	
	
	public ArrayList<Cliente> getClientes() {
		
		ArrayList<Cliente> clientes= new ArrayList<>();

		try {
			
			String consulta ="SELECT * FROM cliente ORDER BY codigoCliente";
		
			PreparedStatement stm =  Conexao.getConexao().prepareStatement(consulta);
			
			ResultSet rs ;
			
			rs = stm.executeQuery();
			
			while	(rs.next()) {
				cliente = new Cliente();
				this.cliente.setCodigoCliente(rs.getInt("codigoCliente"));
				this.cliente.setNome(rs.getString("nome"));
		//		this.cliente.setIdade(rs.getString("dataNacimento"));
				this.cliente.setPeso(rs.getDouble("peso"));
				this.cliente.setAltura(rs.getDouble("altura"));
				this.cliente.setSexo(rs.getString("sexo").charAt(0));
				this.cliente.setLogradouro(rs.getString("logradouro"));
				this.cliente.setBairro(rs.getString("bairro"));
				this.cliente.setNivelAtividade(rs.getInt("nivelAtividade"));
				this.cliente.setEmail(rs.getString("email"));
				this.cliente.setCidade(rs.getString("cidade"));
				this.cliente.setTelefone(rs.getString("telefone"));
				
				clientes.add(cliente);
			
			}
			
		} catch(Exception erro) {
				erro.printStackTrace();
		}
		return clientes;
	}
	
	
	
	
	
	
	public void salvar(){
		try {
			
			String sql ="INSERT INTO cliente (nome, peso, altura, sexo,"
					+ " nivelAtividade, logradouro, bairro, cidade, telefone,"
					+ "email ) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
			PreparedStatement stm =   Conexao.getConexao().prepareStatement(sql);
			stm.setString(1, this.cliente.getNome());
			stm.setDouble(2, this.cliente.getPeso());
			stm.setDouble(3, this.cliente.getAltura());
			stm.setString(4, String.valueOf(this.cliente.getSexo()));
			stm.setInt(5, this.cliente.getNivelAtividade());
			stm.setString(6, this.cliente.getLogradouro());
			stm.setString(7, this.cliente.getBairro());
			stm.setString(8, this.cliente.getCidade());
			stm.setString(9, this.cliente.getTelefone());
			stm.setString(10, this.cliente.getEmail());
			
			if (!stm.execute()) {
				JOptionPane.showMessageDialog(null, "Registro Gravado com Sucesso! ");
			}else {
				JOptionPane.showMessageDialog(null, "Ocorreu um erro na Gravação!");
			}
			
		} catch(Exception erro) {
				erro.getMessage();
		}
	}
	
	
	
	
	
	
	/*public void atualizar() {
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
		
	}*/
	
	
	
	
	

	
	/*public void excluir() {
		try {
			
			String sql ="DELETE FROM funcionario WHERE id=?";
			PreparedStatement stm = Conexao.getConexao().prepareStatement(sql);
			stm.setInt(1, this.cliente.getCodigoCliente());
			
			if (!stm.execute()) {
				JOptionPane.showMessageDialog(null, "Registro Excluido com Sucesso! ");
			}else {
				JOptionPane.showMessageDialog(null, "Ocorreu um erro na Exclusão!");
			}
			
		} catch(Exception erro) {
				erro.getMessage();
		}
		
	}*/

}
