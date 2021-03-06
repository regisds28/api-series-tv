package api.series.tv.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Serie")
@NoArgsConstructor
@EqualsAndHashCode
public class Serie implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "serie_seq")
	@GeneratedValue(generator = "serie_seq", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@NotBlank(message = "Coloque o nome da série")
	private String nome;
	
	private String anoLancamento;
	
	private String genero;
	
	private String pais;
	
	private String canalOrigem;
	
	@Column(length = 5000)
	private String sinopse;	

	@JsonIgnoreProperties("serie")
	@ManyToMany
	@JoinTable(name = "serie_autor", 
	   joinColumns = @JoinColumn(name = "serie_id"), 
	   inverseJoinColumns = @JoinColumn(name = "autor_id"))
	private List<Autor> autor = new ArrayList<Autor>();	
	
	@JsonIgnoreProperties("serie")
	@ManyToMany
	@JoinTable(name = "serie_elenco", 
	   joinColumns = @JoinColumn(name = "serie_id"), 
	   inverseJoinColumns = @JoinColumn(name = "elenco_id"))
	private List<Elenco> elenco = new ArrayList<Elenco>();

	@OneToMany(mappedBy = "serie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Temporada> temporada = new HashSet<>();

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

	public String getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(String anoLancamento) {
		this.anoLancamento = anoLancamento;
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

	public Set<Temporada> getTemporada() {
		return temporada;
	}
	
	public void setTemporada(Set<Temporada> temporada) {
		this.temporada = temporada;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCanalOrigem() {
		return canalOrigem;
	}

	public void setCanalOrigem(String canalOrigem) {
		this.canalOrigem = canalOrigem;
	}
	
	public List<Autor> getAutor() {
		return autor;
	}
	
	public void setAutor(List<Autor> autor) {
		this.autor = autor;
	}
	
	public List<Elenco> getElenco() {
		return elenco;
	}
	
	public void setElenco(List<Elenco> elenco) {
		this.elenco = elenco;
	}

}
