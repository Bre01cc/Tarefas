package br.dev.breno.tarefas.ui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.dev.breno.tarefas.dao.FuncionarioDAO;
import br.dev.breno.tarefas.model.Funcionario;

public class FuncionarioListaFrame {

	private JLabel labeltitulo;
	private JButton btnNovo;
	private JButton bntSair;

	private DefaultTableModel model;// model dado da tabela
	private JTable tabelaFuncionarios;// tabela visualmente
	private JScrollPane scrollFuncionarios;// contêiner da tabela
	String[] colunas = { "CÓDIGO", "NOME FUNCIONÁRIO", "CARGO" };

	public FuncionarioListaFrame(JFrame avo) {
		criarTela(avo);
	}

	private void criarTela(JFrame avo) {
		JDialog telaFuncionariolistaFrame = new JDialog(avo, true);

		telaFuncionariolistaFrame.setSize(700, 500);
		telaFuncionariolistaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		telaFuncionariolistaFrame.setLocationRelativeTo(null);
		telaFuncionariolistaFrame.setLayout(null);
		telaFuncionariolistaFrame.setResizable(false);

		Container painel = telaFuncionariolistaFrame.getContentPane();

		labeltitulo = new JLabel("Cadastro de Funcionários");
		labeltitulo.setFont(new Font("Arial", Font.BOLD, 32));
		labeltitulo.setBounds(10, 10, 500, 40);

		// Criar colunas
		// se o vetor tiver 3 itens terá 3 colunas

		// model passamos a coluna e quantidade de linhas
		model = new DefaultTableModel(colunas, 100);
		tabelaFuncionarios = new JTable(model);
		scrollFuncionarios = new JScrollPane(tabelaFuncionarios);
		scrollFuncionarios.setBounds(10, 70, 680, 300);

		carregarDadosTabela();

		bntSair = new JButton("Sair");
		bntSair.setBounds(270, 400, 250, 50);

		bntSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					telaFuncionariolistaFrame.dispose();

			}
		});

		btnNovo = new JButton("Cadastrar novo Funcionário");
		btnNovo.setBounds(10, 400, 250, 50);

		btnNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new FuncionarioFrame(avo);
				carregarDadosTabela();

			}
		});

		painel.add(labeltitulo);
		painel.add(scrollFuncionarios);
		painel.add(btnNovo);
		painel.add(bntSair);

		telaFuncionariolistaFrame.setVisible(true);
	}

	private void carregarDadosTabela() {
		List<Funcionario> funcionarios = new ArrayList<>();
		int i = 0;
		FuncionarioDAO dao = new FuncionarioDAO(null);
		funcionarios = dao.getFuncionarios();

		Object[][] dados = new Object[funcionarios.size()][3];
		for (Funcionario f : funcionarios) {
			dados[i][0] = f.getMatricula();
			dados[i][1] = f.getNome();
			dados[i][2] = f.getCargo();

			i++;
		}
		model.setDataVector(dados, colunas);

	}
}
