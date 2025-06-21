package github.com.diogenesssantos.apihospital.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data

@Entity
@Table(name = "tb_hospital")
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nome;

    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
        name = "tb_hospital_item_agendamento", // Nome da tabela de associação
        joinColumns = @JoinColumn(name = "hospital_id"), // Chave estrangeira para Hospital
        inverseJoinColumns = @JoinColumn(name = "item_agendamento_id") // Chave estrangeira para ItemAgendamento
    )
    private List<ItemAgendamento> listaAgendamentos;

    
    public Hospital() {}
    
    
    private Hospital(HospitalBuilder builder) {
    	this.nome = builder.nome;
    	this.listaAgendamentos = builder.listaAgendamentos;
    	
    	
    }
    
	@Override
	public String toString() {
		return "Hospital [id=" + id + ", nome=" + nome + ", listaAgendamentos=" + listaAgendamentos + "]";
	}
    
	public String getNome() {
		return nome;
	}

	public List<ItemAgendamento> getListaAgendamentos() {
		return listaAgendamentos;
	}






	/**
	 * @author diogenesssantos
	 * Usando o padrão builder para a única maneira de instanciar o Hospital.
	 */
	
	public static class HospitalBuilder {
        private String nome;
        private List<ItemAgendamento> listaAgendamentos;

        public HospitalBuilder() {
            // Construtor vazio, se necessário podemos inicializar alguns valores padrão aqui
        }

        // Método para configurar o nome (com validação)
        public HospitalBuilder setNome(String nome) {
            this.nome = java.util.Objects.requireNonNull(nome, "NOME NÃO PODE SER VÁZIO");
            return this;
        }

        // Método para configurar a lista de agendamentos (com validação)
        public HospitalBuilder setListaAgendamentos(List<ItemAgendamento> listaAgendamentos) {
            this.listaAgendamentos = java.util.Objects.requireNonNull(listaAgendamentos, "PRECISA CONTER PELO MENOS 1 ITEM DE AGENDAMENTO");
            return this;
        }

        // Método que finaliza a construção e retorna o objeto Hospital
        public Hospital build() {
            // Aqui você pode adicionar validações finais, ex:
            // if (this.nome == null) throw new IllegalStateException("Nome é obrigatório!");
            return new Hospital(this);
        }
    }
	
	

    
    
}



