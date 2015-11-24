package model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Motor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	private String NumeroSerie;
	private int PotenciaCavalos;
	
	private int qtdCilindros;
	
	@OneToOne (cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	Carro carro;
	
	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroSerie() {
		return NumeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		NumeroSerie = numeroSerie;
	}

	public int getPotenciaCavalos() {
		return PotenciaCavalos;
	}

	public void setPotenciaCavalos(int potenciaCavalos) {
		PotenciaCavalos = potenciaCavalos;
	}

	public int getQtdCilindros() {
		return qtdCilindros;
	}

	public void setQtdCilindros(int qtdCilindros) {
		this.qtdCilindros = qtdCilindros;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

}
