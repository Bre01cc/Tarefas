package br.dev.breno.tarefas.ui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TarefasListaFrame {

	private JLabel labelTitulo;
	private JButton btnSair;
	private JButton btnNovo;
	
	private DefaultTableModel model;// model dado da tabela
	private JTable tabelaTarefas;// tabela visualmente
	private JScrollPane scrollTarefas;// contêiner da tabela
	
	String[] colunas = { "CÓDIGO", "NOME", "RESPONSAVEL","STATUS" };

	public TarefasListaFrame(JFrame pai) {
		criarTela(pai);
	}

	private void criarTela(JFrame pai) {
		JDialog telaTerefasListaFrame = new JDialog(pai,true);

		telaTerefasListaFrame.setSize(700, 500);
		telaTerefasListaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		telaTerefasListaFrame.setLocationRelativeTo(null);
		telaTerefasListaFrame.setLayout(null);
		telaTerefasListaFrame.setResizable(false);

		labelTitulo = new JLabel("Cadastro de Tarefas");
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 32));
		labelTitulo.setBounds(10, 10, 500, 40);

		btnSair = new JButton("Sair");
		btnSair.setBounds(270, 400, 250, 50);
		
		btnSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				telaTerefasListaFrame.dispose();
				
			}
		});

		btnNovo = new JButton("Cadastrar nova Tarefa");
		btnNovo.setBounds(10, 400, 250, 50);
		
		btnNovo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TarefaFrame(pai);
				
			}
		});
		
		model = new DefaultTableModel(colunas, 10);
		tabelaTarefas = new JTable(model);
		scrollTarefas = new JScrollPane(tabelaTarefas);
		scrollTarefas.setBounds(10, 70, 680, 300);

		Container painel = telaTerefasListaFrame.getContentPane();
		painel.add(labelTitulo);
		painel.add(btnSair);
		painel.add(btnNovo);
		painel.add(scrollTarefas);
		telaTerefasListaFrame.setVisible(true);
	}
}
