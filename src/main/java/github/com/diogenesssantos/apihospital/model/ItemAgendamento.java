package github.com.diogenesssantos.apihospital.model;

import java.util.List;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_item_agendamento")
public class ItemAgendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EnumeracaoITENS tipoConsulta;

    private String protocolos;
    private Boolean ativo;
    
    @ManyToMany(mappedBy = "listaAgendamentos", fetch = FetchType.EAGER)
    private List<Hospital> hospitalLista;

    
    public ItemAgendamento() {}
    
    
    private ItemAgendamento (ItemAgendamentoBuilder builder) {
    	this.tipoConsulta = builder.tipoConsulta;
    	this.protocolos = builder.protocolos;
    	this.ativo = builder.ativo;
    	this.hospitalLista = builder.hospitalLista;
    }
    
   	
   
	public Long getId() {
		return id;
	}


	public EnumeracaoITENS getTipoConsulta() {
		return tipoConsulta;
	}


	public String getProtocolos() {
		return protocolos;
	}


	public Boolean getAtivo() {
		return ativo;
	}


	public List<Hospital> getHospitalLista() {
		return hospitalLista;
	}
	
	
	@Override
	public String toString() {
		return "ItemAgendamento [tipoConsulta=" + tipoConsulta + ", protocolos=" + protocolos + ", ativo=" + ativo + "]";
	}
    
   







	/**
	 * @author diogenesssantos
	 * Classe padrão builder. 
	 * 
	 */
	public static class ItemAgendamentoBuilder {
	    private EnumeracaoITENS tipoConsulta;
	    private String protocolos;
	    private Boolean ativo;
	    private List<Hospital> hospitalLista;

		
	    public ItemAgendamentoBuilder() {}
	    
	    public  ItemAgendamentoBuilder setConsulta (EnumeracaoITENS item) {
	    	this.tipoConsulta = item;
	    	return this;
	    }
	    
	    public ItemAgendamentoBuilder setProtocolo (String protocolo) {
	    	this.protocolos = protocolo;
	    	return this;
	    }
		
	    public ItemAgendamentoBuilder setAtivo(Boolean booolean) {
	    	this.ativo = booolean;
	    	return this ;
	    	
	    }
	    
	   public ItemAgendamentoBuilder setHospitais(List<Hospital> listaHospital) {
		   this.hospitalLista = listaHospital;
		   return this;
	   }
	    
	   
	   public ItemAgendamento builder() {
		   return new ItemAgendamento(this);
	   }
	   
	   
	   
	   
	}
	
}
