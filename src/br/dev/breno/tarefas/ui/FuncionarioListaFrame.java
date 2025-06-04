package br.dev.breno.tarefas.ui;

import java.awt.Container;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.dev.breno.tarefas.model.Funcionario;

public class FuncionarioListaFrame {

	private JLabel labeltitulo;
	private JButton btnNovo;

	private DefaultTableModel model;// model dado da tabela
	private JTable tabelaFuncionarios;// tabela visualmente
	private JScrollPane scrollFuncionarios;// contêiner da tabela

	public FuncionarioListaFrame() {
		criarTela();
	}

	private void criarTela() {
		JFrame telaFuncionariolistaFrame = new JFrame("Lista de Funcionários");

		telaFuncionariolistaFrame.setSize(700, 500);
		telaFuncionariolistaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telaFuncionariolistaFrame.setLocationRelativeTo(null);
		telaFuncionariolistaFrame.setLayout(null);
		telaFuncionariolistaFrame.setResizable(false);

		Container painel = telaFuncionariolistaFrame.getContentPane();

		labeltitulo = new JLabel("Cadastro de Funcionários");
		labeltitulo.setFont(new Font("Arial", Font.BOLD, 32));
		labeltitulo.setBounds(10, 10, 500, 40);

		// Criar colunas
		// se o vetor tiver 3 itens terá 3 colunas
		String[] colunas = { "CÓDIGO", "NOME FUNCIONÁRIO", "CARGO" };
		// model passamos a coluna e quantidade de linhas
		model = new DefaultTableModel(colunas, 100);
		tabelaFuncionarios = new JTable(model);
		scrollFuncionarios = new JScrollPane(tabelaFuncionarios);
		scrollFuncionarios.setBounds(10, 70, 680, 300);
		carregarDadosTabela();

		painel.add(labeltitulo);
		painel.add(scrollFuncionarios);

		telaFuncionariolistaFrame.setVisible(true);
	}

	private void carregarDadosTabela() {
		List<Funcionario> funcionarios = new ArrayList<>();
		int i = 0;

		Object[][] dados = new Object[funcionarios.size()][3];
		for (Funcionario f : funcionarios) {
			dados[i][0] = f.getMatricula();
			dados[i][1] = f.getNome();
			dados[i][2] = f.getCargo();

			i++;
		}
		model.setData(dados)

	}
}
