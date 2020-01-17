package jwd.EvidencijaTakmicenja.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "tblUcesnik")
public class Ucesnik {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	@Column(name = "naziv" ,nullable=false, unique=true)
	private String naziv;
	@Column(name = "mesto")
	private String mesto;
	@Column(name = "email", nullable=false)
	@Email
	private String email;
	@Column(name = "odigraoSusreta")
	private Integer odigraoSusreta = 0;
	@Column(name = "brBodova")
	private Integer brBodova = 0;
	@ManyToOne(fetch = FetchType.EAGER)
	private Takmicenje takmicenje;

	public Ucesnik() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getMesto() {
		return mesto;
	}

	public void setMesto(String mesto) {
		this.mesto = mesto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getOdigraoSusreta() {
		return odigraoSusreta;
	}

	public void setOdigraoSusreta(Integer odigraoSusreta) {
		this.odigraoSusreta = odigraoSusreta;
	}

	public Integer getBrBodova() {
		return brBodova;
	}

	public void setBrBodova(Integer brBodova) {
		this.brBodova = brBodova;
	}

	public Takmicenje getTakmicenje() {
		return takmicenje;
	}

	public void setTakmicenje(Takmicenje takmicenje) {
		this.takmicenje = takmicenje;
		if (!takmicenje.getUcesnici().contains(this)) {
			takmicenje.getUcesnici().add(this);
		}
	}

}
