package br.dev.breno.tarefas.factory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ArquivoFuncionarioFactory {
	private String caminho = "/Users/25133656/projetoTarefasDS1M/funcionario.csv";
	private FileWriter fw;
	private BufferedWriter bw;

	public BufferedWriter getBw()throws IOException {
		
		fw = new FileWriter(caminho, true);
		bw = new BufferedWriter(fw);
		
		return bw;
	}

}
