package trabalhoPAV;

import java.util.ArrayList;
import trabalhoPAV.TelaInicial;

import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FuncionarioService {
	ArrayList<Funcionario> listFuncionario;
	private JTable tabelaFuncionarios;	
	
	public FuncionarioService() {
		listFuncionario = new ArrayList<Funcionario>();
	}
	
	public void adicionarFuncionario(String nome, String cpf, String dataNascimento, String endereço) {
		// Tratamento de CPF não realizado
		Funcionario funcionario = new Funcionario(nome, cpf, dataNascimento, endereço);
		listFuncionario.add(funcionario);
	}
	
	public void removerFuncionario(String cpf) {
		// tratamentos não realizados
		for (int f = 0; f < listFuncionario.size(); f++){
			if(listFuncionario.get(f).getCpf().equals(cpf)) {
				cpf += listFuncionario.remove(f);}
			}
	}
	
	public void atualizarFuncionario (Funcionario funcionario1) {
		Funcionario funcionario = new Funcionario();
		
		for (Funcionario f : listFuncionario) {
			if(f.getCpf().equals(funcionario1.getCpf())) {
				listFuncionario.remove(funcionario);
				f.setNome(funcionario1.getNome());
				f.setCpf(funcionario1.getCpf());
				f.setDataNascimento(funcionario1.getDataNascimento());
				f.setEndereço(funcionario1.getEndereço());
				}
			}
		}
	
	// Douglas, para fazer esse método aqui especificamente, pedi ajuda ao Breno Raeder
	// Após algumas tentativas frustradas de fazer uma nova janela para exibir a consulta, optei por fazer o JOptionPane
	// Dessa forma, o meu está parecido/igual ao dele e não o oposto (o dele parecido com o meu)
	public void consultarFuncionario(String cpf) {
		for (Funcionario f : listFuncionario)
			if(f.getCpf().equals(cpf)) {
				JOptionPane.showMessageDialog(null, f.toString());
				}
			}
	
	public ArrayList<Funcionario> getListFuncionario() {
        return listFuncionario;
    }
	
    @Override
    public String toString() {
        String frToString = new String();
        
        for (Funcionario funcionario : listFuncionario) {
            frToString += funcionario.toString();
            frToString += "\n";
        }
        return frToString;
    }

}