package entidades;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

@Entity
@SequenceGenerator(name="cliente_id", sequenceName="cliente_seq", allocationSize=1)
public class Cliente {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cliente_id")
	private int id;
	
	private String nome;
	
	@Transient
	private int prioridade;
	
	@Embedded
	private Endereco endereco;
	
	public Cliente(){}
	
	public int getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Cliente(String nome, int prioridade, Endereco endereco) {
		this.nome = nome;
		this.prioridade = prioridade;
		this.endereco = endereco;
	}
	
	public String toString() {
	return ("\n"+"|Id :" + this.id + "|Nome :" +this.nome +"|Prioridade :"+ this.prioridade + "|Endereco :" + this.endereco.toString());
	}
}


