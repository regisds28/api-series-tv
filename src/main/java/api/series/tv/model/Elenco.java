package api.series.tv.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Elenco")
@EqualsAndHashCode
@NoArgsConstructor
public class Elenco {

	@Id
	@SequenceGenerator(name = "elenco_seq")
	@GeneratedValue(generator = "elenco_seq", strategy = GenerationType.AUTO)
	private Long id;

	private String nome;

	@JsonIgnoreProperties({ "autor", "elenco", "temporada", "sinopse" })
	@ManyToMany(mappedBy = "elenco")
	private List<Serie> serie = new ArrayList<Serie>();

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

	public List<Serie> getSerie() {
		return serie;
	}

	public void setSerie(List<Serie> serie) {
		this.serie = serie;
	}

}
