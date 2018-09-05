package entidades;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {
	private String pais;
	private String estado;
	private String cidade;
	private String logradouro;
	private String numero;
	private String complemento;
	private String cep;

	public Endereco() {

	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Endereco(String pais, String estado, String cidade, String logradouro, String numero, String complemento,
			String cep) {
		this.pais = pais;
		this.estado = estado;
		this.cidade = cidade;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
	}

	@Override
	public String toString() {
		return (
		this.pais 
		+ " , "+ this.estado 
		+ " , "+ this.cidade
		+ " , "+this.logradouro
		+ " - "+this.numero 
		+ " , "+this.complemento 
		+ " , "+this.cep );			
	}

}