package br.dev.breno.tarefas;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.UUID;

import br.dev.breno.tarefas.dao.FuncionarioDAO;
import br.dev.breno.tarefas.factory.ArquivoTarefaFactory;
import br.dev.breno.tarefas.model.Funcionario;
import br.dev.breno.tarefas.model.Status;
import br.dev.breno.tarefas.model.Tarefa;
import br.dev.breno.tarefas.ui.FuncionarioFrame;
import br.dev.breno.tarefas.ui.FuncionarioListaFrame;
import br.dev.breno.tarefas.ui.GerenciadorDeTelas;
import br.dev.breno.tarefas.ui.TarefaFrame;
import br.dev.breno.tarefas.ui.TarefasListaFrame;
import br.dev.breno.tarefas.utils.Utils;

public class Main {

	public static void main(String[] args) {
		new GerenciadorDeTelas();
		
		//TESTE Para verificar se o Arquivo pode ser encontrado
//		String caminho = "dadosAR/tarefa.txt"; // Caminho que você está usando
//
//        File arquivo = new File(caminho);
//
//        if (!arquivo.exists()) {
//            System.out.println("❌ Arquivo NÃO encontrado.");
//        } else {
//            System.out.println("✅ Arquivo encontrado em: " + arquivo.getAbsolutePath());
//
//            if (arquivo.length() == 0) {
//                System.out.println("⚠️ Arquivo está vazio.");
//            } else {
//                System.out.println("📄 Arquivo possui " + arquivo.length() + " bytes.");
//
//                // Mostra o conteúdo do arquivo
//                try {
//                    System.out.println("📃 Conteúdo:");
//                    Files.lines(Paths.get(caminho)).forEach(System.out::println);
//                } catch (IOException e) {
//                    System.out.println("❌ Erro ao ler o arquivo: " + e.getMessage());
//                }
//            }}
}
		
		
		// testarLeituraEscritaArquivo();
	
//	FuncionarioDAO dao = new FuncionarioDAO(null);
//dao.getFuncionarios();
//	new FuncionarioListaFrame();

//	new TarefasListaFrame();	

//		new TarefaFrame();
		
//		ArquivoTarefaFactory arTaf = new ArquivoTarefaFactory();
//		String caminhoDoArquivo = "/Users/25133656/projetoTarefasDS1M/tarefas.csv";
//		public FileWriter fw;
//		private BufferedWriter bw;
//		private FileReader fr;
//		private BufferedReader br;

		



	
	
//		Funcionario funcionario = new Funcionario("Paulo","Programação");
//		funcionario.setSetor("Tecnologia da Informação");
//		funcionario.setSalario(6987.98);
//		
//		FuncionarioDAO dao = new FuncionarioDAO(funcionario);
//		dao.gravar();
	

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
