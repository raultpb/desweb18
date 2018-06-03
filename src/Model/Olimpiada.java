package Model;

import java.io.Serializable;

public class Olimpiada implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	public int id;
	public int ouro;
	public int prata;
	public int bronze;
	public String nomePais;
	public String nomeModalidade;
	public int ano;
	
	public Olimpiada() {
		
	}

	public Olimpiada(int id, int ouro, int prata, int bronze, String nomePais, String nomeModalidade, int ano) {
		super();
		this.id = id;
		this.ouro = ouro;
		this.prata = prata;
		this.bronze = bronze;
		this.nomePais = nomePais;
		this.nomeModalidade = nomeModalidade;
		this.ano = ano;
	}


	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOuro() {
		return ouro;
	}

	public void setOuro(int ouro) {
		this.ouro = ouro;
	}

	public int getPrata() {
		return prata;
	}

	public void setPrata(int prata) {
		this.prata = prata;
	}

	public int getBronze() {
		return bronze;
	}

	public void setBronze(int bronze) {
		this.bronze = bronze;
	}

	public String getNomePais() {
		return nomePais;
	}

	public void setNomePais(String nomePais) {
		this.nomePais = nomePais;
	}

	public String getNomeModalidade() {
		return nomeModalidade;
	}

	public void setNomeModalidade(String nomeModalidade) {
		this.nomeModalidade = nomeModalidade;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ano;
		result = prime * result + bronze;
		result = prime * result + id;
		result = prime * result + ((nomeModalidade == null) ? 0 : nomeModalidade.hashCode());
		result = prime * result + ((nomePais == null) ? 0 : nomePais.hashCode());
		result = prime * result + ouro;
		result = prime * result + prata;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Olimpiada other = (Olimpiada) obj;
		if (ano != other.ano)
			return false;
		if (bronze != other.bronze)
			return false;
		if (id != other.id)
			return false;
		if (nomeModalidade == null) {
			if (other.nomeModalidade != null)
				return false;
		} else if (!nomeModalidade.equals(other.nomeModalidade))
			return false;
		if (nomePais == null) {
			if (other.nomePais != null)
				return false;
		} else if (!nomePais.equals(other.nomePais))
			return false;
		if (ouro != other.ouro)
			return false;
		if (prata != other.prata)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Olimpiada [id=" + id + ", ouro=" + ouro + ", prata=" + prata + ", bronze=" + bronze + ", nomePais="
				+ nomePais + ", nomeModalidade=" + nomeModalidade + ", ano=" + ano + "]";
	}
	
	
}


