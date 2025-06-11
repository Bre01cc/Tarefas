package br.dev.breno.tarefas.ui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GerenciadorDeTelas {
	private JLabel labelGerenciador;
	private JButton bntTarefas;
	private JButton bntFuncionarios;

	public GerenciadorDeTelas() {
		criarTela();
	}

	private void criarTela() {
		JFrame telaGerenciador = new JFrame();

		telaGerenciador.setSize(370, 200);
		telaGerenciador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telaGerenciador.setLocationRelativeTo(null);
		telaGerenciador.setLayout(null);
		telaGerenciador.setResizable(false);

		labelGerenciador = new JLabel();
		labelGerenciador.setBounds(100, 20, 150, 60);
		labelGerenciador.setText("Menu inicial");
		labelGerenciador.setFont(new Font("Arial", Font.BOLD, 25));

		bntTarefas = new JButton("Tarefas");
		bntTarefas.setBounds(10, 100, 150, 60);

		bntFuncionarios = new JButton("Funcionários");
		bntFuncionarios.setBounds(190, 100, 150, 60);

		Container painel = telaGerenciador.getContentPane();
		painel.add(bntTarefas);
		painel.add(bntFuncionarios);
		painel.add(labelGerenciador);

		bntFuncionarios.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				new FuncionarioListaFrame(telaGerenciador);

			}
		});

		bntTarefas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		telaGerenciador.setVisible(true);

	}

}
