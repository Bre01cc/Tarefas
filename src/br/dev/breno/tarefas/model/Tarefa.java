package br.dev.breno.tarefas.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.text.Utilities;

import br.dev.breno.tarefas.utils.Utils;

public class Tarefa {
	private String Id;
	private String nome;
	private String descricao;
	private Funcionario responsavel;
	private LocalDate dataInicio;
	private int prazo;
	private String dataString;
	private String dataEntregaString;
	private LocalDate dataEntrega;
	private Status status;

	public void setStatus(Status status) {
//		status = status.CONCLUIDO;
		this.status = status;
	}

	// Sempre que uma nova tarefa for criada ela vai gerar um ID(Identificador) único
	// para a tarefa e quando requisitada terá que receber um funcionario
	public Tarefa(Funcionario funcionario) {
		setId(Utils.gerarUUID8());
		setResponsavel(funcionario);

	}

	public void setId(String id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Funcionario getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Funcionario responsavel) {
		this.responsavel = responsavel;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}
	// NO caso essa metodo é responsável por receber a data inicial em formato de
	// String, converter para formato padrão(ano,mês e dia)/ Local data, pois no
	// Brasil é dia, mês e ano.
	// Após virar um objeto localDate ela é convertida em String será eventualmente
	// usada no to String

	public void setDataInicio(String dataString) {
		this.dataInicio = LocalDate.parse(dataString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		dataString = dataInicio.toString();

	}

	public int getPrazo() {
		return prazo;
	}

	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}

	public LocalDate getDataPrevistaEntrega() {
		// Criando uma variavel no metodo responsavel por calculado a data de entrega
		// através da data de inicio mais
		LocalDate dtPrazo = dataInicio.plusDays(prazo);
		dataEntrega = dtPrazo;
		return dataEntrega;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

//	public void setDataEntrega(String dataDeEntrega) {
//		this.dataEntrega = LocalDate.parse(dataDeEntrega, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//
//	}

	public Status getStatus() {

		// Sempre que o getStatus for chamado ele vai verificar se a tarefa está
		// concluida ou se ainda não possui status
		if (status == null || !status.equals(Status.CONCLUIDO)) {
			calcularStatus();
		}

		return status;
	}

	public void calcularStatus() {
		// Estou criando uma variável chamada hoje, que é do tipo LocalDate, e essa
		// variável está recebendo a data atual do sistema, obtida com LocalDate.now()
		LocalDate hoje = LocalDate.now();

		//
		if (hoje.isAfter(dataEntrega)) {
			setStatus(status.EM_ATRASO);
		} else if (hoje.isBefore(dataInicio)) {
			setStatus(status.NAO_INICIADO);
		} else if (hoje.isAfter(dataInicio) || (!hoje.isAfter(dataEntrega))) {
			setStatus(status.EM_ANDAMENTO);
		}

	}

	public String toString() {
//		String matricula = responsavel.getMatricula();
		String nomeFuncionario = responsavel.getNome();

		return Id + "," + nome + "," + descricao + "," + nomeFuncionario + "," + dataInicio + "," + prazo + " Dias"+","
				+ dataEntrega + "," + status+"\n";

	}}

////	public void setStatus(Status status) {
////		this.status = status;
////	}
//
//}
