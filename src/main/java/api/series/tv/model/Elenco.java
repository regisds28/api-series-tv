package api.series.tv.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Elenco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	
	private String nome;
	
	private String personagem;
	
	@JsonIgnore
	@ForeignKey(name = "serie_id")
	@ManyToOne(optional = false)
	private Series serie;

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
	
	public String getPersonagem() {
		return personagem;
	}
	
	public void setPersonagem(String personagem) {
		this.personagem = personagem;
	}
	
	public void setSerie(Series serie) {
		this.serie = serie;
	}
	
	public Series getSerie() {
		return serie;
	}
	
	

}
