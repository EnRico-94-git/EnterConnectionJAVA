package br.com.classes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @Column(name = "id_cliente", length = 5)
    private String idCliente;

    @Column(name = "setor_atuando", length = 500)
    private String setorAtuando;

    @Column(name = "cep", length = 9)
    private String cep;

    @Column(name = "temp_atuacao", length = 50)
    private String tempAtuacao;

    @Column(name = "cnpj", length = 14)
    private String cnpj;

	public void setIdCliente(String id) {
		// TODO Auto-generated method stub
		
	}

	public Object getIdCliente() {
		// TODO Auto-generated method stub
		return null;
	}

    // Getters and Setters
}