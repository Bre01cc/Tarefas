package br.dev.breno.tarefas.factory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ArquivoTarefaFactory {
	String caminhoDoArquivo = "/Users/25133656/projetoTarefasDS1M/tarefas.csv";
	private FileWriter fw;
	private BufferedWriter bw;
	private FileReader fr;
	private BufferedReader br;

	public BufferedWriter getBw() throws IOException {

		fw = new FileWriter(caminhoDoArquivo, true);
		bw = new BufferedWriter(fw);

		return bw;
	}

	public BufferedReader getBr() throws IOException {
		fr = new FileReader(caminhoDoArquivo);
		br = new BufferedReader(fr);

		return br;
	}
	

}
