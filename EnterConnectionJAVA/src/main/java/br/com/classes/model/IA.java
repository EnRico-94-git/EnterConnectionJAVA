package br.com.classes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ia")
public class IA {
    @Id
    @Column(name = "id_ia", length = 5)
    private String idIa;

    @Column(name = "hist_recomendacao", length = 999999999)
    private String histRecomendacao;

    @Column(name = "tecnologias", length = 50000)
    private String tecnologias;

    @Column(name = "banco_dados", length = 50000)
    private String bancoDados;

    @Column(name = "dados", length = 5000)
    private String dados;

    @Column(name = "parceiro_id_parceiro", length = 5)
    private String parceiroIdParceiro;

    @Column(name = "empresa_empresa_id")
    private Long empresaEmpresaId;

	public void setIdIa(String id) {
		// TODO Auto-generated method stub
		
	}

	public Object getIdIa() {
		// TODO Auto-generated method stub
		return null;
	}

    // Getters and Setters
}