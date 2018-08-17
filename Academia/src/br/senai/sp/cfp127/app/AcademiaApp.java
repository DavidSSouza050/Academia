package br.senai.sp.cfp127.app;

import br.senai.sp.cfp127.cliente.Cliente;

public class AcademiaApp {

	public static void main(String[] args) {
		
		Cliente maria = new Cliente();
		maria.setNome("Maria da Silva");
		maria.setAltura(1.71);
		maria.setIdade(15);
		maria.setPeso(65);
		maria.setBairro("parque do lago");
		maria.setCidade("Jandira");
		maria.setEmail("mariadaila@hotmai.com");
		maria.setSexo('M');
		maria.setNivelAtividade(2);
		
		System.out.println(maria.getImc());
		
		System.out.println(maria.getTmb());
	}

}
