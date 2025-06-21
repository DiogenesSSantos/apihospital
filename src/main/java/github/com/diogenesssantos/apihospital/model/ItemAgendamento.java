package github.com.diogenesssantos.apihospital.model;

import java.util.List;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    
    @ManyToMany(mappedBy = "listaAgendamentos")
    private List<Hospital> hospitalLista;
}
