package github.com.diogenesssantos.apihospital.modelDTOS;

import github.com.diogenesssantos.apihospital.model.ItemAgendamento;

public class ItemAgendamentoDTO {

    private Long id;
    private String tipoConsulta;
    private String protocolos;
    private Boolean ativo;
    
    public ItemAgendamentoDTO() {}
    
    public ItemAgendamentoDTO(Long id, String tipoConsulta, String protocolos, Boolean ativo) {
        this.id = id;
        this.tipoConsulta = tipoConsulta;
        this.protocolos = protocolos;
        this.ativo = ativo;
    }

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public String getProtocolos() {
        return protocolos;
    }

    public void setProtocolos(String protocolos) {
        this.protocolos = protocolos;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
    
    public static ItemAgendamentoDTO create(ItemAgendamento item) {
        return new ItemAgendamentoDTO(item.getId(),
        		item.getTipoConsulta().toString(), 
        		item.getProtocolos() , 
        		item.getAtivo());
    }
}
