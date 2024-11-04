package br.com.enterconnection.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "interface")
public class Interface{  // Renomeado para evitar conflito com a palavra-chave
    @Id
    @Column(name = "id_interface", length = 5)
    private String idInterface;

    @Column(name = "nm_interface", length = 50)
    private String nmInterface;

    @Column(name = "funcionalidade", length = 500)
    private String funcionalidade;

    @Column(name = "estilo", length = 900000000)
    private String estilo;

    @Column(name = "linguas", length = 900000000)
    private String linguas;

    @Column(name = "cliente_id_cliente", length = 5)
    private String clienteIdCliente;

    @Column(name = "ia_id_ia", length = 5)
    private String iaIdIa;

	public void setIdInterface(String id) {
		// TODO Auto-generated method stub
		
	}

	public Object getIdInterface() {
		// TODO Auto-generated method stub
		return null;
	}

    // Getters and Setters
}