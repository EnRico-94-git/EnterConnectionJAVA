package br.com.classes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "parceiro")
public class Parceiro {
    @Id
    @Column(name = "id_parceiro", length = 5)
    private String idParceiro;

    @Column(name = "nm_parceiro", length = 50)
    private String nmParceiro;

    @Column(name = "area_atuando", length = 50)
    private String areaAtuando;

    @Column(name = "avaliacao_desemp", length = 500)
    private String avaliacaoDesemp;

    @Column(name = "tp_parceria", length = 50)
    private String tpParceria;

	public void setIdParceiro(String id) {
		// TODO Auto-generated method stub
		
	}

	public Object getIdParceiro() {
		// TODO Auto-generated method stub
		return null;
	}

    // Getters and Setters
}

