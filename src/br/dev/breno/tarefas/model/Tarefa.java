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
	private LocalDate dataEntrega;
	private Status status;

	public void setStatus(Status status) {
		status = status.CONCLUIDO;
		this.status = status;
	}

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
	//NO caso essa metodo é responsável por receber a data inicial em formato de String, converter para  formato padrão(ano,mês e dia)/ Local data, pois no Brasil é dia, mês e ano.
	//Após virar um objeto localDate ela é convertida em String será eventualmente usada no to String

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
		//Criando uma variavel no metodo responsavel por calculado a data de entrega através da data de inicio mais  
		LocalDate dtPrazo = dataInicio.plusDays(prazo);
		return dataEntrega;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Status getStatus() {
		
		 //Sempre que o getStatus for chamado ele vai 
		if (status == null || !status.equals(Status.CONCLUIDO)) {
	        calcularStatus(); // ou calcStatus(), dependendo do seu projeto
	    }
		
		return status;
	}
	public void calcularStatus() {
		LocalDate hoje = LocalDate.now();
		
		if(hoje.isBefore(dataInicio)) {
			setStatus(status.NAO_INICIADO);
		}
		else if(hoje.isAfter(dataInicio)) {
			setStatus(status.EM_ANDAMENTO);
		}
		else if(hoje.isAfter(dataEntrega)) {
			setStatus(status.CONCLUIDO);
		}
		
		
	}
	public String toString() {
		String matricula = responsavel.getMatricula();
		String nomeFuncionario =responsavel.getNome();
		
		return ;
		
	}
	
	
	

//	public void setStatus(Status status) {
//		this.status = status;
//	}

}
