package br.dev.breno.tarefas.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.dev.breno.tarefas.dao.FuncionarioDAO;
import br.dev.breno.tarefas.dao.TarefaDao;
import br.dev.breno.tarefas.model.Funcionario;
import br.dev.breno.tarefas.model.Tarefa;
import br.dev.breno.tarefas.utils.Utils;

public class TarefaFrame {
	private JLabel labelId;
	private JTextField txtId;
	private JLabel labelNome;
	private JTextField txtNome;
	private JLabel labelDescricao;
	private JTextField txtDescricao;
	private JLabel labelFuncionario;
	private List<String> lista;
	private JComboBox<String> funcionariosListBox;
	private JLabel labelDataDeInicio;
	private JTextField txtDataDeInicio;
	private JLabel labelPrazo;
	private JTextField txtPrazo;
	private JLabel labelDtaEntrega;
	private JTextField txtDtaEntrega;
	private JButton bntSair;
	private JButton bntSalvar;

	public TarefaFrame(JFrame pai) {
		criarTela(pai);
	}

	private void criarTela(JFrame pai) {
		JDialog telaTarefa = new JDialog(pai, true);

		telaTarefa.setSize(600, 650);
		telaTarefa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		telaTarefa.setResizable(false);
		telaTarefa.setLayout(null);

		labelId = new JLabel();
		labelId.setText("Mátricula");
		labelId.setBounds(10, 20, 100, 30);

		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setText(Utils.gerarUUID8());
		txtId.setBounds(10, 50, 150, 30);

		labelNome = new JLabel();
		labelNome.setText("Nome da tarefa");
		labelNome.setBounds(10, 80, 100, 30);

		txtNome = new JTextField();
		txtNome.setBounds(10, 110, 150, 30);

		labelDescricao = new JLabel();
		labelDescricao.setText("Descriação da tarefa");
		labelDescricao.setBounds(10, 140, 150, 30);

		txtDescricao = new JTextField();
		txtDescricao.setBounds(10, 170, 250, 70);

		labelFuncionario = new JLabel();
		labelFuncionario.setBounds(10, 240, 200, 30);
		labelFuncionario.setText("Funcionário para tarefa");
		// Criando funcionario dao
		FuncionarioDAO dao = new FuncionarioDAO(null);
		// Associando getNomes para avariavel lista
		lista = dao.getNomesFuncionarios();
		// Criando objeto JComboBox que recebera uma lista de Strings
		funcionariosListBox = new JComboBox<String>();
		funcionariosListBox.setBounds(10, 270, 150, 30);
		
		// ":" indica um loop for-each, que percorre todos os itens de uma coleção (como
		// uma lista ou array)
		// "Para cada String na lista, atribua o valor atual a uma variável
		// chamada 'nome'"
		// O for-each deixa o código mais limpo e legível, mas oferece menos controle
		// comparado ao for tradicional (por exemplo, não acessamos o índice atual)

		for (String nome : lista) {
			// Adicionando itens ou nomes para o ComboBox
			funcionariosListBox.addItem(nome);
		}

		labelDataDeInicio = new JLabel();
		labelDataDeInicio.setText("Data de inicio");
		labelDataDeInicio.setBounds(10, 300, 150, 30);

		txtDataDeInicio = new JTextField();
		txtDataDeInicio.setBounds(10, 330, 150, 30);

		labelPrazo = new JLabel();
		labelPrazo.setText("Prazo");
		labelPrazo.setBounds(10, 360, 100, 30);

		txtPrazo = new JTextField();
		txtPrazo.setBounds(10, 390, 150, 30);

		labelDtaEntrega = new JLabel("Data de Entrega");

		bntSalvar = new JButton();
		bntSalvar.setText("Salvar");
		bntSalvar.setBounds(10, 450, 120, 40);

		bntSair = new JButton();
		bntSair.setText("Sair");
		bntSair.setBounds(140, 450, 120, 40);

		bntSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(telaTarefa, "Deseja sair do sistema?", "Ateção",
						JOptionPane.YES_NO_OPTION);

				if (resposta == 0) {
					telaTarefa.dispose();
				}

			}
		});
		bntSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nomeFuncionario = (String) funcionariosListBox.getSelectedItem();
				Funcionario f = new Funcionario(nomeFuncionario);
				Tarefa t = new Tarefa(f);
				t.setNome(txtNome.getText());
				t.setResponsavel(f);
				t.setDescricao(txtDescricao.getText());
				t.setDataInicio(txtDataDeInicio.getText());
				t.setPrazo(Integer.parseInt(txtPrazo.getText()));
				t.getDataPrevistaEntrega();
				t.calcularStatus();
				t.getStatus();

				TarefaDao d = new TarefaDao(t);

				boolean sucesso = d.gravar();

				if (sucesso) {
					// JOptionPane imprimir mensagem após o buttom for acionado, para exibir se ação
					// foi realizada com sucesso
					JOptionPane.showMessageDialog(telaTarefa, "Tarefa gravada com sucesso");
					JOptionPane.showMessageDialog(telaTarefa, "Tarefa deverá ser entregue em"+t.getDataEntrega());
					
//					limparFormulario();
				} else {
					JOptionPane.showMessageDialog(telaTarefa,
							"Ocorreu um erro na gravação.\nTente novamente.\nSe o problema persistir, entre em contato com o suporte");
				}

			}
		});

		Container painel = telaTarefa.getContentPane();
		painel.add(labelId);
		painel.add(txtId);
		painel.add(labelNome);
		painel.add(txtNome);
		painel.add(labelDescricao);
		painel.add(txtDescricao);
		painel.add(labelFuncionario);
		painel.add(funcionariosListBox);
		painel.add(labelDataDeInicio);
		painel.add(txtDataDeInicio);
		painel.add(labelPrazo);
		painel.add(txtPrazo);
		painel.add(bntSalvar);
		painel.add(bntSair);

		telaTarefa.setVisible(true);

	}

}
