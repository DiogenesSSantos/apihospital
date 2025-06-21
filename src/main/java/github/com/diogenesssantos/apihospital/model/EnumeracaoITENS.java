package github.com.diogenesssantos.apihospital.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
public enum EnumeracaoITENS {

	CIRURGIA_GERAL("CIRURGIA_GERAL"),
	CIRURGIA_PLASTICA("CIRURGIA_PLASTICA")

	;
	
	private String descricao;
	
	EnumeracaoITENS (String nome) {
		this.descricao = nome;
	}
}
