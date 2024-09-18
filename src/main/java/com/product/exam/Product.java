package com.product.exam;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.time.LocalDate;

@Entity
@Table (name = "product")

public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
    private String elaboradoMano;
    private String maquina;
    private String status;
    private LocalDate dateCreation;
   
    public Product() {
    	
    }
    
    public Product(Long id, String elaboradoMano, String maquina, String status, LocalDate dateCreation) {
    	 this.id = id;
    	 this.elaboradoMano = elaboradoMano;
    	 this.maquina = maquina;
    	 this.status = status;
    	 this.dateCreation = dateCreation;
    	
    }
    public Product( String elaboradoMano, String maquina, String status, LocalDate dateCreation) {
     this.elaboradoMano = elaboradoMano;
   	 this.maquina = maquina;
   	 this.status = status;
   	 this.dateCreation = dateCreation;
   	
   }
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getElaboradoMano() {
		return elaboradoMano;
	}
	public void setElaboradoMano(String elaboradoMano) {
		this.elaboradoMano = elaboradoMano;
	}
	public String getMaquina() {
		return maquina;
	}
	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}
	

}
