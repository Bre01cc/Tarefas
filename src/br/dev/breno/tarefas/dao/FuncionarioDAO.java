package br.dev.breno.tarefas.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.breno.tarefas.factory.ArquivoFuncionarioFactory;
import br.dev.breno.tarefas.model.Funcionario;

public class FuncionarioDAO {
	private Funcionario funcionario;
	// ingesão de dependecia
	private ArquivoFuncionarioFactory aff = new ArquivoFuncionarioFactory();

	public FuncionarioDAO(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	// adicionamos um retorno de verdadeiro ou falso
	public boolean gravar() {

		try {

			BufferedWriter bw = aff.getBw();
			bw.write(funcionario.toString());
			bw.flush();
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;

		}

	}

	public List<Funcionario> getFuncionarios() {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();

		try {
			BufferedReader br = aff.getBr();
			String linha = "";

			while (linha != null) {
				linha = br.readLine();
				if (linha != null) {
					String[] funcionarioVetor = linha.split(",");

					Funcionario f = new Funcionario(null);
					f.setMatricula(funcionarioVetor[0]);
					f.setNome(funcionarioVetor[1]);
					f.setCargo(funcionarioVetor[2]);
					f.setSetor(funcionarioVetor[3]);
					f.setSalario(Double.parseDouble(funcionarioVetor[4]));

					funcionarios.add(f);
				}

			}
			return funcionarios;

		} catch (IOException e) {
			return null;
			
		}
	}

}
