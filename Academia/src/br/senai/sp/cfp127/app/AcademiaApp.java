package br.senai.sp.cfp127.app;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import br.senai.sp.cfp127.utils.Data;
import br.senai.sp.cfp127.view.FrmCliente;
import br.senai.sp.cfp127.view.FrmFuncionario;

public class AcademiaApp {

	public static void main(String[] args) {
		
		LookAndFeelInfo info[] = UIManager.getInstalledLookAndFeels();
		
		//String tela = JOptionPane.showInputDialog("Digite um look de 0 a 4:");
		
		//Integer.parseInt(tela)
		try {
			UIManager.setLookAndFeel(info[1].getClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/// MM - MES  mm - minuto
		
		
		FrmCliente janela = new FrmCliente();
		janela.setVisible(true);
		//FrmFuncionario Funcionario = new FrmFuncionario();
		
		Data.converterParaAccess("21/09/2018");
		
		
	}

}
