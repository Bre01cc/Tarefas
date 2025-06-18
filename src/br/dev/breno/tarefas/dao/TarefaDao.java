package br.dev.breno.tarefas.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.breno.tarefas.factory.ArquivoTarefaFactory;
import br.dev.breno.tarefas.model.Funcionario;
import br.dev.breno.tarefas.model.Tarefa;

public class TarefaDao {
	private Tarefa tarefa;
	private ArquivoTarefaFactory aff = new ArquivoTarefaFactory();

	public TarefaDao(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public boolean gravar() {
		try {
			BufferedWriter bw = aff.getBw();
			bw.write(tarefa.toString());
			bw.flush();
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;

		}

	}
	public List<Tarefa> getTarefa() {
		List<Tarefa> tarefas = new ArrayList<Tarefa>();

		try {
			BufferedReader br = aff.getBr();
			String linha = "";

			while ((linha = br.readLine()) != null) {
				String[] tarefaVetor = linha.split(",");

				if (tarefaVetor.length >= 7) {
					// Supondo que você ainda não está recuperando o funcionário real
					Tarefa tarefa = new Tarefa(null);

					tarefa.setId(tarefaVetor[0]);
					tarefa.setNome(tarefaVetor[1]);
					tarefa.setDescricao(tarefaVetor[2]);
					tarefa.setDataInicio(tarefaVetor[4]); // dataInicio
					tarefa.setPrazo(Integer.parseInt(tarefaVetor[5]));
//					tarefa.setDataEntrega(tarefaVetor[6]);
					// Opcional: tarefa.setStatus(Status.valueOf(tarefaVetor[7]));

					tarefas.add(tarefa);}
			}
			return tarefas;

		} catch (IOException e) {
			return null;

		}
	}

}

