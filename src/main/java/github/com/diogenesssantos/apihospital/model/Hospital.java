package github.com.diogenesssantos.apihospital.model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_hospital")
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToMany
    @JoinTable(
        name = "tb_hospital_item_agendamento", // Nome da tabela de associação
        joinColumns = @JoinColumn(name = "hospital_id"), // Chave estrangeira para Hospital
        inverseJoinColumns = @JoinColumn(name = "item_agendamento_id") // Chave estrangeira para ItemAgendamento
    )
    private List<ItemAgendamento> listaAgendamentos;
}
