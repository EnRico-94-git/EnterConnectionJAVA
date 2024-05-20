package br.com.classes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "empresa")
public class Empresa {

	    @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empresa_seq")
	    @SequenceGenerator(name = "empresa_seq", sequenceName = "empresa_empresa_id_seq", allocationSize = 1)
	    @Column(name = "empresa_id")
	    private Long empresaId;

	    @Column(name = "id_empresa", length = 5)
	    private String idEmpresa;

	    @Column(name = "cnpj", length = 14)
	    private String cnpj;

	    @Column(name = "cep", length = 9)
	    private String cep;

	    @Column(name = "temp_atuacao", length = 50)
	    private String tempAtuacao;

	    @Column(name = "especializacao", length = 50)
	    private String especializacao;

	    @Column(name = "parceiro_id_parceiro", length = 5)
	    private String parceiroIdParceiro;

	    @Column(name = "cliente_id_cliente", length = 5)
	    private String clienteIdCliente;

		public void setEmpresaId(Long id) {
			// TODO Auto-generated method stub
			
		}

		public Object getEmpresaId() {
			// TODO Auto-generated method stub
			return null;
		}

	    // Getters and Setters
	}	

