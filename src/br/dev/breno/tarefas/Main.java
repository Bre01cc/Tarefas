package br.dev.breno.tarefas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

import br.dev.breno.tarefas.model.Funcionario;
import br.dev.breno.tarefas.model.Status;
import br.dev.breno.tarefas.model.Tarefa;

public class Main {

	public static void main(String[] args) {
		// testarLeituraEscritaArquivo();
		
		Funcionario funcionario = new Funcionario("Breno","aluno");
		
		Tarefa tarefa = new Tarefa(funcionario);
		
		tarefa.setNome("lavar a louça");
		tarefa.setDescricao("lavar a louça antes de eu chegar");
		tarefa.setDataInicio(LocalDate.of(2025, 5, 21));
		tarefa.setPrazo(1);
		tarefa.setStatus(Status.EM_ANDAMENTO);	

	}

	private static void testarLeituraEscritaArquivo() {
		String so = System.getProperty("os.name");
		System.out.println(so);
		String caminho = "/Users/25133656/projetoTarefasDS1M/tarefas";

		FileReader fr = null;

		BufferedReader br = null;

		FileWriter fw = null;

		BufferedWriter bw = null;
		try {
			fr = new FileReader(caminho);
			br = new BufferedReader(fr);

			fw = new FileWriter(caminho, true);
			bw = new BufferedWriter(fw);

			bw.append("batata\13");
			bw.flush();

			String linha = br.readLine();

			// o loop vai continuar enquanto a linha for diferente de null(espaço vazio)
			// !(not) =(obviamente e igual) != diferente
			while (linha != null) {
				System.out.println(linha);
				linha = br.readLine();
			}
			// Dizer qual exeção está ocorrendo
		} catch (FileNotFoundException erro) {
			System.out.println("Arquivo não encontrado!");

		} catch (IOException erros) {
			System.out.println("o arquivo não pode ser acessado");

		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
	}

}
