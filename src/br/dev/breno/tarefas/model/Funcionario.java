package br.dev.breno.tarefas.model;

import br.dev.breno.tarefas.utils.Utils;

public class Funcionario {
	private String nome;
	private String cargo;
	private String setor;
	private double salario;
	private String matricula;
	
	
	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Funcionario(String nome){
		System.out.println("Criando funcionário"+ nome);

		this.nome = nome;
		setMatricula(Utils.gerarUUID8());
	}
	
	public Funcionario(String nome, String cargo) {
		this.nome = nome;
		this.cargo = cargo;
		this.matricula = Utils.gerarUUID8();
		
		
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}
	
	@Override //Avisar que esse metodo sendo subescrito
	public String toString() {
		
		return matricula+","+nome+","+cargo+","+setor+","+salario+"\n";
	}

}
