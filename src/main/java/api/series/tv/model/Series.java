package api.series.tv.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Series implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String ano;
	private String genero;
	private String sinopse;	
	private String pais;
	private String canal;
	private String linkTrailer;
	
	@OneToMany(mappedBy = "serie", cascade = CascadeType.ALL)
	private List<Elenco> elenco = new ArrayList<Elenco>();
	
	@OneToMany(mappedBy = "serie", cascade = CascadeType.ALL)
	private List<Temporada> temporada = new ArrayList<Temporada>();	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getSinopse() {
		return sinopse;
	}
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	public List<Elenco> getElenco() {
		return elenco;
	}
	public void setElenco(List<Elenco> elenco) {
		this.elenco = elenco;
	}
	public List<Temporada> getTemporada() {
		return temporada;
	}
	public void setTemporada(List<Temporada> temporada) {
		this.temporada = temporada;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getCanal() {
		return canal;
	}
	public void setCanal(String canal) {
		this.canal = canal;
	}
	
	public String getLinkTrailer() {
		return linkTrailer;
	}
	
	public void setLinkTrailer(String linkTrailer) {
		this.linkTrailer = linkTrailer;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Series other = (Series) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
